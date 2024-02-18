package web.taller.wiki.interfaceService;

import java.util.List;

import web.taller.wiki.entities.Form;

public interface InterfaceForm {
    public List<Form> getAllForms();
    public int saveForm(Form form);
    public void deleteForm(long id);
    public Form getFormById(long id);
}
