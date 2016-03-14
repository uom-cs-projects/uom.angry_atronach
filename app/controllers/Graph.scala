package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.libs.json._

import java.util.HashSet
import collection.JavaConversions._
import repos.neo4j.services.FunctionService
import repos.neo4j.domain.{DependsOn, Function}

object Graph extends Controller {

  def view = Action {
    val functions = FunctionService.findAll()

    Ok(views.html.graph.view())
  }

  def json = Action {
    val functions = FunctionService.findAll(1)

    var dependencies: HashSet[DependsOn] = new HashSet
    for(f <- functions) {
      if (f.dependsOn != null)
        dependencies.addAll(f.dependsOn)
    }

    val nodes = functions.map(f => {
      Json.obj(
        "uuid" -> f.uuid.toString,
        "description" -> f.description
      )
    })

    val links = dependencies.map(d => {
      Json.obj(
        "source" -> d.source.uuid.toString,
        "target" -> d.target.uuid.toString
      )
    })

    val json: JsValue = Json.obj(
      "nodes" -> nodes,
      "links" -> links
    )

    Ok(json)
  }

}
