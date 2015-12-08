package com.curiousinternals.typ.model

import java.util.TreeSet

class Concept(
    val id: Long, var name: String,
    var explainedBy: TreeSet[Resource],
    var dependsOn: TreeSet[Concept],
    var leadsTo: TreeSet[Concept]) {

  def this(id: Long, name: String) {
    this(id, name, new TreeSet[Resource],
        new TreeSet[Concept], new TreeSet[Concept])
  }

}
