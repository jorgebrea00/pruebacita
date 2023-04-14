package server;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import daos.CitaDao;
import model.CabecerasDiagnostico;
import model.Cita;
import model.Cliente;
import model.Vehiculo;

public class CitaServer {

	static Scanner sc = new Scanner(System.in);
	
	public static void insertarCitaServer(Cliente cliente,CabecerasDiagnostico CabecerasDiagnostico){
		cliente.setId(1);
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(5);
		CabecerasDiagnostico.setId(1);
		Cita cita = new Cita();
		
		LocalDate ld = Pedirfecha();
		
		cita.setFechaHora(ld);
		cita.setCabecerasDiagnostico(CabecerasDiagnostico);
		cita.setCliente(cliente);
		cita.setVehiculo(vehiculo);
		
		CitaDao.insert(cita);
		

	}
	
	public static LocalDate Pedirfecha() {
		
		int PedirDatosAño;
		int PedirDatosMes;
		int PedirDatosDia;
		
			System.out.println("dame un año");
			PedirDatosAño = sc.nextInt();
			System.out.println("dame un mes");
			PedirDatosMes = sc.nextInt();
			System.out.println("dame un dia");
			PedirDatosDia = sc.nextInt();
		
			LocalDate ld = LocalDate.of(PedirDatosAño, PedirDatosMes, PedirDatosDia);
			ld.format((DateTimeFormatter.ofPattern("uuuu:MMM:d")));
			

			return ld;
		
	}
	
}
