package domain

import org.neo4j.ogm.annotation.{NodeEntity, Relationship}

@NodeEntity
class User(var username: String) extends Entity {
  @Relationship(`type` = "UNDERSTANDS", direction = Relationship.OUTGOING)
  var understands: Set[Understands] = Set()
}
