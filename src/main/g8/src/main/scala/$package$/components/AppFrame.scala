package $package$.components

import sri.core.{
  ComponentNoPS,
  CreateElementNoPropsWithChildren,
  ReactElementNode
}
import sri.universal._
import sri.web.vdom.tagsPrefix_<._

import scala.scalajs.js.JSConverters.genTravConvertible2JSRichGenTrav
import scalajscss.{CSSStyleSheet, CSSStyleSheetRegistry}

class AppFrame extends ComponentNoPS {
  import AppFrame._

  CSSStyleSheetRegistry.addToDocument(styles)

  def render() = {
    <.div(className = styles.container)(
      TopNav(),
      <.div(className = styles.content)(
        children
      ),
      <.footer(className = styles.footer)(
        <.hr(),
        <.divC("Built with శ్రీ (Sri)")
      )
    )
  }

}

object AppFrame {

  object styles extends CSSStyleSheet {
    import dsl._
    import scalajscss.units._
    import scalajscss.units._
    val container = style(display.flex,
                          flexDirection.column,
                          width := 100.%%,
                          height := 100.vh)

    val content = style(flex := "auto", paddingTop := 64.px)

    val footer = style(height := 64.px, textAlign := "center")

    styleSuffix(footer, " hr")(opacity := "0.4")

    styleSuffix(footer, " div")(fontWeight.bold, marginTop := 20.px)
  }

  def apply(children: ReactElementNode*) =
    CreateElementNoPropsWithChildren[AppFrame](children = children.toJSArray)

}
