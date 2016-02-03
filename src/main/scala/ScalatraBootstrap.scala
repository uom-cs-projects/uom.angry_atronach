import com.curiousinternals.angry_atronach._
import org.scalatra.LifeCycle
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle with DatabaseInit {
  override def init(context: ServletContext) {
    configureDb()
    context.mount(new TempServlet, "/*")
    context.mount(new ConceptServlet, "/concept/*")
  }

  override def destroy(context: ServletContext) {
    closeDbConnection()
  }
}
