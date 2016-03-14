package repos.neo4j

import scala.util.Properties

import org.neo4j.ogm.session.{Session, SessionFactory}

object SessionFactory {
  val sessionFactory = new SessionFactory("repos.neo4j.domain")

  def session: Session = {
    val url = Properties.envOrElse(
        "GRAPHENEDB_URL",
        "http://neo4j:ram-rock-axe-towel-purple@localhost:7474")

    return sessionFactory.openSession(url)
  }
}
