package $package$.components.screens

import $package$.components.styles.GlobalStyle
import sri.web.all._
import sri.web.vdom.tags._
import sri.core._
import sri.universal.components._
import sri.web.all._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{undefined, UndefOr => U}
import scalacss.Defaults._
import sri.scalacss.Defaults._
import sri.web.vdom.DOMProps

object HomeScreen {

  @ScalaJSDefined
  class Component extends ReactComponent[Unit, Unit] {
    def render() = {
      div(new DOMProps {
        className = GlobalStyle.flexOneAndCenter
      })(
        span(new DOMProps {
          className = GlobalStyle.bigText
        })("Home Screen")
      )
    }
  }

  def apply(key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, Unit] = null) = makeElementNoProps[Component](key = key, ref = ref)

}
