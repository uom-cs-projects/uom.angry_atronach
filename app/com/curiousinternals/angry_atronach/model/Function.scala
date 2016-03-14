package com.curiousinternals.angry_atronach.model

import java.util.UUID
import scala.collection.mutable.Set

class Function(var description: String, override val uuid: UUID)
    extends Node with UUIDSupport {

  var dependsOn: Set[DependsOn] = _
  var leadsTo: Set[DependsOn] = _
  var implementedBy: Set[Implements] = _

}
