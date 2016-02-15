package domain

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class User(var username: String) extends Entity {}
