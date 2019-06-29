enablePlugins(ScalaJSPlugin)

name := "$name$"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "web-bundle" % "2019.06.26"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-Xmacro-settings:classNameShrink=components"
)

scalaJSUseMainModuleInitializer := true

scalaJSUseMainModuleInitializer in Test := true

scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule))

resolvers ++= Seq(Resolver.bintrayRepo("scalajs-react-interface", "maven"),
 Resolver.bintrayRepo("scalajs-css", "maven"),
 Resolver.bintrayRepo("scalajs-jest", "maven"))

/** Custom tasks to generate launcher file in  CommonJSModule mode   */
val SJS_OUTPUT_PATH = "static/scalajs-output.js"

artifactPath in Compile in fastOptJS :=
  baseDirectory.value / SJS_OUTPUT_PATH

artifactPath in Compile in fullOptJS :=
  baseDirectory.value / SJS_OUTPUT_PATH

