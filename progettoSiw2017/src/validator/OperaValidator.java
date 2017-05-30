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
		String periodo = request.getParameter("anno");
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
				opera.setValore(Float.parseFloat(valore));
			} catch (NumberFormatException e) {
				request.setAttribute("errValore", "Deve essere un numero!");
				tuttoOk = false;
			}
		}
		
		if(periodo == null || periodo.equals("")) {
			request.setAttribute("errPeriodo", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				opera.setPeriodo(df.parse(periodo));
				if(df.parse(periodo).compareTo(new Date()) > 0) {
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