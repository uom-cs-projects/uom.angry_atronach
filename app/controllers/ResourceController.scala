package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import java.util.UUID
import services.ResourceService

object ResourceController extends Controller {

  def resource(uuid: String) = Action {
    val resource = ResourceService.getByUUID(UUID.fromString(uuid))

    Ok(views.html.resource.read(
        resource.uuid,
        resource.title,
        resource.content))
  }

}
