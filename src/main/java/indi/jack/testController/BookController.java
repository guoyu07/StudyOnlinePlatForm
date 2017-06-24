package indi.jack.testController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import indi.jack.testEntity.Author;
import indi.jack.testEntity.Book;
import indi.jack.testEntity.Gender;
import indi.jack.testEntity.Publisher;
import indi.jack.testservice.BookManager;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController
{
    private final Random random;

    @Inject BookManager bookManager;

    public BookController()
    {
        try
        {
            this.random = SecureRandom.getInstanceStrong();
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @RequestMapping(value = "/testEntityMapping", method = RequestMethod.GET)
    public String list(Map<String, Object> model)
    {
        model.put("publishers", this.bookManager.getPublishers());
        model.put("authors", this.bookManager.getAuthors());
        model.put("books", this.bookManager.getBooks());

        return "entities";
    }

    @RequestMapping(value = "/testEntityMapping", method = RequestMethod.POST)
    public View add()
    {
        Publisher publisher = new Publisher();
        publisher.setName("John Wiley & Sons");
        publisher.setAddress("1234 Baker Street");
        publisher.setDateFounded(Calendar.getInstance());
        this.bookManager.savePublisher(publisher);

        Author author = new Author();
        author.setName("Nicholas S. Williams");
        author.setEmailAddress("nick@example.com");
        author.setGender(Gender.MALE);
        this.bookManager.saveAuthor(author);

        Book book = new Book();
        book.setIsbn("" + this.random.nextInt(Integer.MAX_VALUE));
        book.setTitle("javaWEB高级编程");
        book.setAuthor("威廉姆斯");
        book.setPublisher("清华大学出版社");
        book.setPrice(99D);
        this.bookManager.saveBook(book);

        return new RedirectView("/testEntityMapping", true, false);
    }
}
