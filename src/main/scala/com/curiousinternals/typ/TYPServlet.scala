package com.curiousinternals.typ

import org.scalatra._
import scalate.ScalateSupport

class TYPServlet extends ThirdYearProjectStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

}
