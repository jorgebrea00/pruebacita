package server;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	
	  public static void printCalendario(int m, int a){
	        LocalDate ld = LocalDate.of(a, m, 1);
	        int vueltas=1;
	    	while(vueltas!=3) {
	    		
	    		if (vueltas==2) {
					ld = ld.withMonth(m+1);
				}
	        int dias = 1;
	        int dow = ld.getDayOfWeek().getValue();//obtener día de la semana del primer día del mes 
	        int max = ld.lengthOfMonth();//obtiene el maximo de días.
	        
	        System.out.println("                    "+ld.getMonth().toString());
	         
	        for(int i = 1; i<8 ; i++){//Imprime encabezado del enum DayOfWeek
	     
	            System.out.print("| "+DayOfWeek.of(i).toString().substring(0,2)+" |");
	        }
	      
	  
	        
	        boolean empezo = false;
	        for(int i = 1; i<7 ; i++){//semanas por mes   
	            System.out.println();  
	            for(int j = 1; j<8 ; j++){//día por semana   
	                if(j==dow){
	                    empezo = true;
	                }
	                if(!empezo || dias>max){
	                    System.out.print("| XX |");
	                }
	                else if(empezo){
	                	
	                	if () {
	                		 System.out.print("| "+"  "+" |");   
							dias++;
						}else {
	                    System.out.print("| "+(dias<10?("0"+dias):(""+dias))+" |");   
	                    dias++;}
	                }
	            }
	        }
	        
	        System.out.println("       ");
	        vueltas++;
	        }
	         
	    }
	  
	  public boolean evaluarSiExiste(int dia , int mes) {
		     ArrayList<LocalDate> arrayListCitas = CitaDao.LeePorFechaEnAdelante(LocalDate.now().withDayOfMonth(1));
		     
		     
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
