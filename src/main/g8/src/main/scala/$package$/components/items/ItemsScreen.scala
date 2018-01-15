package $package$.components.items

import sri.web.router.RouterScreenComponentNoPSLS

import scalajscss.{CSSStyleSheet, CSSStyleSheetRegistry}

class ItemsScreen extends RouterScreenComponentNoPSLS {

  import ItemsScreen._

  CSSStyleSheetRegistry.addToDocument(styles)

  def render() = {
    ItemsFrame("Please select an item from left list")
  }
}

object ItemsScreen {

  object styles extends CSSStyleSheet {

    import dsl._

    import scalajscss.units._

    val container = style(display.flex, flex := "1")

  }

}
