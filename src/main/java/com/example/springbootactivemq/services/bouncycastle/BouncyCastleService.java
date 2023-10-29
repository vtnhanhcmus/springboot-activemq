package com.example.springbootactivemq.services.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.Security;

@Service
public class BouncyCastleService {
    private static final String ALGORITHM = "RSA";

    public BouncyCastleService() {
        Security.addProvider(new BouncyCastleProvider());
    }

    public byte[] encrypt(String plainText, java.security.PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public String decrypt(byte[] encryptedText, java.security.PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedText);
        return new String(decryptedBytes);
    }
}
