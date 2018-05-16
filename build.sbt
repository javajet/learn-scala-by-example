name := "MakeCuppa"

version := "1.0"

scalaVersion := "2.12.5"

seq(clojure.settings :_*)

libraryDependencies += "org.typelevel" %% "cats-core" % "1.1.0"
libraryDependencies += "org.clojure" % "clojure" % "1.5.1"
libraryDependencies += "org.clojure" % "algo.monads" % "0.1.6"
