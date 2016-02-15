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
    Ok(views.html.resource.read(id.toLong))
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
