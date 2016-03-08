package controllers

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

class ImplementationSpec extends Specification {

  "The view method" should {
    "return Ok" in {
      val usedUUID = "693df8cf-9343-47d2-b281-af1b150762f0"
      val result = controllers.Implementation.view(usedUUID)(FakeRequest())

      status(result) must equalTo(OK)
    }

    "return NotFound" in {
      val unusedUUID = "00000000-0000-0000-0000-000000000000"
      val result = controllers.Implementation.view(unusedUUID)(FakeRequest())

      status(result) must equalTo(NOT_FOUND)
    }

    "return BadRequest" in {
      val badUUID = "umad?"
      val result = controllers.Implementation.view(badUUID)(FakeRequest())

      status(result) must equalTo(BAD_REQUEST)
    }

  }

}
