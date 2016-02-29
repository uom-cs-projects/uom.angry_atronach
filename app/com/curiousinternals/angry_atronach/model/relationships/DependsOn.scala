package com.curiousinternals.angry_atronach.model.relationships

import com.curiousinternals.angry_atronach.model.Relation
import com.curiousinternals.angry_atronach.model.entities.Function

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "DEPENDS_ON")
class DependsOn(source: Function, target: Function)
    extends Relation[Function, Function](source, target) {
  source.dependsOn += this
  target.leadsTo += this
}
