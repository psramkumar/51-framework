lazy val commonSettings = Seq(
  organization := "com.triadic",
  version := "1.0",
  scalaVersion := "2.11.7"
)


lazy val play24Guice = (project in file(".")).enablePlugins(PlayJava, PlayEnhancer)
  .settings(commonSettings: _*).settings(name := """play24-guice-spring""")

val spring_version = "4.3.3.RELEASE"

libraryDependencies ++= Seq(
  cache,
  javaWs,
  "org.springframework.data" % "spring-data-mongodb" % "1.9.1.RELEASE",
  "org.projectlombok" % "lombok" % "1.16.8" % "provided",
  "org.springframework.guice" % "spring-guice" % "1.0.0-SNAPSHOT",
  "org.springframework" % "spring-test" % spring_version % "test",
  "org.mockito" % "mockito-core" % "1.10.19" % "test"
)

dependencyOverrides += "org.mongodb" % "mongo-java-driver" % "3.2.2"

dependencyOverrides += "junit" % "junit" % "4.12" % "test"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


resolvers ++= Seq(
  "Ram Github Repository" at "https://raw.github.com/psramkumar/maven/master/"
)