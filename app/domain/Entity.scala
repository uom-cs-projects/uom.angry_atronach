package domain

import org.neo4j.ogm.annotation.GraphId

abstract class Entity {

  @GraphId
  var graphId: java.lang.Long = _

  override def equals(o: Any): Boolean = o match {
    case other: Entity => other.graphId.equals(this.graphId)
    case _ => false
  }

  override def hashCode: Int = graphId match {
    case id: java.lang.Long => graphId.hashCode()
    case _ => -1
  }

}
