package springtolife.com.springtolife_revuchack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringToLifeRevUcHackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringToLifeRevUcHackApplication.class, args);
    }

}
