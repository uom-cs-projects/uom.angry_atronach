package repos.neo4j.services

import java.lang.{Long => JLong}
import java.util.{Collection => JCollection}

trait Service[T] {
  def findAll(): JCollection[T]
  def find(graphId: JLong): T
  def delete(graphId: JLong)
  def createOrUpdate(o: T): T
}
