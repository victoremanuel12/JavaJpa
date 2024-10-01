package com.boostore.jpa.repository;

import com.boostore.jpa.models.AuthorModel;
import com.boostore.jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewModel, Integer > {
}
