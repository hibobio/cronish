name := "cronish"

organization := "com.hibob"
version := "0.1.4"
parallelExecution in Test := false

scalaVersion := "2.11.0"

crossScalaVersions := Seq(
  "2.11.0",
  "2.10.3",
  "2.9.2", "2.9.1", "2.9.0-1", "2.9.0"
)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

scalacOptions <++= scalaVersion map {
  case sv if sv startsWith "2.1" =>
    Seq("-feature", "-language:implicitConversions", "-language:postfixOps")
  case _ => Nil
}


libraryDependencies <++= scalaVersion {
  case sv if sv startsWith "2.11" => Seq(
    "com.github.philcali" %% "scalendar" % "0.1.4",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1",
    "com.typesafe.akka" %% "akka-actor" % "2.3.2",
    "org.scalatest" %% "scalatest" % "2.1.3" % "test"
  )
  case sv if sv startsWith "2.10" => Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.1.0",
    "org.scalatest" %% "scalatest" % "1.9" % "test"
  )
  case _ => Seq(
    "com.typesafe.akka" % "akka-actor" % "2.0.5",
    "org.scalatest" %% "scalatest" % "1.8" % "test"
  )
}


publishMavenStyle := true
publishArtifact in Test := false
licenses := Seq(("MIT", url("http://opensource.org/licenses/MIT")))
