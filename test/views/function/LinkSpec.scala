package views.function

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import repos.neo4j.domain.Function

class LinkSpec extends Specification {

  "The link" should {
    "correctly display important information" in {
      val addNumbers = new Function("Add two numbers.")

      val html = views.html.function.link(addNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(addNumbers.description)
      contentAsString(html) must contain(addNumbers.uuid)
    }
  }

}
