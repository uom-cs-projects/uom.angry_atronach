package domain

import java.util.UUID
import java.util.Set

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class Resource() extends Entity {
  var uuid: String = UUID.randomUUID.toString

  var title: String = _
  var content: String = _

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.OUTGOING)
  var prerequisites: Set[DependsOn] = _

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.INCOMING)
  var dependents: Set[DependsOn] = _

  @Relationship(`type` = "UNDERSTANDS", direction = Relationship.INCOMING)
  var understoodBy: Set[Understands] = _

  def this(title: String, content: String) {
    this
    this.title = title
    this.content = content
  }

  def this(uuid: UUID, title: String, content: String) {
    this(title, content)
    this.uuid = uuid.toString
  }
}
