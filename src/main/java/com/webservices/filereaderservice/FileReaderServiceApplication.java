package com.webservices.filereaderservice;

import com.webservices.filereaderservice.model.Letter;
import com.webservices.filereaderservice.repository.FileReaderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FileReaderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileReaderServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(FileReaderRepository fileReaderRepository){
////		return  args -> {
////			Letter l1 = new Letter();
////			l1.setValue("A");
////			Letter l2 = new Letter();
////			l2.setValue("B");
////
////			fileReaderRepository.save(l1);
////			fileReaderRepository.save(l2);
////		};
//	}

}
