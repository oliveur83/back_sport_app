import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
                registry.addMapping("/api/**") // Permet les requêtes à tous les endpoints sous /api
                        .allowedOrigins("http://localhost:4200") // Autoriser le frontend Angular (localhost:4200)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
                        .allowedHeaders("*") // Tous les headers sont autorisés
                        .allowCredentials(true); // Si tu utilises des cookies ou des sessions
            }
        };
    }
}
