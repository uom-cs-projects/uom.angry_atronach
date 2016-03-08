package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ApplicationSpec extends Specification {

  "The index method" should {
    "return Ok" in {
      val result = controllers.Application.index(FakeRequest())
      
      status(result) must equalTo(OK)
    }
  }

}
