package views.implementation

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import repos.neo4j.domain.Implementation

class LinkSpec extends Specification {

  "The link" should {
    "correctly display important information" in {
      val howToAddNumbers = new Implementation("How To Add Two Numbers.")

      val html = views.html.implementation.link(howToAddNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(howToAddNumbers.title)
      contentAsString(html) must contain(howToAddNumbers.uuid)
    }
  }

}
