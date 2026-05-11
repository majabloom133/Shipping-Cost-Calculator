package se.lexicon;

// Import what I need from Spring
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Tell Spring that the class contains settings for the project
@Configuration
// Tells Spring to look through all my golders for @Component and @Service
@ComponentScan("se.lexicon")
public class AppConfig {

}
