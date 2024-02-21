package web.taller.wiki.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.Collection;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.Valid;
import web.taller.wiki.entities.Form;
import web.taller.wiki.interfaceService.InterfaceForm;
import web.taller.wiki.repositories.FormRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping
public class formSender {
    @Autowired
    private InterfaceForm formService;

    @GetMapping("/grupo-2-3/forms-saved")
    public String getAllForms(Model model) {

        model.addAttribute("forms", formService.getAllForms());
        return "formsSaved";
    }

    @GetMapping("/grupo-2-3/save-form")
    public String getMethodName(Model model) {
        model.addAttribute("form", new Form());
        return "contactUs";
    }

    @PostMapping("/grupo-2-3/save-form")
    public String saveForm(Model model, @Valid @ModelAttribute("form") Form form, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("form", form);
            return "contactUs";
        }
        formService.saveForm(form);
        return "redirect:/grupo-2-3/forms-saved";
    }
}
