package org.lib.repository;

import org.lib.Entity.BookEntity;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<BookEntity,Long> {
}
