package com.curiousinternals.angry_atronach.model

import java.util.UUID

trait UUIDSupport extends Entity {
  val uuid: UUID = UUID.randomUUID
}
