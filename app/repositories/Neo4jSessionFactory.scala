package repositories

import org.neo4j.ogm.session.{Session, SessionFactory}

object Neo4jSessionFactory {
  val sessionFactory = new SessionFactory("domain")

  def getNeo4jSession(): Session = {
    System.setProperty("username", "neo4j")
    System.setProperty("password", "ram rock axe towel purple")
    sessionFactory.openSession("http://localhost:7474")
  }
}
