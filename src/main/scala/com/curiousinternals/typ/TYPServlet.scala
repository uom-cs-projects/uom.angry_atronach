package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport

class TYPServlet extends ThirdYearProjectStack with ScalateSupport {

  get("/resource/view") {
    contentType="text/html"
    jade("resource/read",
        "title" -> "Resource Viewer",
        "resource_name" -> "Test Resource Name",
        "resource_data" -> "# Heading\n\nSome markdown content.")
  }

}
