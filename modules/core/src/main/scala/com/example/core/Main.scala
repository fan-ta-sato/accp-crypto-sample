package com.example.core

// import com.amazon.corretto.crypto.provider.AmazonCorrettoCryptoProvider

import javax.crypto._
import javax.crypto.spec._

// import java.util.Base64

object Main extends App {
  // com.amazon.corretto.crypto.provider.AmazonCorrettoCryptoProvider.install()
  println(Cipher.getInstance("AES/CBC/NoPadding").getProvider().getName())
  // println(AmazonCorrettoCryptoProvider.PROVIDER_NAME)

  val original: String = "test"
  val bytes: Array[Byte] = original.getBytes("UTF-8")

  val keyBytes: Array[Byte] = "1234567890123456".getBytes("UTF-8")
  val ivBytes: Array[Byte] = "abcdefghijklmnop".getBytes("UTF-8")

  // val key: SecretKeySpec = new SecretKeySpec(keyBytes, "AES");
  val key: SecretKey = {
    val factory: SecretKeyFactory =
      // SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
      SecretKeyFactory.getInstance("AES")
    val spec: PBEKeySpec =
      new PBEKeySpec("1234567890123456".toCharArray)
    val tmp: SecretKey = factory.generateSecret(spec)
    new SecretKeySpec(tmp.getEncoded(), "AES")
  }
  val iv: IvParameterSpec = new IvParameterSpec(ivBytes);

  val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
  cipher.init(Cipher.ENCRYPT_MODE, key, iv)

  println(cipher.doFinal(bytes))
}
//   def encodeBase64(bytes: Array[Byte]): Array[Byte] = bytes
//
//   def generateKey(algorithm: String, size: Int): Array[Byte] = {
//     val generator = KeyGenerator.getInstance(algorithm)
//     generator.init(size)
//     generator.generateKey().getEncoded
//   }
//
//   val string = "test"
//
//   // For 256 to work, see http://stackoverflow.com/questions/6481627/java-security-illegal-key-size-or-default-parameters
//   val genKey = encodeBase64(generateKey("AES", 256)).mkString
//   println(s"genKey: $genKey")
//   println(s"string: `$string`")
//
//   val encrypted = AES.encrypt(string.getBytes("UTF-8"), genKey)
//   println(s"encrypted: ${encodeBase64(encrypted).mkString}")
//
//   val decrypted = AES.decrypt(encrypted, genKey)
//   println(s"decrypted: ${new String(decrypted, "UTF-8")}")
//
//   println("OK");
// }
//
// trait Encryption {
//   def encrypt(dataBytes: Array[Byte], secret: String): Array[Byte]
//   def decrypt(codeBytes: Array[Byte], secret: String): Array[Byte]
// }
//
// class JavaCryptoEncryption(algorithm: String) extends Encryption {
//   private def decodeBase64(string: String): Array[Byte] =string.getBytes("UTF-8")
//
//   private def cipher(mode: Int, b64secret: String): Cipher = {
//     val encipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding")
//     encipher.init(mode, new SecretKeySpec(decodeBase64(b64secret), algorithm))
//     encipher
//   }
//
//   def encrypt(bytes: Array[Byte], b64secret: String): Array[Byte] = {
//     val encoder = cipher(Cipher.ENCRYPT_MODE, b64secret)
//     encoder.doFinal(bytes)
//   }
//
//   def decrypt(bytes: Array[Byte], b64secret: String): Array[Byte] = {
//     val decoder = cipher(Cipher.DECRYPT_MODE, b64secret)
//     decoder.doFinal(bytes)
//   }
// }
//
// object DES extends JavaCryptoEncryption("DES")
// object AES extends JavaCryptoEncryption("AES")
