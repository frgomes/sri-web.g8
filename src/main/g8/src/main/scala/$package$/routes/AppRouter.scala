package $package$.routes

import sri.core.ReactElement
import sri.core._
import sri.scalacss.Defaults._
import $package$.components.styles.GlobalStyle
import sri.web.router._
import sri.web.vdom.DOMProps
import sri.web.vdom.tags._
import org.scalajs.dom
import $package$.components.TopNav
import $package$.components.screens.HomeScreen

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav

object AppRouter {

  object HomePage extends WebStaticPage


  object Config extends WebRouterConfig {

    override val history: History = HistoryFactory.browserHistory()

    override val initialRoute: (WebStaticPage, WebRoute) = defineInitialRoute(HomePage, (route: WebRoute) => HomeScreen())


    override val notFound: WebRouteNotFound = WebRouteNotFound(HomePage)

    /**
      * this method is responsible for rendering components ,
      *
      * @param route current route that is pushed to stack
      * @return
      */
    override def renderScene(route: WebRoute): ReactElement = {
      div(new DOMProps {
        className = GlobalStyle.flexOneAndDirectionVertical
      })(
        TopNav(),
        super.renderScene(route)
      )
    }
  }

  val router = WebRouter(Config)
}
