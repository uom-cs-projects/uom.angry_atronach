package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport

class ConceptServlet extends ThirdYearProjectStack
    with ScalateSupport {

  get("/read/:id") {

    val id = params("id")

    contentType="text/html"
    jade("concept/read",
        "title" -> "Advanced Algorithms",
        "concept_id" -> id,
        "concept_name" -> "Advanced Algorithms")
  }

}
