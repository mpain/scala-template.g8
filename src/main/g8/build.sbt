name := "$name;format="normalize"$"
organization := "$organization$"
version := "$version$"

scalaVersion in ThisBuild := "$scala_version$"

libraryDependencies ++= dependencies.libs
testOptions += Tests.Argument("-l", "org.scalatest.tags.Network")

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Ywarn-unused-import",
  "-Ywarn-nullary-unit",
  "-Xfatal-warnings",
  "-Xlint",
  "-Ywarn-dead-code",
  "-Xfuture")

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

packAutoSettings
