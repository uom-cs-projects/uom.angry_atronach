package domain

import org.neo4j.ogm.annotation.GraphId

abstract class Entity {

  @GraphId
  var id: java.lang.Long = _

}
