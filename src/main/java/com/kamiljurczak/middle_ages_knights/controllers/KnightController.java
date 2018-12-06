package com.kamiljurczak.middle_ages_knights.controllers;

import com.kamiljurczak.middle_ages_knights.components.TimeComponent;
import com.kamiljurczak.middle_ages_knights.domain.Knight;
import com.kamiljurczak.middle_ages_knights.domain.PlayerInformation;
import com.kamiljurczak.middle_ages_knights.domain.repository.PlayerInformationRepository;
import com.kamiljurczak.middle_ages_knights.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> knights = knightService.getAllKnights();
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        model.addAttribute("knights", knights);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnightById(id);
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newKnight")
    public String createKnight(Model model) {
        PlayerInformation playerInformation = playerInformationRepository.getFirst();
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String createKnight(@Valid Knight knight, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + " " + error.getDefaultMessage()));
            return "knightform";
        } else {
            knightService.createKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}
