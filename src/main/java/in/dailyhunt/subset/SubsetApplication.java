package in.dailyhunt.subset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.dailyhunt")
public class SubsetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubsetApplication.class, args);
	}

}
