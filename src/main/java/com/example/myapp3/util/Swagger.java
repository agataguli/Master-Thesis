package com.example.myapp3.util;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import com.example.myapp3.MyApi;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ApplicationPath("/myapp")
@EnableSwagger2
public class Swagger extends ResourceConfig {

    @Value("${webapp.context:/}")
    private String path;

    public Swagger(MyApi myApi) {
        register(myApi);
    }

    @PostConstruct
    public void init() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setConfigId("myapp");
        beanConfig.setTitle("myapp");
        beanConfig.setBasePath(path);
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);

        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, beanConfig);
    }
}