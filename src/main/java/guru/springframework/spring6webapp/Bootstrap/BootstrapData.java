package guru.springframework.spring6webapp.Bootstrap;

import guru.springframework.spring6webapp.domain.Address;
import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repository.AddressRepository;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.BookRepository;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, AddressRepository addressRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressRepository = addressRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Address addressPruszynski = new Address();
        addressPruszynski.setCity("Warszawa");
        addressPruszynski.setState("Mazowieckie");
        Publisher pruszynski = new Publisher();
        pruszynski.setPublisherName("Pruszynski");
        pruszynski.getAddress().add(addressPruszynski);
        addressPruszynski.setPublisher(pruszynski);
        Publisher savedPruszynski = publisherRepository.save(pruszynski);
        Address savedAddressPruszynski = addressRepository.save(addressPruszynski);

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");
        ddd.setPublisher(savedPruszynski);

        Author ericSaved = authorRepository.save(eric);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");
        noEJB.setPublisher(savedPruszynski);

        Book dddSaved = bookRepository.save(ddd);
        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());





        ddd.setPublisher(savedPruszynski);

        System.out.println("--------------------------");
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("Ddd book: " + ddd);
        System.out.println("Publisher: " + savedPruszynski);
    }
}
