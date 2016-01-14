package org.fm.bookstore.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String WELCOME_PAGE = "/bookstore/swagger-ui.html";

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // set welcome page
        registry.addViewController("/").setViewName("forward:" + WELCOME_PAGE);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
