name := "message_akka"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.16"

mainClass in (Compile, run) := Some("Main")