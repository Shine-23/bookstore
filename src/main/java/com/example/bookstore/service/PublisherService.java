package com.example.bookstore.service;

import com.example.bookstore.entity.Publisher;
import com.example.bookstore.exception.PublisherNotFoundException;
import com.example.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

//    public Optional<Publisher> getPublisherById(Long id) {
//        return publisherRepository.findById(id);
//    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException("Publisher not found with id: " + id));
    }


    public Publisher updatePublisher(Long id, Publisher updatedPublisher) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        publisher.setId(updatedPublisher.getId());
        publisher.setName(updatedPublisher.getName());
        publisher.setLocation(updatedPublisher.getLocation());
        return publisherRepository.save(publisher);
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    public List<Publisher> findPublishersByLocation(String location) {
        return publisherRepository.findByLocation(location);
    }
}
