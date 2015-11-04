package com.curiousinternals.typ

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.{KeyedEntity, Schema}
import org.squeryl.annotations.Column

class Resource (val id: Long, var content: String) extends KeyedEntity[Long] {}

object TYPDB extends Schema {

  val resources = table[Resource]

  on(resources)(r => declare(
    r.id is(unique, autoIncremented)
  ))

}
