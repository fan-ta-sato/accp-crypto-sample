import sbt._

object Versions {
  val Scala = "2.13.0"
}

object Dependencies {
  val coreDependencies = Seq(
     "software.amazon.cryptools" % "AmazonCorrettoCryptoProvider" % "1.2.0"
    )
}

object Libraries {
}
