package repos.neo4j.domain

import org.neo4j.ogm.annotation.{StartNode, EndNode}

abstract class Relation[S <: Node, T <: Node] extends Entity {

  @StartNode var source: S = _
  @EndNode var target: T = _

}
