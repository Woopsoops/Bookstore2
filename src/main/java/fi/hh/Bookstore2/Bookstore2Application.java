package fi.hh.Bookstore2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.Bookstore2.domain.Book;
import fi.hh.Bookstore2.domain.BookRepository;
import fi.hh.Bookstore2.domain.Category;
import fi.hh.Bookstore2.domain.CategoryRepository;

@SpringBootApplication
public class Bookstore2Application {
	
	private static final Logger log = LoggerFactory.getLogger(Bookstore2Application.class);  //loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(Bookstore2Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo (BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of books and categories");
			
			Category category1 = new Category ("jannitys");
			Category category2 = new Category ("kauhu");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			
			Book book1 = new Book ("Boomilaakson seikkailut", "Pohina", "ISBN2012457", 2021, 0, category1);
			Book book2 = new Book ("Boomilaakson seikkailut 2", "Pena", "ISBN2012458", 2021, 18, category2);
			Book book3 = new Book ("Boomilaakson seikkailut 3", "Pohisijac", "ISBN2012459", 2021, 11, category2);
		
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
		
		log.info("fetch all books");
		for (Book book : bookRepository.findAll()) {
			log.info(book.toString());
		}
		
		log.info("fetch all categories");
		for (Category category: categoryRepository.findAll()) {
			log.info(category.toString());
		}
		};
	}
	
	}
