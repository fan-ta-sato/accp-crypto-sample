package com.example.crypto

trait Method {
  val method: String
  val cipherMode: String
  val padding: String
  val keyLength: Int

  def show: String = s"${method}/${cipherMode}/${padding}"
}

object Method {
  final case object AesCbc256 extends Method {
    val method = "AES"
    val cipherMode = "CBC"
    val padding = "PKCS5Padding"
    val keyLength = 256
  }
}
