package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

//    @Autowired
//    public PublisherServiceImpl(PublisherRepository publisherRepository) {
//        this.publisherRepository = publisherRepository;
//    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId);
    }

    @Override
    public Publisher updatePublisherById(Integer publisherId, Publisher editedPublisher) {
        var thePublisher = publisherRepository.findById(publisherId).orElse(null);
        Publisher updatedPublisher = null;
        if(thePublisher != null) {
            thePublisher.setName(editedPublisher.getName());
            thePublisher.setContactPhoneNo(editedPublisher.getContactPhoneNo());
            thePublisher.setEmailAddress(editedPublisher.getEmailAddress());
            thePublisher.setPrimaryAddress(editedPublisher.getPrimaryAddress());
            updatedPublisher = publisherRepository.save(thePublisher);
        }
        return updatedPublisher;
    }

    @Override
    public void deletePublisherById(Integer publisherId) throws Exception {
        publisherRepository.deleteById(publisherId);
    }

//    @Override
//    public String deletePublisherById(Integer publisherId) {
//        var thePublisher = publisherRepository.findById(publisherId).orElse(null);
//        if(thePublisher != null) {
//            publisherRepository.deleteById(publisherId);
//            return String.format("Publisher with id, %s is deleted.", publisherId);
//        }
//        return String.format("Publisher with id, %s is not found.", publisherId);
//    }

}
