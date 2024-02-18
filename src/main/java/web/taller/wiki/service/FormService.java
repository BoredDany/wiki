package web.taller.wiki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.taller.wiki.entities.Form;
import web.taller.wiki.interfaceService.InterfaceForm;
import web.taller.wiki.repositories.FormRepository;

@Service
public class FormService implements InterfaceForm {

    @Autowired
    private FormRepository formRepository;

    @Override
    public List<Form> getAllForms() {
        return (List<Form>) formRepository.findAll();
    }

    @Override
    public int saveForm(Form form) {
        int res = 0;
        Form f = formRepository.save(form);
        if (!f.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void deleteForm(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteForm'");
    }

    @Override
    public Form getFormById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFormById'");
    }

}
