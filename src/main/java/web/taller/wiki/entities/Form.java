package web.taller.wiki.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Form {
    //soft delete
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    private String name;

    @Length(min = 1, max = 100, message = "El apellido debe tener entre 1 y 100 caracteres")
    private String lastName;

    @Email(message = "El email no es válido")
    @Length(min = 1, max = 100, message = "El email debe tener entre 1 y 100 caracteres")
    private String email;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @Min(value = 1, message = "El semestre debe ser mayor a 0")
    @Max(value = 16, message = "El semestre debe ser menor a 17")
    private int semester;

}
