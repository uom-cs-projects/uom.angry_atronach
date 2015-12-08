package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport
import org.scalatra.scalate.ScalateUrlGeneratorSupport

import com.curiousinternals.typ.model._

class ConceptServlet extends ThirdYearProjectStack {

  val readConcept = get("/read/:id") {

    val id = params("id").toLong

    val concept = new Concept(id, "Advanced Algorithms")

    contentType="text/html"
    jade("concept/read",
        "title" -> s"${concept.name} : Concept",
        "concept" -> concept)
  }

}
