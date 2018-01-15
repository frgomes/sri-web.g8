package $package$.components.items

import sri.core.{ComponentP, CreateElement}
import sri.web.vdom.tagsPrefix_<._

import scalajscss.{CSSStyleSheet, CSSStyleSheetRegistry}

class ItemsFrame extends ComponentP[ItemsFrame.Props] {

  import ItemsFrame._

  CSSStyleSheetRegistry.addToDocument(styles)

  def render() = {
    <.div(className = styles.container)(
      ItemsNav(),
      <.div(className = styles.infoContainer)(
        <.h2C(props.info)
      )
    )
  }
}

object ItemsFrame {

  case class Props(info: String)

  object styles extends CSSStyleSheet {

    import dsl._

    import scalajscss.units._

    val container = style(display.flex)
    val infoContainer =
      style(display.flex, justifyContent.center, alignItems.center, flex := "1")

  }

  def apply(text: String) = CreateElement[ItemsFrame](Props(text))

}
