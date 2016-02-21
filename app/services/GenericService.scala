package services

import java.lang.{Long => JLong}
import java.util.{Collection => JCollection}

import domain.Entity
import repositories.Neo4jSessionFactory

abstract class GenericService[E <: Entity] extends Service[E] {
  private val DEPTH_LIST = 0
  private val DEPTH_ENTITY = 1
  protected val session = Neo4jSessionFactory.getNeo4jSession

  override def findAll(): JCollection[E] = {
    return session.loadAll(getEntityType, DEPTH_LIST)
  }

  override def find(graphId: JLong): E = {
    return session.load(getEntityType, graphId, DEPTH_ENTITY)
  }

  override def delete(graphId: JLong) {
    session.delete(session.load(getEntityType, graphId))
  }

  override def createOrUpdate(entity: E): E = {
    session.save(entity, DEPTH_ENTITY)
    return find(entity.graphId)
  }

  def getEntityType(): Class[E]
}
