package ch.gibm.converter;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import ch.gibm.entity.City;
import ch.gibm.facade.CityFacade;

@FacesConverter(forClass = ch.gibm.entity.City.class)
public class CityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CityFacade lngFacade = new CityFacade();
		int langId;

		try {
			langId = Integer.parseInt(arg2);
		} catch (NumberFormatException exception) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Type the name of a city and select it (or use the dropdown)", "Type the name of a city and select it (or use the dropdown)"));
		}

		return lngFacade.findCity(langId);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 == null) {
			return "";
		}
		City lang = (City) arg2;
		return String.valueOf(lang.getId());
	}
}