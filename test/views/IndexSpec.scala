package views

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import repos.neo4j.domain.Function
import collection.mutable.Set
import collection.JavaConversions._

class IndexSpec extends Specification {

  "The view" should {
    "contain a list of functions" in {
      val addNumbers = new Function("Add two numbers.")
      addNumbers.graphId = 0

      val multiplyNumbers = new Function("Multiply two numbers.")
      multiplyNumbers.graphId = 1

      val html = views.html.index(Set(addNumbers, multiplyNumbers))

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(addNumbers.description)
      contentAsString(html) must contain(addNumbers.uuid)
      contentAsString(html) must contain(multiplyNumbers.description)
      contentAsString(html) must contain(multiplyNumbers.uuid)
    }

    "say there are no functions" in {
      val html = views.html.index(null)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain("There are no functions.")
    }
  }

}
