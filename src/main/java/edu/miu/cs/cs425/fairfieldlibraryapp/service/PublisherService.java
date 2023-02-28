package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PublisherService {

    Publisher addNewPublisher(Publisher newPublisher);
    Iterable<Publisher> getAllPublishers();
    Optional<Publisher> getPublisherById(Integer publisherId);

    Publisher updatePublisherById(Integer publisherId, Publisher editedPublisher);

//    String deletePublisherById(Integer publisherId) ;
    void deletePublisherById(Integer publisherId) throws Exception;

}
