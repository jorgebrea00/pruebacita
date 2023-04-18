package principal;


import model.CabecerasDiagnostico;
import model.Cliente;
import server.CitaServer;

public class Principal {

	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		CabecerasDiagnostico cabecerasDiagnostico = new CabecerasDiagnostico();
		
		CitaServer.insertarCitaServer(cliente, cabecerasDiagnostico);
	
		
	}
}
