package br.com.converter;

import br.com.service.AbstractService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author barizon
 */
public class GenericConverter implements Converter {

    private final AbstractService abstractService;

    public GenericConverter(AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("null")) {
            return null;
        }
        return abstractService.pesquisar(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
}
