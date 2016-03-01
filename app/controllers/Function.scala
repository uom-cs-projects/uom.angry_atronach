package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import java.util.UUID
import repos.neo4j.services.FunctionService
import repos.neo4j.domain.Function



object Function extends Controller {

  def view(uuid: String) = Action {
    val function = FunctionService.getByUUID(UUID.fromString(uuid))

    function match {
      case Some(f) => Ok(views.html.function.view(f))
      case None => NotFound("Oops!")
    }
  }

}
