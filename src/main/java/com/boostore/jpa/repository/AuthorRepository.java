package com.boostore.jpa.repository;

import com.boostore.jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long > {
}
