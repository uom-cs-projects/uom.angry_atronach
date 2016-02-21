package domain

import org.neo4j.ogm.annotation.{RelationshipEntity, StartNode, EndNode}

@RelationshipEntity(`type` = "DEPENDS_ON")
class DependsOn() extends Entity {

  @StartNode
  var dependent: Resource = _

  @EndNode
  var prerequisite: Resource = _

  def this(dependent: Resource, prerequisite: Resource) {
    this
    this.dependent = dependent
    this.prerequisite = prerequisite

    dependent.prerequisites.add(this)
    prerequisite.dependents.add(this)
  }

}
