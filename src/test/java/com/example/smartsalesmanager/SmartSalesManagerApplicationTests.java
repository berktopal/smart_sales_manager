package com.example.smartsalesmanager;

import com.example.smartsalesmanager.factory.ProductFactory;
import com.example.smartsalesmanager.model.Product;
import com.example.smartsalesmanager.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmartSalesManagerApplicationTests {

    @Value("${local.server.port}")
    int port;

    @Autowired
    ProductRepository productRepository;

    @Test
    void helloEndpointIsReachable() throws Exception {
        // Eski yapıda controller taranmadığı için bu uç nokta 404 dönüyordu
        HttpResponse<String> res = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder(URI.create("http://localhost:" + port + "/hello")).build(),
                HttpResponse.BodyHandlers.ofString());
        assertEquals(200, res.statusCode());
    }

    @Test
    void productCanBePersisted() {
        Product saved = productRepository.save(ProductFactory.createProduct("Laptop", "Electronics", 25000.0, 3));
        assertNotNull(saved.getId());
        assertEquals("Laptop", productRepository.findById(saved.getId()).orElseThrow().getName());
    }
}
