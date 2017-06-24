package indi.jack.testDaoImpl;


import org.springframework.stereotype.Repository;

import indi.jack.testDao.PublisherRepository;
import indi.jack.testEntity.Publisher;

@Repository
public class DefaultPublisherRepository
        extends GenericJpaRepository<Long, Publisher>
        implements PublisherRepository
{

}
