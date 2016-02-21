package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import domain._
import repositories.Neo4jSessionFactory
import org.neo4j.ogm.session.transaction.Transaction

object Resource extends Controller {

  def resource(id: String) = Action {
    val session = Neo4jSessionFactory.getNeo4jSession()
    val query =
        "MATCH (r:Resource) WHERE r.uuid = {uuid} RETURN r.title, r.content";
    var parameters = new java.util.HashMap[String, String]()
    parameters.put("uuid", id)

    val result = session.query(query, parameters)
    val test = result.queryResults
    val resource = result.queryResults.iterator.next()
    val title = (resource get "r.title").asInstanceOf[String]
    val content = (resource get "r.content").asInstanceOf[String]

    Ok(views.html.resource.read(id, title, content))
  }

}
