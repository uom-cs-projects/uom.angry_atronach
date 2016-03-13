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
    try {
      FunctionService.find(UUID.fromString(uuid)) match {
        case Some(f) => Ok(views.html.function.view(f))
        case None => NotFound("Oops!")
      }
    } catch {
      case e: IllegalArgumentException =>
          BadRequest(s"'$uuid' is not a valid UUID.")
    }
  }

}
