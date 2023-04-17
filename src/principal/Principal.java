package principal;

import java.time.LocalDate;
import java.util.ArrayList;

import daos.CitaDao;
import model.CabecerasDiagnostico;
import model.Cliente;
import server.CitaServer;

public class Principal {

	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		CabecerasDiagnostico cabecerasDiagnostico = new CabecerasDiagnostico();
		
		//CitaServer.insertarCitaServer(cliente, cabecerasDiagnostico);
        LocalDate l = LocalDate.now();
        CitaServer.printCalendario(l.getMonthValue(), l.getYear());
		
		
		
	}
}
