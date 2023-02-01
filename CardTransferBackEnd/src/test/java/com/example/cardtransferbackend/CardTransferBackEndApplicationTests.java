package com.example.cardtransferbackend;

import com.example.cardtransferbackend.exceptions.responseEntities.Respond200;
import com.example.cardtransferbackend.models.TransInfo;
import com.example.cardtransferbackend.models.TransferAmount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardTransferBackEndApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private final GenericContainer<?> testApp = new GenericContainer<>("jdk17b")
            .withExposedPorts(5500);

    @Test
    void contextLoads() {
        Respond200 respond200 = restTemplate.getForObject("http://localhost:" + testApp.getMappedPort(5500) + "/transfer", Respond200.class, new TransInfo("1", "1", "1", "1", new TransferAmount(1, "1")));
        System.out.println(respond200);

    }

}
