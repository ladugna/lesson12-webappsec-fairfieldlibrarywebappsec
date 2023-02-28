package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"", "/fairfieldlibrary"})
public class PublicPagesController {

//    @RequestMapping(value = "/", method = RequestMethod.GET) // version 3.X
    @GetMapping(value = {"/", "/home"}) // version 4.x+
    public String displayHomePage() {
        return "public/index";
    }

    @GetMapping(value = "/about")
    public String displayAboutPage() {
        return "public/about";
    }

}
