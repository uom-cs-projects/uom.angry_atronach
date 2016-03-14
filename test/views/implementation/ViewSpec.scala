package views.implementation

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import repos.neo4j.domain.{Function, Implementation, Implements}

import java.util.HashSet

class ViewSpec extends Specification {

  "The view" should {
    "contain a list of functions implemented" in {
      val howToAddNumbers = new Implementation("How To Add Two Numbers")
      howToAddNumbers.implements = new HashSet


      val addNumbers = new Function("Add two numbers.")
      addNumbers.implementedBy = new HashSet

      val relation = new Implements(howToAddNumbers, addNumbers)

      val html = views.html.implementation.view(howToAddNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(addNumbers.description)
    }

    "say there are no functions implemented" in {
      val howToAddNumbers = new Implementation("How To Add Two Numbers")

      val html = views.html.implementation.view(howToAddNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain("No functions are implemented.")
    }

    "display the details of the implementation" in {
      val howToAddNumbers = new Implementation(
          "How To Add Two Numbers",
          "This is a description of how to add two numbers.")

      val html = views.html.implementation.view(howToAddNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(howToAddNumbers.uuid)
      contentAsString(html) must contain(howToAddNumbers.title)
      contentAsString(html) must contain(howToAddNumbers.source)
    }
  }

}
