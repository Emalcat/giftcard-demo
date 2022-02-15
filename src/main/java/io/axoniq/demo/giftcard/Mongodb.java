package io.axoniq.demo.giftcard;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.Arrays;

public class Mongodb {
    @Value(  "${mongodb.start_db}" )
    private String start_db;

    @Value( "${mongodb.main_db}" )
    private String main_db;

    @Value("${mongodb.username}")
    private String username;

    @Value( "${mongodb.password}" )
    private String password;

    @Value( "${mongodb.port}" )
    private int port;

    @Value( "${mongodb.host}" )
    private String host;

    @Value( "${mongodb.authentication-database}" )
    private String authenticationDatabase;


    @Bean
    public MongoClient mongo(){

        MongoCredential credential= MongoCredential.createCredential(username,authenticationDatabase,password.toCharArray());

        MongoClientSettings mongoClientSettings= MongoClientSettings.builder()
                .credential(credential)
                .applyToClusterSettings(builder->
                        builder.hosts(Arrays.asList(new ServerAddress(host,port))))
                .build();

        return MongoClients.create(mongoClientSettings);

    }

    @Primary
    @Bean
    public MongoTemplate mongoTemplateMain() throws Exception{
        return new MongoTemplate(mongo(), main_db);
    }
}
