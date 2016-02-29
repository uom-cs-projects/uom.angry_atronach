package com.curiousinternals.angry_atronach.model

import java.lang.{Long => JLong}

import org.neo4j.ogm.annotation.GraphId

abstract class Entity {
  @GraphId var graphId: JLong = _

  override def equals(o: Any): Boolean = o match {
    case other: Entity => other.graphId.equals(this.graphId)
    case _ => false
  }

  override def hashCode: Int = graphId match {
    case id: JLong => graphId.hashCode()
    case _ => -1
  }
}
