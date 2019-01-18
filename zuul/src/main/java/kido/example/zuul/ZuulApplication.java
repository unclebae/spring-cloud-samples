package kido.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.io.ClassPathResource;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {

	public static void main(String[] args) {

//		SpringApplication.run(ZuulApplication.class, args);
		Object[] sources = {ZuulApplication.class, new ClassPathResource("groovy/ExampleSurgicalDebugFilterBean.groovy")};
		SpringApplication.run(sources, args);
	}
}
