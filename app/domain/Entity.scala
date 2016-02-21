package domain

import org.neo4j.ogm.annotation.GraphId

import java.lang.{Long => JLong}

abstract class Entity {

  @GraphId
  var graphId: JLong = null

  override def equals(o: Any): Boolean = o match {
    case other: Entity => other.graphId.equals(this.graphId)
    case _ => false
  }

  override def hashCode: Int = graphId match {
    case id: JLong => graphId.hashCode()
    case _ => -1
  }

}
