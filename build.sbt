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

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.3"

credentials += Credentials(Path.userHome / ".mdialog.credentials")

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>http://github.com/jason-goodwin.com/authentikat-jwt</url>
    <licenses>
      <license>
        <name>Apache2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jasongoodwin/authentikat-jwt.git</url>
      <connection>scm:git:git@github.com:jasongoodwin/authentikat-jwt.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jasongoodwin</id>
        <name>Jason Goodwin</name>
        <url>http://refactoringfactory.wordpress.com</url>
      </developer>
    </developers>)

credentials += Credentials("Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  "<your username>",
  "<your password>")


bintrayOrganization := Some("signalpath")
bintrayRepository := "scala"
