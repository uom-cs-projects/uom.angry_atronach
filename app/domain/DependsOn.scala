package domain

import org.neo4j.ogm.annotation.{RelationshipEntity, StartNode, EndNode}

@RelationshipEntity(`type` = "DEPENDS_ON")
class DependsOn(
  @StartNode var dependent: Resource,
  @EndNode var prerequisite: Resource
) extends Entity {

    dependent.prerequisites += this
    prerequisite.dependents += this

}
