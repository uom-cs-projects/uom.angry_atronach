package com.curiousinternals.typ

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.{KeyedEntity, Schema}
import org.squeryl.annotations.Column

class Resource (val id: Long, var content: String) extends KeyedEntity[Long] {}

object TYPDB extends Schema {

  // Define tables
  val resources = table[Resource]

  // Table properties
  on(resources)(r => declare(
    r.id is(unique, autoIncremented)
  ))

}
