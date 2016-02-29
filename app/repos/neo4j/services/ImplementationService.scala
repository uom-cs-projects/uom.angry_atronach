package repos.neo4j.services

import org.neo4j.ogm.cypher.Filter

import java.util.UUID
import java.util.HashMap

import repos.neo4j.domain.Implementation

object ImplementationService extends GenericService[Implementation] {
  def getByUUID(uuid: UUID): Option[Implementation] = {
    val matches = session.loadAll(
        classOf[Implementation], new Filter("uuid", uuid.toString), 1)

    return Some(matches.iterator.next)
  }

  def getEntityType(): Class[Implementation] = classOf[Implementation]
}
