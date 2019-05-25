package com.dkaedv.glghproxy;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.deploy.SecurityCollection;
import org.apache.catalina.deploy.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	/**
	 * The date format used by GitHub. No millis! JIRA DVCS Connector fails parsing
	 * dates when we have millis, which results in the timezone not being applied.
	 */
	public static final String GITHUB_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

	public static void main(String[] args) {
		System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder
			.indentOutput(true)
			.simpleDateFormat(GITHUB_DATE_FORMAT)
			.propertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
		
		return builder;
	}

    @Bean
    public Connector connector(){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(1880);
        connector.setSecure(false);
        connector.setRedirectPort(1443);
        return connector;
    }

    @Bean
    public EmbeddedServletContainerFactory  tomcatServletWebServerFactory(Connector connector){
        TomcatEmbeddedServletContainerFactory tomcat=new TomcatEmbeddedServletContainerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint=new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection=new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }
}
