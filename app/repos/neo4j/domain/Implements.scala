package repos.neo4j.domain

import org.neo4j.ogm.annotation.RelationshipEntity

@RelationshipEntity(`type` = "IMPLEMENTS")
class Implements extends Relation[Implementation, Function] {}
