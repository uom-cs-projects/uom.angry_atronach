package repos.neo4j.domain

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "IMPLEMENTS")
class Implements extends Relation[Implementation, Function] {
  def this(source: Implementation, target: Function) = {
    this
    this.source = source
    source.implements.add(this)
    this.target = target
    target.implementedBy.add(this)
  }
}
