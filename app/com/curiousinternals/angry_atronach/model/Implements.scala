package com.curiousinternals.angry_atronach.model

class Implements(source: Implementation, target: Function)
    extends Relation[Implementation, Function](source, target) {
  source.implements += this
  target.implementedBy += this
}
