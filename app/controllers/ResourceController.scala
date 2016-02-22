package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.data._
import play.api.data.Forms._

import java.util.UUID
import services.ResourceService
import forms.ResourceData
import domain.Resource

object ResourceController extends Controller {

  def view(uuid: String) = Action {
    val resource = ResourceService.getByUUID(UUID.fromString(uuid))

    Ok(views.html.resource.view(resource))
  }

  def edit(uuid: String) = Action {
    ResourceService.getByUUID(UUID.fromString(uuid)) match {
      case resource: Resource => Ok(views.html.resource.edit(resource))
      case _ => {
        val resource = new Resource()
        Ok(views.html.resource.edit(resource))
      }
    }
  }

  def create = Action {
    Redirect(routes.ResourceController.edit(UUID.randomUUID.toString))
  }

  def update(uuid: String) = Action { implicit request =>
    val resourceForm = Form(
      mapping(
        "title" -> nonEmptyText,
        "content" -> nonEmptyText
      )(ResourceData.apply)(ResourceData.unapply))

    resourceForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest("Oh dear!")
      },
      data => {
        var resource = ResourceService.getByUUID(UUID.fromString(uuid)) match {
          case res: Resource => res
          case _ => new Resource()
        }

        resource.title = data.title
        resource.content = data.content
        resource.uuid = uuid

        ResourceService.createOrUpdate(resource)

        Redirect(routes.ResourceController.view(uuid))
      }
    )
  }

}
