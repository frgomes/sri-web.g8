package $package$.components

import sri.core._
import sri.web.all._
import sri.web.vdom.DOMProps
import sri.web.vdom.tags._

import scala.scalajs.js

object Button {

  val Component = (props: Props,children : ReactElement) => {
    div(new DOMProps { className = props.style; onClick = js.defined((e: ReactMouseEventH) => props.onPress())})(children)
  }

  case class Props(style: String, onPress: () => Unit)

  def apply(style: String, onPress: () => Unit,key : js.UndefOr[String] = js.undefined)(children : ReactNode*) = createStatelessFunctionElementWithChildren(Component, Props(style, onPress),key = key)(children : _*)

}
