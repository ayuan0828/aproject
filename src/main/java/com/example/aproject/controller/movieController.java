package com.example.aproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class movieController {
    @RequestMapping(value = "/moviepeo")
    public String moviepeo() {
        return "moviepeo";
    }

    @RequestMapping(value = "/movieline")
    public String movieline() {
        return "movieline";
    }

    @RequestMapping(value = "/movieline2")
    public String movieline2() {
        return "movieline2";
    }

    @RequestMapping(value = "/movieline3")
    public String movieline3() {
        return "movieline3";

    }

    @RequestMapping(value = "/movielinea")
    public String movielinea() {
        return "movielinea";

    }

    @RequestMapping(value = "/movieci")
    public String movieci() {
        return "moviezong";

    }

    @RequestMapping(value = "/bbb")
    public String bbb() {
        return "test";
    }
}
