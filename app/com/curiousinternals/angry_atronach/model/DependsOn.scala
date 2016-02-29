package com.curiousinternals.angry_atronach.model

class DependsOn(source: Function, target: Function)
    extends Relation[Function, Function](source, target) {
  source.dependsOn += this
  target.leadsTo += this
}
