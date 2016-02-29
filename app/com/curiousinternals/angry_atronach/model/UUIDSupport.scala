package com.curiousinternals.angry_atronach.model

import java.util.UUID

trait UUIDSupport extends Entity {
  var uuid: String = UUID.randomUUID.toString
}
