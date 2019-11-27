package com.example.crypto

import javax.crypto.{SecretKey, Cipher, SecretKeyFactory}
import javax.crypto.spec.{PBEKeySpec, SecretKeySpec, IvParameterSpec}

object Crypto {
  val enc: String = "UTF-8"
  val iterationCount: Int = 65535

  def aesCbc256(data: String,
                key: String,
                salt: String,
                iv: String): Array[Byte] =
    encrypto(Method.AesCbc256,
             Algorithm.PBKDF2WithHmacSHA256,
             data,
             key,
             salt,
             iv)

  def encrypto(method: Method,
               algorithm: Algorithm,
               data: String,
               key: String,
               salt: String,
               iv: String): Array[Byte] = {

    val ivBytes: Array[Byte] = iv.getBytes(enc)

    val seacretKey: SecretKey = {
      val factory: SecretKeyFactory =
        SecretKeyFactory.getInstance(algorithm.show)
      val keySpec: PBEKeySpec =
        new PBEKeySpec(key.toCharArray,
                       salt.getBytes,
                       iterationCount,
                       method.keyLength)
      val secret: SecretKey = factory.generateSecret(keySpec)
      new SecretKeySpec(secret.getEncoded(), method.method)
    }
    val ivSpec: IvParameterSpec = new IvParameterSpec(ivBytes);

    val cipher: Cipher = Cipher.getInstance(method.show);
    cipher.init(Cipher.ENCRYPT_MODE, seacretKey, ivSpec)
    cipher.doFinal(data.getBytes(enc))
  }
}
