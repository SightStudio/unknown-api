package com.sight.boardapi.application;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

  @Value("${jasypt.encryptor.password}")
  private String encryptKey;

  @Test
  @Disabled
  public void encryptDecryptTest() {
    String text = "this is encrypted field";

    StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
    jasypt.setPassword(encryptKey);
    jasypt.setAlgorithm("PBEWithMD5AndDES");

    String encryptedText = jasypt.encrypt(text);
    System.out.println("enc : " + encryptedText);
    String decryptedText = jasypt.decrypt(encryptedText);
    System.out.println("dec : " + decryptedText);
  }
}
