package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class FunctionSpec extends Specification {

  "The view method" should {
    "return Ok" in {
      val usedUUID = "bbb43cb2-5655-416c-9e48-886c2d38f5e0"
      val result = controllers.Function.view(usedUUID)(FakeRequest())

      status(result) must equalTo(OK)
    }

    "return NotFound" in {
      val unusedUUID = "00000000-0000-0000-0000-000000000000"
      val result = controllers.Function.view(unusedUUID)(FakeRequest())

      status(result) must equalTo(NOT_FOUND)
    }

    "return BadRequest" in {
      val badUUID = "umad?"
      val result = controllers.Function.view(badUUID)(FakeRequest())

      status(result) must equalTo(BAD_REQUEST)
    }

  }

}
