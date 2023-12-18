package ec.edu.utpl.complexivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ec.edu.utpl.complexivo"})
public class PoliciaNacionalGestionVehicularApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliciaNacionalGestionVehicularApplication.class, args);
	}

}
