package com.example.springbootactivemq;

import com.example.springbootactivemq.services.bouncycastle.BouncyCastleService;
import com.example.springbootactivemq.services.bouncycastle.KeyPairService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;

@SpringBootTest
@Slf4j
class SpringbootActivemqApplicationTests {

	@Autowired
	KeyPairService keyPairService;

	@Autowired
	BouncyCastleService bouncyCastleService;

	@Test
	void contextLoads() {
	}

	@Test
	void encryptKey() throws Exception {
		PublicKey publicKey = keyPairService.getPublicKey();
		byte[] encryptedText = bouncyCastleService.encrypt("admin", publicKey);
		log.info("key after encrypted {}", new String(encryptedText));
	}


}
