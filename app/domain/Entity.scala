package domain

import org.neo4j.ogm.annotation.GraphId

abstract class Entity {

  @GraphId
  var internalId: java.lang.Long = _

}
