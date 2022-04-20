package kz.stolik.servicebackendstolik;

import kz.stolik.servicebackendstolik.model.entity.Ingredient;
import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceBackendStolikApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServiceBackendStolikApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceBackendStolikApplication.class, args);
	}

	@Bean
	public TomcatServletWebServerFactory tomcatServletFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(final Context context) {
				((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
			}
		};
	}
}
