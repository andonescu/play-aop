name := "playaop"

version := "1.0"

lazy val `playaop` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  jdbc,
  ehcache,
  ws,
  specs2 % Test,
  guice)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

enablePlugins(SbtAspectj)

// add compiled classes as an input to aspectj
aspectjInputs in Aspectj += (aspectjCompiledClasses in Aspectj).value

// use the results of aspectj weaving
products in Compile := (products in Aspectj).value
products in Runtime := (products in Compile).value