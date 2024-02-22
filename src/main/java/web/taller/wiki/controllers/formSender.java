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
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import web.taller.wiki.entities.Form;
import web.taller.wiki.interfaceService.InterfaceForm;
import web.taller.wiki.repositories.FormRepository;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/controllers")
public class formSender {
    @Autowired
    private InterfaceForm formService;

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/project")
    public String showProject() {
        return "project";
    }

    @GetMapping("/contactUs")
    public String showContactUs(Model model) {
        model.addAttribute("form", new Form());
        return "contactUs";
    }

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
    public String saveForm(Model model, @Valid @ModelAttribute("form") Form form, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("form", form);
            model.addAttribute("error", "Error al enviar el formulario");
            return "contactUs";
        }
        formService.saveForm(form);
        return "redirect:/controllers/forms-saved";
    }
}
