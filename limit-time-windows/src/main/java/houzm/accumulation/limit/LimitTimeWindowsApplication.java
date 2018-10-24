package houzm.accumulation.limit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class LimitTimeWindowsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitTimeWindowsApplication.class, args);
	}
}
