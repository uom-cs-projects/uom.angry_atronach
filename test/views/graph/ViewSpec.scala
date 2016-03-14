package views.graph

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ViewSpec extends Specification {

  "The graph view" should {
    "display a loading message initially" in {
      val html = views.html.graph.view()

      contentType(html) must equalTo("text/html")
      contentAsString(html) must contain("Loading...")
    }
  }

}
