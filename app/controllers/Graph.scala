package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current



object Graph extends Controller {

  def view = Action {
    Ok(views.html.graph.view())
  }

}
