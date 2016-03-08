package repos.neo4j.domain

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "DEPENDS_ON")
class DependsOn extends Relation[Function, Function] {
  def this(source: Function, target: Function) = {
    this
    this.source = source
    source.dependsOn.add(this)
    this.target = target
    target.leadsTo.add(this)
  }
}
