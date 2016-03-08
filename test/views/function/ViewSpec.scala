package views.function

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

import repos.neo4j.domain.{DependsOn, Function, Implementation, Implements}

import java.util.HashSet

class ViewSpec extends Specification {

  "The view" should {
    "contain a list of implementations" in {
      val howToAddNumbers = new Implementation("How To Add Two Numbers")
      howToAddNumbers.implements = new HashSet


      val addNumbers = new Function("Add two numbers.")
      addNumbers.implementedBy = new HashSet

      val relation = new Implements(howToAddNumbers, addNumbers)

      val html = views.html.function.view(addNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(howToAddNumbers.title)
      contentAsString(html) must contain("No dependencies.")
      contentAsString(html) must contain("Doesn't unlock anything.")
    }

    "say there are no implementations, functions depended on or lead to" in {
      val addNumbers = new Function("Add two numbers.")

      val html = views.html.function.view(addNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain("No implementations.")
      contentAsString(html) must contain("No dependencies.")
      contentAsString(html) must contain("Doesn't unlock anything.")
    }

    "contain a list of dependencies" in {
      val recogniseNumbers = new Function("Recognise a number.")
      recogniseNumbers.leadsTo = new HashSet

      val addNumbers = new Function("Add two numbers.")
      addNumbers.dependsOn = new HashSet


      val relation = new DependsOn(addNumbers, recogniseNumbers)

      val html = views.html.function.view(addNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(recogniseNumbers.description)
      contentAsString(html) must contain("No implementations.")
      contentAsString(html) must contain("Doesn't unlock anything.")
    }

    "contain a list of functions lead to" in {
      val recogniseNumbers = new Function("Recognise a number.")
      recogniseNumbers.leadsTo = new HashSet

      val addNumbers = new Function("Add two numbers.")
      addNumbers.dependsOn = new HashSet


      val relation = new DependsOn(addNumbers, recogniseNumbers)

      val html = views.html.function.view(recogniseNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(addNumbers.description)
      contentAsString(html) must contain("No implementations.")
      contentAsString(html) must contain("No dependencies.")
    }

    "display the details of the function" in {
      val addNumbers = new Function("Add two numbers.")

      val html = views.html.function.view(addNumbers)

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain(addNumbers.uuid)
      contentAsString(html) must contain(addNumbers.description)
    }
  }

}
