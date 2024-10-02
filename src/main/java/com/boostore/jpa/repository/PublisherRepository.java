package com.boostore.jpa.repository;

import com.boostore.jpa.models.AuthorModel;
import com.boostore.jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherModel, Long > {
}
