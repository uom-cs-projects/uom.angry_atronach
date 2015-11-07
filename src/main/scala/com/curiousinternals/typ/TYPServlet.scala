package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport
import org.squeryl.PrimitiveTypeMode._

class TYPServlet extends ThirdYearProjectStack
    with ScalateSupport
    with DatabaseSessionSupport {

  get("/resource/view/:id") {

    contentType="text/html"

    val id: Long = {
      try { params("id").toLong }
      catch { case e: Exception => halt(400) }
    }

    var resource : Option[Resource] = {
      transaction {
        TYPDB.resources.where(r => r.id === id).headOption
  	  }
    }

    resource match {
      case Some(resource) =>
        jade("resource/read",
            "title" -> "Resource Viewer",
            "resource_data" -> resource.content)

      case None => NotFound(s"Resource '${id}' was not found.")
    }
  }

  get("/dev/createDB") {
    transaction {
      TYPDB.create
      TYPDB.resources.insert(
          new Resource(0, "# Stored Resource\n\nSome markdown."))
	  }

    Ok("Database Created!")
  }

}
