package domain

import org.neo4j.ogm.annotation.{RelationshipEntity, StartNode, EndNode}

@RelationshipEntity(`type` = "UNDERSTANDS")
class Understands() extends Entity {

  @StartNode
  var user: User = _

  @EndNode
  var resource: Resource = _

  def this(user: User, resource: Resource) {
    this
    this.user = user
    this.resource = resource

    user.understands.add(this)
    resource.understoodBy.add(this)
  }

}
