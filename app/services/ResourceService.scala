package services

import org.neo4j.ogm.cypher.Filter

import java.util.UUID
import java.util.HashMap

import domain.Resource

object ResourceService extends GenericService[Resource] {
  def getByUUID(uuid: UUID): Resource = {
    val depth = 1
    val filter = new Filter("uuid", uuid.toString)
    val matches = session.loadAll(classOf[Resource], filter, depth)

    return matches.iterator.next
  }

  def getEntityType(): Class[Resource] = classOf[Resource]
}
