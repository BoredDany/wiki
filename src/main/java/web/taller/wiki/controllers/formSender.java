package web.taller.wiki.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.Collection;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import web.taller.wiki.entities.Form;
import web.taller.wiki.interfaceService.InterfaceForm;
import web.taller.wiki.repositories.FormRepository;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping
public class formSender {
    @Autowired
    private InterfaceForm formService;

    @GetMapping("/forms-saved")
    public String getAllForms(Model model) {
        
        model.addAttribute("forms", formService.getAllForms());
        return "formsSaved";
    } 

    @GetMapping("/save-form")
    public String getMethodName(Model model) {
        model.addAttribute("form", new Form());
        return "contactUs";
    }
    
    @PostMapping("/save-form")    
    public String saveForm(Model model, @Valid Form form) {
        formService.saveForm(form);
        return "redirect:/forms-saved";
    }
}
