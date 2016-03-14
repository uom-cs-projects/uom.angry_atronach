package repos.neo4j.services

import org.neo4j.ogm.cypher.Filter

import java.util.UUID
import java.util.HashMap

import repos.neo4j.domain.Implementation

object ImplementationService extends GenericService[Implementation] {
  def getEntityType(): Class[Implementation] = classOf[Implementation]
}
