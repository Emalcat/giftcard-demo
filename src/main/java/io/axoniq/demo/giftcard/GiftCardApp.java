package io.axoniq.demo.giftcard;

import com.mongodb.MongoClient;
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
        try{
            MongoClient mongoClient= (MongoClient) MongoClients.create("mongodb://localhost:27017");
            MongoDatabase sampleTrainingDB=mongoClient.getDatabase("admin");
            MongoCollection<org.bson.Document> grandesCollection=sampleTrainingDB.getCollection("test");
            Document student1=grandesCollection.find(new Document("student_id",10000)).first();
            System.out.println(student1.toJson());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
