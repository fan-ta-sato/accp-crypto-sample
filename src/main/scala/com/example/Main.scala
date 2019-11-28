package com.example

import javax.crypto.Cipher
import com.example.crypto.Crypto

object Main extends App {
  println(
    com.amazon.corretto.crypto.provider.AmazonCorrettoCryptoProvider.PROVIDER_NAME)
  println(
    Cipher.getInstance("AES/GCM/NoPadding").getProvider().getName()
  )

  val data = "Ango ka suru yo!"
  val key = "1234567890123456"
  val salt = "saltsaltsalt"
  val iv = "abcdefghijklmnop"

  println(Crypto.aesCbc256(data, key, salt, iv))
}
