package com.kamiljurczak.middle_ages_knights.controllers;

import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> knights = knightService.getAllKnights();
        model.addAttribute("knights", knights);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnightById(id);
        model.addAttribute("knight", knight);
        return "knight";
    }

    @RequestMapping("/newKnight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String createKnight(Knight knight) {
        knightService.createKnight(knight);
        return "redirect:/knights";
    }
}
