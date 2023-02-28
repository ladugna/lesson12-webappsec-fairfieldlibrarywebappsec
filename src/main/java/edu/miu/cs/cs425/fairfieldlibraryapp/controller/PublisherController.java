package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/fairfieldlibary/secured/publisher"})
public class PublisherController {

    private PublisherService publisherService; // P2I

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/list")
    public ModelAndView displayPublishers() {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getAllPublishers();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/publisher/list");
        return modelAndView;
    }

    // TODO Add new publisher - POST Mapping
}
