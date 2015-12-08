package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport
import org.fusesource.scalate.{ TemplateEngine, Binding }
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import javax.servlet.http.HttpServletRequest
import collection.mutable

trait ThirdYearProjectStack extends ScalatraServlet
    with ScalateSupport {

  notFound {
    serveStaticResource() getOrElse resourceNotFound()
  }

}
