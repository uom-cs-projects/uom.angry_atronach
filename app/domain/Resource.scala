package domain

import java.util.UUID

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Resource(var content: String) extends Entity {
  val uuid: String = UUID.randomUUID()
}
