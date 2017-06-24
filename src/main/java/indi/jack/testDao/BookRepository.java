package indi.jack.testDao;

import indi.jack.testEntity.Book;

public interface BookRepository extends GenericRepository<Long, Book>
{
    Book getByIsbn(String isbn);
}
