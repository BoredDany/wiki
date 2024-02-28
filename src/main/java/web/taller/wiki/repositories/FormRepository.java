package web.taller.wiki.repositories;

import org.springframework.data.repository.CrudRepository;

import web.taller.wiki.entities.Form;

//form es la entidad y long es el tipo de identioficador
public interface FormRepository extends CrudRepository<Form, Long>{


}
