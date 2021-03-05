name := "authentikat-jwt"

organization := "com.jason-goodwin"

scalaVersion := "2.13.1"

crossScalaVersions := Seq("2.10.6", "2.11.11", "2.12.2", "2.13.1") //sbt '+ publish'

parallelExecution := false

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.13",
  "org.json4s" %% "json4s-native" % "3.6.7",
  "org.json4s" %% "json4s-jackson" % "3.6.7",
  "org.scalatest" %% "scalatest" % "3.1.1" % Test
)

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.5.1"

credentials += Credentials(Path.userHome / ".mdialog.credentials")

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }


bintrayOrganization := Some("signalpath")
bintrayRepository := "scala"

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

