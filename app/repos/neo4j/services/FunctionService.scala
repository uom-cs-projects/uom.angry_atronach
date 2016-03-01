package repos.neo4j.services

import org.neo4j.ogm.cypher.Filter

import java.util.UUID
import java.util.HashMap

import repos.neo4j.domain.Function

object FunctionService extends GenericService[Function] {
  def getEntityType(): Class[Function] = classOf[Function]
}
