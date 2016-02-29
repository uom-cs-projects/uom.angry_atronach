package com.curiousinternals.angry_atronach.model.entities

import com.curiousinternals.angry_atronach.model.{Node, UUIDSupport}
import com.curiousinternals.angry_atronach.model.relationships.{
  DependsOn,
  Implements
}

import org.neo4j.ogm.annotation.Relationship

import scala.collection.mutable.Set

class Function extends Node with UUIDSupport {

  var description: String = _

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.OUTGOING)
  var dependsOn: Set[DependsOn] = _

  @Relationship(`type` = "DEPENDS_ON", direction = Relationship.INCOMING)
  var leadsTo: Set[DependsOn] = _

  @Relationship(`type` = "IMPLEMENTS", direction = Relationship.INCOMING)
  var implementedBy: Set[Implements] = _

}
