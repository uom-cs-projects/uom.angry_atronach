package com.curiousinternals.angry_atronach.model

abstract class Relation [S <: Entity, T <: Entity]
    (val source: S, val target: T)
    extends Entity {}
