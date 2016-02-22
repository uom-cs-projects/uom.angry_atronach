package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import domain.DependsOn

object DependsOnController extends Controller {

  def create(uuidDependant: String) = Action {
    Redirect(routes.ResourceController.view(uuidDependant))
  }

  def delete(uuidDependant: String, uuidPrerequisite: String) = Action {
    Redirect(routes.ResourceController.view(uuidDependant))
  }

}
