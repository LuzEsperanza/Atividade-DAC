package br.edu.ifpb.infra.jsf.validator;

import br.edu.ifpb.domain.Dependente;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validator.Dependente")
public class ValidatorDependente implements Validator {

    @Override
    public void validate(
        FacesContext context,
        UIComponent component,
        Object value) throws ValidatorException {
        Dependente dep = (Dependente) value;
        System.err.println("valid "+dep);

        if (dep.naoValido()) {
            FacesMessage facesMessage = new FacesMessage("valor inválido para o dependente");
            throw new ValidatorException(facesMessage);
        }
    }

}
