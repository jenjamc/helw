package com.netc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HwController {
    DaoTable dao;
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String welcomePage(Model model) {
        HelTable hel = dao.getTable();
        model.addAttribute("hello", hel );
        return "index";
    }
}