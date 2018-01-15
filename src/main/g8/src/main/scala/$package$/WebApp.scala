package $package$

import org.scalajs.dom
import sri.web.ReactDOM

import scalajscss.CSSStyleSheetRegistry

object WebApp {

  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      components.root,
      dom.document.getElementById("app")
    )
  }

}
