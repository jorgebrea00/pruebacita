package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Cita;


public class CitaDao {

	private String tabla="citas";
	private Connection conexion;


		public int insert(Cita cita) {
			String ordenSql="insert into "+tabla+" values (?, ?, ?)"; 	 
			try (PreparedStatement ps = conexion.prepareStatement(ordenSql, Statement.RETURN_GENERATED_KEYS);
					) {
				ps.setNull(1, 0);										// id auto-generado
				ps.setObject(2, cita.getFechaHora());
				ps.setObject(3, cita.getCabecerasDiagnostico());
				ps.setObject(4, cita.getCliente());
				ps.setObject(5, cita.getVehiculo());
				ps.executeUpdate();	
				ResultSet claveGenerada=ps.getGeneratedKeys();
				claveGenerada.next();									
				return claveGenerada.getInt(1); // Le decimos que guarde en id la clave generada en la primera columna.
			}catch (Exception e){		
				//System.out.println(Mensajes.ERROR_GRABAR_REGISTRO + e.getMessage());
				e.printStackTrace();
				return 0;
			}
		}

/*
		@Override
		public Login read  (int id) {
			Login login=new Login();
			String ordenSql="select * from "+tabla+ " where id= ?";
			try(PreparedStatement ps=conexion.prepareStatement(ordenSql)){	
				ps.setInt(1, id);
				ps.executeQuery();
				try (ResultSet rs=ps.getResultSet()){
					rs.next();
					login.setId(rs.getInt(1));
					login.setEmail(rs.getString(2));
					login.setPassHash(rs.getNString(3));
				}catch(SQLException e){
					System.out.println("El id "+id+" no existe en la base de datos.");
					login=null;
				}
			}catch (Exception e1){	
				System.out.println(Mensajes.ERRORDELECTURA+e1.getMessage());
			} finally {
				return  login;
			}
		}
		

		public Login read  (String datoBuscado, String nombreCampo) {
			Login login=new Login();
			String ordenSql="select * from "+tabla+ " where "+nombreCampo+"= ?";
			try(PreparedStatement ps=conexion.prepareStatement(ordenSql)){	
				ps.setString(1, datoBuscado);
				ps.executeQuery();
				try (ResultSet rs=ps.getResultSet()){
					rs.next();
					login.setId(rs.getInt(1));
					login.setEmail(rs.getString(2));
					login.setPassHash(rs.getNString(3));
				}catch(SQLException e){
					login=null;
				}
			}catch (Exception e1){	
				System.out.println(Mensajes.ERRORDELECTURA+e1.getMessage());
			} finally {
				return  login;
			}
		}
		
		
		@Override
		public List<Login> getAll() {
			List <Login> listaResultado=new ArrayList<>();
			String ordenarPor="email";
			String ordenSql="select * from "+tabla+" order by "+ordenarPor+" asc";
			try(Statement stm=conexion.createStatement();
					ResultSet rs=stm.executeQuery(ordenSql)){	
				while (rs.next()) {
					Login login=new Login();
					login.setId(rs.getInt(1));
					login.setEmail((rs.getString(2)));
					login.setPassHash(rs.getNString(3));
					listaResultado.add(login);
				}
				return listaResultado;
			}catch (Exception e){		
				System.out.println(Mensajes.ERRORDELECTURA + e.toString() );
				Conexion.desconectarBBDD(conexion);
				return Collections.emptyList();
			}
		}

		@Override
		public int update(Login Login) {
			String campo1="email";
			String campo2="pass_hash";
			String campoBusqueda="id";
			String ordenSql="update "+tabla+" set "+campo1+" = ?, "+campo2+" = ? where "+campoBusqueda+"=?";
			try(PreparedStatement ps=conexion.prepareStatement(ordenSql)){
				ps.setString(1, Login.getEmail());
				ps.setString(2, Login.getPassHash());
				ps.setInt(3, Login.getId());
				int numeroRegistrosAfectados=ps.executeUpdate();
				ps.close();
				return numeroRegistrosAfectados;
			}catch (Exception e){		
				System.out.println(Mensajes.ERROR_GRABAR_REGISTRO + e.getMessage() );
				Conexion.desconectarBBDD(conexion);
				return 0;
			}
		}

		@Override
		public int delete(Login login) {
			String campoBusqueda="id";
			String ordenSql="delete from "+tabla+" WHERE "+campoBusqueda+"=?";
			try(PreparedStatement ps=conexion.prepareStatement(ordenSql)){
				ps.setInt(1, login.getId());
				int numeroRegistrosAfectados=ps.executeUpdate(); 			
				ps.close();
				return numeroRegistrosAfectados;
			}catch (Exception e){		
				System.out.println(Mensajes.ERROR_BORRAR_REGISTRO + e.getMessage() );
				Conexion.desconectarBBDD(conexion);
				return 0;
			}		
		}*/
}
