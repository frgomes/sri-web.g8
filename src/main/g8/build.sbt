
enablePlugins(ScalaJSPlugin)

name := $name$

scalaVersion := "2.11.8"


resolvers += Resolver.bintrayRepo("scalajs-react-universe", "maven")


libraryDependencies ++= Seq("scalajs-react-universe" %%% "web" % "2017.1.0",
"scalajs-react-universe" %%% "vdom" % "2017.1.0",
  "scalajs-react-universe" %%% "scalacss" % "2017.1.0")


scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature",
  "-language:postfixOps", "-language:implicitConversions",
  "-language:higherKinds", "-language:existentials")


scalaJSModuleKind := ModuleKind.CommonJSModule



/** Custom tasks to generate launcher file in  CommonJSModule mode   */
val SJS_OUTPUT_PATH = "assets/scalajs-output.js"


val fastOptWeb = Def.taskKey[Unit]("Generate web output file for fastOptJS")


    artifactPath in Compile in fastOptJS :=
      baseDirectory.value / SJS_OUTPUT_PATH
    fastOptWeb in Compile := {
      val launcher = (scalaJSLauncher in Compile).value.data.content
      IO.write(baseDirectory.value / "assets/scalajs-output-launcher.js", launcher)
    }


val fullOptWeb = Def.taskKey[Unit]("Generate web output file for fullOptJS")

lazy val fullWebLauncher =
  Seq(
    artifactPath in Compile in fullOptJS :=
      baseDirectory.value / SJS_OUTPUT_PATH,
    fullOptWeb in Compile := {
      (fullOptJS in Compile).value
      val launcher = (scalaJSLauncher in Compile).value.data.content
      IO.write(baseDirectory.value / "assets/scalajs-output-launcher.js", launcher)
    }
  )