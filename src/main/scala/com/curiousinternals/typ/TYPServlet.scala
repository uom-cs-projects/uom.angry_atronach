package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport
import org.squeryl.PrimitiveTypeMode._

class TYPServlet extends ThirdYearProjectStack
    with ScalateSupport
    with DatabaseSessionSupport {

  get("/resource/update/:id") {

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
        contentType="text/html"
        jade("resource/update",
            "title" -> "Update Resource", "resource_data" -> resource.content)

      case None => NotFound(s"Resource '${id}' was not found.")
    }

  }

  /*post("/resource/update/:id") {

    val content: String = params.getOrElse("content", halt(400))

    val id = {
      transaction { TYPDB.resources.insert(new Resource(0, content)) }.id
    }

    redirect(s"/resource/read/${id}")

  }*/

  get("/resource/delete/:id") {

    val id: Long = {
      try { params("id").toLong }
      catch { case e: Exception => halt(400) }
    }

    transaction {
      TYPDB.resources.deleteWhere(r => r.id === id)
    }

    Ok(s"id:'${id}' deleted.")

  }

  get("/resource/read/:id") {

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
        contentType="text/html"
        jade("resource/read",
            "title" -> "Resource Viewer",
            "resource_data" -> resource.content)

      case None => NotFound(s"Resource '${id}' was not found.")
    }

  }

  get("/resource/create") {

    contentType="text/html"
    jade("resource/create", "title" -> "Create Resource")

  }

  post("/resource/create") {

    val content: String = params.getOrElse("content", halt(400))

    val id = {
      transaction { TYPDB.resources.insert(new Resource(0, content)) }.id
    }

    redirect(s"/resource/read/${id}")

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
