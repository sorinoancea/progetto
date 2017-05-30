package validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Opera;

public class OperaValidator {
	
	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String titolo = request.getParameter("titolo");
		String tecnica = request.getParameter("tecnica");
		String valore = request.getParameter("valore");
		String descrizione = request.getParameter("descrizione");
		Opera opera = (Opera)request.getAttribute("opera");
		
		if(titolo == null || titolo.equals("")) {
			request.setAttribute("errTitolo", "Campo obbligatorio");
			tuttoOk = false;
		} else
			opera.setTitolo(titolo);
		
		if(tecnica == null || tecnica.equals("")) {
			request.setAttribute("errTecnica", "Campo obbligatorio");
			tuttoOk = false;
		} else
			opera.setTecnica(tecnica);
		
		if(valore == null || valore.equals("")) {
			request.setAttribute("errValore", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				opera.setDimensione(Float.parseFloat(valore));
			} catch (NumberFormatException e) {
				request.setAttribute("errDescrizioe", "Deve essere un format di dimensioni!");
				tuttoOk = false;
			}
		}
		
		if(descrizione == null || descrizione.equals("")) {
			request.setAttribute("errPeriodo", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				opera.setPeriodo(df.parse(descrizione));
				if(df.parse(descrizione).compareTo(new Date()) > 0) {
					request.setAttribute("errPeriodo", "Deve essere una data entro la data attuale!");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errPeriodo", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}
	
		return tuttoOk;
	}
}