package indi.jack.testDaoImpl;


import indi.jack.testDao.AuthorRepository;
import indi.jack.testEntity.Author;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultAuthorRepository extends GenericJpaRepository<Long, Author>
    implements AuthorRepository
{

}
