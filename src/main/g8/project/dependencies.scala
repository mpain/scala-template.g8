import sbt._
import sbt.Keys._
import versions.Version

object dependencies {

  trait DependencyGroup {
    def libs: Seq[ModuleID]
  }

  object cats extends DependencyGroup {
    override def libs = Seq(
      "org.typelevel" %% "cats-core" % Version.Cats,
      "org.typelevel" %% "cats-effect" % Version.CatsEffect
    )
  }

  object monix extends DependencyGroup {
    def module(name: String) = "io.monix" %% name % Version.Monix

    override def libs = Seq(
      module("monix")
    )
  }

  object logging extends DependencyGroup {
    override def libs = Seq(
      "ch.qos.logback" % "logback-classic" % Version.Logback,
      "org.slf4j" % "slf4j-api" % Version.Slf4j
    )
  }

  object common extends DependencyGroup {
    override def libs = Seq(
      "com.github.scopt" %% "scopt" % Version.Scopt
    )
  }

  object testing extends DependencyGroup {
    override def libs = Seq(
      "org.scalatest" %% "scalatest" % Version.Scalatest % Test
    )
  }

  lazy val libs = Seq(
    libraryDependencies ++= (
      logging.libs ++
      common.libs ++
      cats.libs ++
      monix.libs ++
      testing.libs
    )
  )
}
