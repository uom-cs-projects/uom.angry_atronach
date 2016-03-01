package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import java.util.UUID
import repos.neo4j.services.ImplementationService
import repos.neo4j.domain.Implementation



object Implementation extends Controller {

  def view(uuid: String) = Action {
    val implementation = ImplementationService.find(UUID.fromString(uuid))

    implementation match {
      case Some(i) => Ok(views.html.implementation.view(i))
      case None => NotFound("Oops!")
    }
  }

}
