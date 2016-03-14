package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import repos.neo4j.services.FunctionService

object Graph extends Controller {

  def view = Action {
    val functions = FunctionService.findAll()

    Ok(views.html.graph.view(functions))
  }

}
