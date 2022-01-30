package online.contact.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment mEnvironment;

    @Override
    protected String getDatabaseName() {
        return mEnvironment.getProperty("MONGO_DATABASE");
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        final String databaseHost = mEnvironment.getProperty("MONGO_HOST");
        final String databasePort = mEnvironment.getProperty("MONGO_PORT");
        final String databaseName = mEnvironment.getProperty("MONGO_DATABASE");

        final ConnectionString connection = new ConnectionString("mongodb://" + databaseHost + ":" + databasePort + "/" + databaseName);
        final MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connection)
                .build();

        return MongoClients.create(settings);
    }
}
