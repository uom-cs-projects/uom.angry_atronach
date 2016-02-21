package domain

import java.util.UUID

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class Resource() extends Entity {
  val uuid: String = UUID.randomUUID.toString

  var title: String = _
  var content: String = _

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.OUTGOING)
  var prerequisites: Set[DependsOn] = Set()

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.INCOMING)
  var dependents: Set[DependsOn] = Set()

  @Relationship(`type` = "UNDERSTANDS", direction = Relationship.INCOMING)
  var understoodBy: Set[Understands] = Set()

  def this(title: String, content: String) {
    this
    this.title = title
    this.content = content
  }
}
