package repos.neo4j.services.exceptions

class UUIDNotUniqueException(
      message: String = "A UUID matched more than one entity.")
    extends RuntimeException(message)
