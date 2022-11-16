package com.example.aproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MovieController1 {

    @RequestMapping(value = "/quanpin")
    public String quanpin() {
        return "pingfen/welcome1";
    }

    @RequestMapping(value = "/zhongpin")
    public String zhongpin() {
        return "pingfen/welcome2";
    }

    @RequestMapping(value = "/meipin")
    public String meipin() {
        return "pingfen/welcome3";
    }

    @RequestMapping(value = "/fapin")
    public String fapin() {
        return "pingfen/welcome6";
    }


    @RequestMapping(value = "/quanlei")
    public String quanlei() {
        return "leixin/welcome1";
    }

    @RequestMapping(value = "/quannian")
    public String quannian() {
        return "niandai/welcome1";
    }

    @RequestMapping(value = "/zhongnian")
    public String zhongnian() {
        return "niandai/welcome2";
    }

    @RequestMapping(value = "/zhongxiang")
    public String zhongxiang() {
        return "moviexiang";
    }

    @RequestMapping(value = "/meinian")
    public String meinian() {
        return "niandai/welcome3";
    }

    @RequestMapping(value = "/fanian")
    public String fanian() {
        return "niandai/welcome6";
    }

    @RequestMapping(value = "/quanshi")
    public String quanshi() {
        return "shichang/welcome1";
    }

    @RequestMapping(value = "/zhongshi")
    public String zhongshi() {
        return "shichang/welcome2";
    }

    @RequestMapping(value = "/meishi")
    public String meishi() {
        return "shichang/welcome3";
    }

    @RequestMapping(value = "/fashi")
    public String fashi() {
        return "shichang/welcome6";
    }


    @RequestMapping(value = "/ccc")
    public String ccc() {
        return "niandai/test";
    }
}
