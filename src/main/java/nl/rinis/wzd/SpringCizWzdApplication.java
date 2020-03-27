package nl.rinis.wzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan 
public class SpringCizWzdApplication {

	public static void main(String[] args) {
		
		
		SpringApplication rechtspraakWS= new SpringApplication(SpringCizWzdApplication.class);

		/*
		 * schrijf pid in file 
		 */
        rechtspraakWS.addListeners(new ApplicationPidFileWriter());    
        rechtspraakWS.run(args);
	}

}
