package domain

import java.util.UUID

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class Resource(var title: String, var content: String) extends Entity {
  val uuid: String = UUID.randomUUID.toString

  @Relationship(`type` = "DEPENDS_ON", direction = "OUTGOING")
  var prerequisites: Set[DependsOn] = Set()

  @Relationship(`type` = "DEPENDS_ON", direction = "INCOMING")
  var dependents: Set[DependsOn] = Set()

  @Relationship(`type` = "UNDERSTANDS", direction = "INCOMING")
  var understoodBy: Set[Understands] = Set()
}
