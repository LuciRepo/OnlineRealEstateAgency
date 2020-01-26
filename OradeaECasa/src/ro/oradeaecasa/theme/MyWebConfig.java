package ro.oradeaecasa.theme;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan
public abstract class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //mapping '/' to index view name without a controller
        ViewControllerRegistration r = registry.addViewController("/");
        r.setViewName("index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();//default prefix=/WEB-INF/", suffix=".jsp"
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //specifying static resource location for themes related files(css etc)
        registry.addResourceHandler("/themes/**")
                .addResourceLocations("/app-themes/");
    }
}
