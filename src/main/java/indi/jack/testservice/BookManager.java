package indi.jack.testservice;



import java.util.List;

import indi.jack.testEntity.Author;
import indi.jack.testEntity.Book;
import indi.jack.testEntity.Publisher;

public interface BookManager
{
    List<Author> getAuthors();

    List<Book> getBooks();

    List<Publisher> getPublishers();

    void saveAuthor(Author author);

    void saveBook(Book book);

    void savePublisher(Publisher publisher);
}
