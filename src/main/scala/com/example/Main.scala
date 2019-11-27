package com.example

import com.example.crypto.Crypto

object Main extends App {
  println(
    com.amazon.corretto.crypto.provider.AmazonCorrettoCryptoProvider.PROVIDER_NAME)

  val data = "Ango ka suru yo!"
  val key = "1234567890123456"
  val salt = "saltsaltsalt"
  val iv = "abcdefghijklmnop"

  println(Crypto.aesCbc256(data, key, salt, iv))
}
