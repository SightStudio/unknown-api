package com.sight.boardapi.application;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

  @Value("${jasypt.encryptor.password}")
  private String encryptKey;

  @Test
  @Disabled
  @DisplayName("프로퍼티에 사용되는 필드들을 암호화한다.")
  public void encryptDecryptTest() {
    String originText = "this is encrypted field";

    StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
    jasypt.setPassword(encryptKey);
    jasypt.setAlgorithm("PBEWithMD5AndDES");

    String encryptedText = jasypt.encrypt(originText);
    String decryptedText = jasypt.decrypt(encryptedText);

    System.out.println("enc : " + encryptedText);
    System.out.println("dec : " + decryptedText);

    Assertions.assertEquals(originText, decryptedText);
  }
}
