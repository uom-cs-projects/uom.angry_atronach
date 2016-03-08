package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import repos.neo4j.services.FunctionService

object Application extends Controller {

  def index = Action {
    val functions = FunctionService.findAll()

    Ok(views.html.index(functions))
  }
}
