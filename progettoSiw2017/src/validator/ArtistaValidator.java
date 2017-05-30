package validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Artista;

public class ArtistaValidator {

	public boolean validate(HttpServletRequest request) {
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nazionalita = request.getParameter("nazionalita");
		String dataNascita = request.getParameter("dataNascita");
		String dataMorte = request.getParameter("dataMorte");
		Artista artista = (Artista)request.getAttribute("artista");

		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		} else
			artista.setNome(nome);

		if(cognome == null || cognome.equals("")) {
			request.setAttribute("errCognome", "Campo obbligatorio");
			tuttoOk = false;
		} else
			artista.setCognome(cognome);

		if(nazionalita == null || nazionalita.equals("")) {
			request.setAttribute("errNazionalita", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			artista.setNazionalità(nazionalita);
		}
		if(dataNascita == null || dataNascita.equals("")) {
			request.setAttribute("errPeriodo", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				artista.setDataNascita(df.parse(dataNascita));
				if(df.parse(dataNascita).compareTo(new Date()) > 0) {
					request.setAttribute("errDataNascita", "Deve essere una data passata!");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errDataNascita", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}
		if(dataMorte == null || dataMorte.equals("")) {
			request.setAttribute("errDataMorte", "Campo obbligatorio");
			tuttoOk = false;
		} else {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				artista.setDataMorte(df.parse(dataMorte));
				if(df.parse(dataMorte).compareTo(new Date()) > 0) {
					request.setAttribute("errDataMorte", "Deve essere una data prima di oggi");
					tuttoOk = false;
				}
			} catch (ParseException e) {
				request.setAttribute("errDataMorte", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}
		return tuttoOk;
	}
}