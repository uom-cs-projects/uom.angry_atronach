package com.curiousinternals.angry_atronach.model.relationships

import com.curiousinternals.angry_atronach.model.Relation
import com.curiousinternals.angry_atronach.model.entities.{
  Function,
  Implementation
}

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "IMPLEMENTS")
class Implements(source: Implementation, target: Function)
    extends Relation[Implementation, Function](source, target) {
  source.implements += this
  target.implementedBy += this
}
