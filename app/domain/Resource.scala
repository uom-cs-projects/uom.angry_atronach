package domain

import java.util.UUID

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class Resource(var title: String, var content: String) extends Entity {
  val uuid: String = UUID.randomUUID.toString

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.OUTGOING)
  var prerequisites: Set[DependsOn] = Set()

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.INCOMING)
  var dependents: Set[DependsOn] = Set()

  @Relationship(`type` = "UNDERSTANDS", direction = Relationship.INCOMING)
  var understoodBy: Set[Understands] = Set()
}
