package com.boostore.jpa.repository;

import com.boostore.jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
    BookModel findBookModelByTitle(String title);
    @Query(value = "SELECT * FROM book WHERE publisher_id = :id", nativeQuery = true)
    List<BookModel> findBooksByPublisherId(@Param("id") Integer id);
}
