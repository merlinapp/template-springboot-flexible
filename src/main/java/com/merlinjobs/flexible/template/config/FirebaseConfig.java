package com.merlinjobs.flexible.template.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public DatabaseReference firebaseDatabse() {
        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
        return firebase;
    }

    @Value("${rs.pscode.firebase.database.url}")
    private String databaseUrl;

    @Value("${rs.pscode.firebase.config.path}")
    private String configPath;


    @PostConstruct
    public void init() {

        /**
         * https://firebase.google.com/docs/server/setup
         *
         * Create service account , download json
         */

        try {
            FileInputStream serviceAccount = new FileInputStream(configPath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            //GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl(databaseUrl)
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
