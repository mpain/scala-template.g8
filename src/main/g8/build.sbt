import sbt._
import versions.Version

lazy val buildSettings = Seq(
  organization := "$organization$",
  scalaVersion := "$scala_version$"
)

lazy val commonSettings = Seq(
  scalacOptions ++= commonScalacOptions,
  libraryDependencies ++= Seq(
    compilerPlugin("org.spire-math" %% "kind-projector" % Version.KindProjector),
    compilerPlugin("org.scalamacros" % "paradise" % Version.MacroParadise cross CrossVersion.full)
  )
)

lazy val $name;format="camel"$Settings = commonSettings ++ buildSettings ++ dependencies.libs

lazy val $name;format="camel"$ = project
  .in(file("."))
  .enablePlugins(PackPlugin)
  .enablePlugins(BuildInfoPlugin)
  .settings(moduleName := "$name;format="normalize"$", name := "$name$")
  .settings($name;format="camel"$Settings)
  .settings(noPublishSettings)

lazy val buildInfoSettings = Seq(
  buildInfoKeys := Seq[BuildInfoKey](name, organization, version, scalaVersion),
  buildInfoPackage := "ru.mail.money.build"
)

lazy val commonScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:experimental.macros",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Ypartial-unification"
)

lazy val noPublishSettings = Seq(publish := ((): Unit), publishLocal := ((): Unit), publishArtifact := false)

addCommandAlias("validate", ";clean;test")

