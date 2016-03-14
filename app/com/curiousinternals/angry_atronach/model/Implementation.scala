package com.curiousinternals.angry_atronach.model

import java.util.UUID
import scala.collection.mutable.Set

class Implementation(var source: String, override val uuid: UUID)
    extends Node with UUIDSupport {

  var implements: Set[Implements] = _

}
