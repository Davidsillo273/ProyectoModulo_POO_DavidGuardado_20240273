package DavidGuardado_20240273.DavidGuardado_20240273;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoModuloDavidGuardado20240273Application {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(),entry.getValue()));
		SpringApplication.run(ProyectoModuloDavidGuardado20240273Application.class, args);
	}
}
