package domain

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class User() extends Entity {

  var username: String = _

  @Relationship(`type` = "UNDERSTANDS", direction = Relationship.OUTGOING)
  var understands: Set[Understands] = Set()

  def this(username: String) {
    this
    this.username = username
  }
}
