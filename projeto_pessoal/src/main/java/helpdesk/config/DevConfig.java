package helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public CommandLineRunner instanciaDB() {
        return args -> {
            if ("create".equals(value)) {
                dbService.instanciaDB();
            }
        };
    }
    // public CommandLineRunner instanciaDB() {

    //     if(value.equals("create")){
    //         this.dbService.instanciaDB();
    //     }

    //     return args -> {
    //         dbService.instanciaDB();
    //     };
    // }
}
