package repos.neo4j.domain

import org.neo4j.ogm.annotation.Relationship

import java.util.Set

class Implementation extends Node with UUIDSupport {

  var title: String = _
  var source: String = _

  @Relationship(`type` = "IMPLEMENTS", direction = Relationship.OUTGOING)
  var implements: Set[Implements] = _

  def this(title: String) = {
    this
    this.title = title
  }

  def this(title: String, source: String) = {
    this(title)
    this.source = source
  }
}
