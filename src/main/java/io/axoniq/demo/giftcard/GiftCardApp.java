package io.axoniq.demo.giftcard;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.bson.Document;

@SpringBootApplication
public class GiftCardApp {

    public static void main(String[] args) {
        SpringApplication.run(GiftCardApp.class, args);
        System.out.println("test");
    }
}
