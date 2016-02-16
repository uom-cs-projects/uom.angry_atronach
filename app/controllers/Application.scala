package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._

import domain._
import repositories.Neo4jSessionFactory
import org.neo4j.ogm.session.transaction.Transaction

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

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

  def db = Action {
    val user = new User("curiousinternals")

    val session = Neo4jSessionFactory.getNeo4jSession()
    val tx: Transaction = session.beginTransaction()

    try {
      session.save(user)
      tx.commit()
    } catch {
      case e: Exception => tx.rollback()
    }


    Ok("User saved?")
  }
}
