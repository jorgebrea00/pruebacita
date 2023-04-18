package server;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import calendario.CrearCalendario;
import calendario.SaberSiExisteUnaCita;
import daos.CitaDao;
import model.CabecerasDiagnostico;
import model.Cita;
import model.Cliente;
import model.Vehiculo;

public class CitaServer {

	static Scanner sc = new Scanner(System.in);

	public static void insertarCitaServer(Cliente cliente, CabecerasDiagnostico CabecerasDiagnostico) {
		// probando en un usuario ya existente
		cliente.setId(1);
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(5);
		CabecerasDiagnostico.setId(1);
		Cita cita = new Cita();

		System.out.println("La disponibilidad de nuestro calendario es esta");
		System.out.println("Los que estan en XX no estan disponibles");


		CrearCalendario.printCalendario();

		LocalDate ld = Pedirfecha();

		cita.setFechaHora(ld);
		cita.setCabecerasDiagnostico(CabecerasDiagnostico);
		cita.setCliente(cliente);
		cita.setVehiculo(vehiculo);

		CitaDao.insert(cita);

	}

	public static LocalDate Pedirfecha() {

		LocalDate localDataInsertarFechaAuto = LocalDate.now();
		LocalDate localDataInsertarFechaAuto2 = LocalDate.now();
		localDataInsertarFechaAuto2 = localDataInsertarFechaAuto.plusMonths(1);

		int PedirDatosMes = 0;
		int PedirDatosDia = 0;
		boolean evaluarcita = false;
		boolean evaluardia = false;

		while (evaluarcita != true) {

			System.out.println("introduce en que mes quieres la cita");
			System.out.println("1. " + localDataInsertarFechaAuto.getMonth());
			System.out.println("2. " + localDataInsertarFechaAuto2.getMonth());

			PedirDatosMes = sc.nextInt();
			if (PedirDatosMes == 1 || PedirDatosMes == 2) {
				switch (PedirDatosMes) {

				case 1: {
					PedirDatosMes = localDataInsertarFechaAuto.getMonthValue();
					evaluarcita = true;
					break;
				}

				case 2:
					PedirDatosMes = localDataInsertarFechaAuto2.getMonthValue();
					evaluarcita = true;
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + PedirDatosMes);
				}

			} else {
				evaluarcita = false;
				System.out.println("tienes que dar un mes valido");

			}

		}

		while (evaluardia != true) {

			System.out.println("inserte un dia valido");
			PedirDatosDia = sc.nextInt();

			if (SaberSiExisteUnaCita.evaluarSiExiste(PedirDatosMes, PedirDatosDia)) {

				System.out.println("el dia no es valido");

			} else {

				LocalDate ld = LocalDate.of(localDataInsertarFechaAuto.getYear(), PedirDatosMes, PedirDatosDia);
				ld.format((DateTimeFormatter.ofPattern("uuuu:MMM:d")));
				evaluardia = true;
				return ld;

			}

		}

		return null;

	}

}
