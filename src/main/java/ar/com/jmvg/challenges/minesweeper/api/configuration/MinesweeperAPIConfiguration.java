package ar.com.jmvg.challenges.minesweeper.api.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MinesweeperAPIConfiguration extends WebMvcConfigurationSupport {
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("**/*.css", "**/*.js", "**/*.map", "*.html")
            			.addResourceLocations("classpath:META-INF/resources/")
            			.addResourceLocations("classpath:META-INF/resources/static")
            			.addResourceLocations("/*.html")
            			.setCachePeriod(0);
    }

}