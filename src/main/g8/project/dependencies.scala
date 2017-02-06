import sbt._

object dependencies {
  object Versions {
  }

  private lazy val logging = Seq(
    "ch.qos.logback" % "logback-classic" % "1.1.9",
    "org.slf4j" % "slf4j-api" % "1.7.22"
  )

  private lazy val common = Seq(
    "com.github.scopt" %% "scopt" % "3.5.0",
    "com.iheart" %% "ficus" % "1.4.0"
  )

  private lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % "3.0.1" % Test
  )

  lazy val libs = common ++ logging ++ scalaTest
}