package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport
import org.squeryl.PrimitiveTypeMode._

class TYPServlet extends ThirdYearProjectStack
    with ScalateSupport
    with DatabaseSessionSupport {

  get("/resource/view") {
    contentType="text/html"
    jade("resource/read",
        "title" -> "Resource Viewer",
        "resource_name" -> "Test Resource Name",
        "resource_data" -> "# Heading\n\nSome markdown content.")
  }

  get("/utilities/createDB") {
    transaction {
      TYPDB.create
      TYPDB.resources.insert(
          new Resource(0, "# Stored Resource\n\nSome markdown."))
	  }
    <html>
      <body>
        <p>Database Created</p>
      </body>
    </html>
  }

  get("/persistent/resource/view/:id") {
    transaction {
      val r: Resource = TYPDB.resources.where(
          resource => resource.id === params("id").toLong).single

      contentType="text/html"
      jade("resource/read",
        "title" -> "Persistent Resource Viewer",
        "resource_name" -> s"Persistent Resource ${r.id}",
        "resource_data" -> r.content)
	  }
  }

}
