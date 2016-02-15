package repositories

import scala.util.Properties

import org.neo4j.ogm.session.{Session, SessionFactory}

object Neo4jSessionFactory {
  val sessionFactory = new SessionFactory("domain")

  def getNeo4jSession(): Session = {
    val url = Properties.envOrElse(
        "GRAPHENEDB_URL",
        "http://neo4j:ram-rock-axe-towel-purple@localhost:7474")
        
    sessionFactory.openSession(url)
  }
}
