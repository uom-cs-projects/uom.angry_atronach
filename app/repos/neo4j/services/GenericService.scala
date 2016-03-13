package repos.neo4j.services

import java.lang.{Long => JLong}
import java.util.{Collection => JCollection}
import java.util.UUID

import repos.neo4j.domain.UUIDSupport
import repos.neo4j.SessionFactory

import org.neo4j.ogm.cypher.Filter

import repos.neo4j.services.exceptions.UUIDNotUniqueException

abstract class GenericService[E <: UUIDSupport] extends Service[E] {
  private val DEPTH_LIST = 0
  private val DEPTH_ENTITY = 1
  protected val session = SessionFactory.session

  override def findAll(): JCollection[E] = {
    return session.loadAll(getEntityType, DEPTH_LIST)
  }

  override def find(uuid: UUID): Option[E] = {
    val result = session.loadAll(
        getEntityType, new Filter("uuid", uuid.toString), DEPTH_ENTITY)

    if (result.size == 0) {
      return None
    } else if (result.size > 1) {
      throw new UUIDNotUniqueException(
          message = s"'$uuid' matched more than one entity.")
    } else {
      return Some(result.iterator.next)
    }
  }

  override def delete(uuid: UUID) {
    session.delete(session.loadAll(
        getEntityType, new Filter("uuid", uuid.toString)))
  }

  override def createOrUpdate(entity: E): E = {
    session.save(entity, DEPTH_ENTITY)
    find(UUID.fromString(entity.uuid)) match {
      case Some(entity) => {
        return entity
      }
      case None => {
        //throw
        return entity
      }
    }
  }

  def getEntityType(): Class[E]
}
