package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysAdminController {

    @GetMapping(value = "/secured/sysadmin")
    public String displaySysAdminPage() {
        return "secured/sysadmin";
    }
}
