package domain

import org.neo4j.ogm.annotation.{RelationshipEntity, StartNode, EndNode}

@RelationshipEntity(`type` = "UNDERSTANDS")
class Understands(
  @StartNode var user: User,
  @EndNode var resource: Resource
) extends Entity {

  user.understands += this
  resource.understoodBy += this

}
