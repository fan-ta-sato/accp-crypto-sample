import sbt._

object Versions {
  val Scala = "2.13.0"
}

object Dependencies {
  val common = Seq(
    Libraries.accp,
  )
}

object Libraries {
     lazy val accp = "software.amazon.cryptools" % "AmazonCorrettoCryptoProvider" % "1.2.0" classifier "linux-x86_64"
}
