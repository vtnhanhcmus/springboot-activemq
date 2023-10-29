package com.example.springbootactivemq.services.bouncycastle;

import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

@Service
public class KeyPairService {
    private KeyPair keyPair;

    public KeyPairService() {
        keyPair = generateKeyPair();
    }

    private KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
            keyPairGenerator.initialize(2048); // Key size
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException("Error generating key pair", e);
        }
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }
}
