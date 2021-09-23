package fi.hh.Bookstore2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.Bookstore2.domain.Book;
import fi.hh.Bookstore2.domain.BookRepository;

@SpringBootApplication
public class Bookstore2Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (BookRepository repository) {
		return (args) -> {
			Book s1 = new Book ("Boomilaakson seikkailut", "Pohina", "ISBN2012457", 2021, 14);
			Book s2 = new Book ("Boomilaakson seikkailut 2", "Pena", "ISBN2012458", 2021, 18);
			Book s3 = new Book ("Boomilaakson seikkailut 3", "Pohisijac", "ISBN2012459", 2021, 11);
		
		repository.save(s1);
		repository.save(s2);
		repository.save(s3);
		};
	};

}
