package com.curiousinternals.angry_atronach.model.entities

import com.curiousinternals.angry_atronach.model.{Node, UUIDSupport}
import com.curiousinternals.angry_atronach.model.relationships.Implements

import org.neo4j.ogm.annotation.Relationship

import scala.collection.mutable.Set

class Implementation extends Node with UUIDSupport {

  var source: String = _

  @Relationship(`type` = "IMPLEMENTS", direction = Relationship.OUTGOING)
  var implements: Set[Implements] = _

}
