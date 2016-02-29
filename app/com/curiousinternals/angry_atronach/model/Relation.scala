package com.curiousinternals.angry_atronach.model

import org.neo4j.ogm.annotation.{StartNode, EndNode}

/*abstract class Relation[S <: Entity, T <: Entity]
    (val source: S, val target: T) {}*/

abstract class Relation[S <: Node, T <: Node] extends Entity {
  @StartNode var source: S = _
  @EndNode var target: T = _

  def this(source: S, target: T) {
    this
    this.source = source
    this.target = target
  }
}
