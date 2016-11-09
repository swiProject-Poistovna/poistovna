package haha.meme.haha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = PoistovnaResourceController.class)
public class ExampleRestApi {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExampleRestApi.class, args);
	}

}