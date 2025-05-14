package com.example.bookstore.repository;

import com.example.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByName(String name);

    List<Publisher> findByLocation(String location);
}
