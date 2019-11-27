package com.example.crypto

trait Algorithm {
  def show: String
}
object Algorithm {
  final case object PBKDF2WithHmacSHA256 extends Algorithm {
    val pkcs = "PBKDF2"
    val hmac = "SHA256"

    def show = s"${pkcs}WithHmac${hmac}"
  }
}
