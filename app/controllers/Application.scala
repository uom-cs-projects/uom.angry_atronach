package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import domain._
import services.ResourceService

object Application extends Controller {

  def index = Action {
    val resources = ResourceService.findAll()

    Ok(views.html.index(resources))
  }
}
