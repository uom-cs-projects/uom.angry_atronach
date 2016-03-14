package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class GraphSpec extends Specification {

  "The view method" should {
    "return Ok" in {
      val result = controllers.Graph.view()(FakeRequest())
      status(result) must equalTo(OK)
    }
  }

  "The json method" should {
    "return Ok" in {
      val result = controllers.Graph.view()(FakeRequest())

      status(result) must equalTo(OK)
    }
  }

}
