package repos.neo4j.domain

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "DEPENDS_ON")
class DependsOn extends Relation[Function, Function] {}
