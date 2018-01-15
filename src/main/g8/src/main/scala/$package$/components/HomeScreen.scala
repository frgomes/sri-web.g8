package $package$.components

import org.scalajs.dom
import sri.core.{
  ComponentP,
  CreateElement,
  CreateElementJS,
  CreateElementJSNoInline,
  JSProps,
  ReactElement,
  ReactScalaClass,
  componentConstructor
}
import sri.web.router.RouterScreenComponentNoPSLS
import sri.web.vdom.tagsPrefix_<._
import sri.universal._

import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichGenTraversableOnce
import scala.scalajs.js.{ConstructorTag, |, UndefOr => U}
import scalajscss.{CSSStyleSheet, CSSStyleSheetRegistry}

class HomeScreen extends RouterScreenComponentNoPSLS {
  import HomeScreen._

  CSSStyleSheetRegistry.addToDocument(styles)

  def render() = {
    <.div(className = styles.container)(
      <.h2C("Welcome to Sri Web")
    )
  }

}

object HomeScreen {

  object styles extends CSSStyleSheet {

    import dsl._
    import scalajscss.units._

    val container =
      style(display.flex,
            alignItems.center,
            justifyContent.center,
            flexDirection.column,
            marginTop := 64.px)
  }

}

class InlinedC extends ComponentP[InlinedC.Props] {

  import InlinedC._

  def render() = {
    <.divC(props.id)
  }

}

object InlinedC {
  case class Props(id: Int)
  def apply(props: Props,
            key: String | Int = null,
            ref: js.Function1[InlinedC, Unit] = null) =
    CreateElement[InlinedC](props = props, key = key, ref = ref)
}

class NoInlinedC extends ComponentP[NoInlinedC.Props] {

  def render() = {
    <.divC(props.id)
  }

}

object NoInlinedC {
  case class Props(id: Int)
  def apply(props: Props,
            key: String | Int = null,
            ref: js.Function1[NoInlinedC, Unit] = null) =
    CreateElementNoInline[NoInlinedC](props = props, key = key, ref = ref)
}

object CreateElementNoInline {

  @inline
  def apply[C <: ReactScalaClass: ConstructorTag](
      props: C#ScalaPropsType,
      key: String | Int = null,
      ref: js.Function1[C, Unit] = null): ReactElement { type Instance = C } = {
    CreateElementJS[C](
      componentConstructor[C],
      JSProps(props),
      key = key,
      ref = ref
    )
  }

}
