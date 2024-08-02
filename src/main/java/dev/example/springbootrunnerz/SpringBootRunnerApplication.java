package dev.example.springbootrunnerz;

import dev.example.springbootrunnerz.pojo.Location;
import dev.example.springbootrunnerz.pojo.Run;
import dev.example.springbootrunnerz.dao.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@SpringBootApplication
public class SpringBootRunnerApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootRunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunnerApplication.class, args);
    }

    //@Bean
    CommandLineRunner runner(RunRepository runRepository) {
        return args -> {
            log.info("Run:{}", "The project is started.");
            Run data1 = new Run(
                    "biusvcjhc",
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(30),
                    5,
                    Location.INDOOR
            );
            Run data2 = new Run(
                    "123",
                    LocalDateTime.of(2024, 7, 25, 19, 0),
                    LocalDateTime.of(2024, 7, 25, 20, 0),
                    10,
                    Location.OUTDOOR
                    );
            runRepository.save(data1);
            runRepository.save(data2);
        };
    }


}
