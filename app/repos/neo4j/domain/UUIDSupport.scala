package repos.neo4j.domain

import java.util.UUID

trait UUIDSupport extends Entity {
  var uuid: String = UUID.randomUUID.toString
}
