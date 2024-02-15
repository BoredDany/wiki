package web.taller.wiki.controllers;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.taller.wiki.entities.Form;
import web.taller.wiki.repositories.FormRepository;

@Controller
@RequestMapping("/controllers")
public class formSender {
    @Autowired
    private FormRepository formRepository;

    @PostMapping("/save-form")
    public String imprimirDatos(Model model, @RequestParam String name, @RequestParam String lastName,
            @RequestParam String email, @RequestParam int semester, @RequestParam String description) {
        Form form = new Form();
        form.setName(name);
        form.setLastName(lastName);
        form.setEmail(email);
        form.setSemester(semester);
        form.setDescription(description);
        formRepository.save(form);

        return "redirect:/";
    }
}
