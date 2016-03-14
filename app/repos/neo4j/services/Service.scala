package repos.neo4j.services

import java.util.UUID
import java.util.{Collection => JCollection}

trait Service[T] {
  def findAll(depth: Int): JCollection[T]

  def find(uuid: UUID): Option[T]
  def delete(uuid: UUID)
  def createOrUpdate(o: T): T
}
