package repos.neo4j.services

import org.neo4j.ogm.cypher.Filter

import java.util.UUID
import java.util.HashMap

import repos.neo4j.domain.Function

object FunctionService extends GenericService[Function] {
  def getByUUID(uuid: UUID): Option[Function] = {
    val matches = session.loadAll(
        classOf[Function], new Filter("uuid", uuid.toString), 1)

    return Some(matches.iterator.next)
  }

  def getEntityType(): Class[Function] = classOf[Function]
}
