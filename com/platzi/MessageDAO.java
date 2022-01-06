package com.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
*
* @author EpicGex
*/

public class MessageDAO {

	final static String MESSAGE_CREATED = "Mensaje creado";
	final static String ERROR_MESSAGE = "Se encontró un error en el proceso";
	
	public static void createMessageDB(Message message) {

		String query="insert into mensajes(mensaje,autor_mensaje, fecha_mensaje) values (?,?,CURRENT_TIMESTAMP)";
		
		try (Connection conexion = Conector.connect()) {
            PreparedStatement ps=conexion.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getMessageAuthor());
            ps.executeUpdate();
            System.out.println(MESSAGE_CREATED);
		} catch(SQLException e) {
			System.out.println(ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	public static void readMessageDB() {

		String query = "SELECT * FROM mensajes";

		try (Connection conexion = Conector.connect()) {
			
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt("id_mensaje"));
				System.out.println("Mensaje: " + rs.getString("mensaje"));
				System.out.println("Autor " + rs.getString("autor_mensaje"));
				System.out.println("Fecha " + rs.getString("fecha_mensaje"));
				System.out.println("");
			}
			
		} catch (SQLException ex) {
			System.out.println(ERROR_MESSAGE);
			System.out.println(ex);
		}
	}
	
	public static void updateMessageDB(Message message) {
		
		String query = "UPDATE mensajes SET mensaje = ?, autor_mensaje = ? where id_mensaje = ?";

		try (Connection conexion = Conector.connect()){
			PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getMessageAuthor());
            ps.setInt(3, message.getIdMessage());
            ps.executeUpdate();
			System.out.println("Mensaje ID: " + message.getIdMessage() + " actualizado");
//			conexion.close();
		} catch(SQLException e) {
			System.out.println(ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	public static void deleteMessageDB(int idMessage) {
		
		String query = "DELETE FROM mensajes where id_mensaje = ?";
		
		try (Connection conexion = Conector.connect()){
			PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, idMessage);
            int countRowsUpdated =ps.executeUpdate();
            if (countRowsUpdated != 0) {
				System.out.println("Message ID: " + idMessage + " has been deleted successfully.");
			} else {
				System.out.println("Message ID: " + idMessage + " was not found.");
            }
//            conexion.close();
		} catch(SQLException e) {
			System.out.println(ERROR_MESSAGE);
			System.out.println(e);
		}
	}
}
