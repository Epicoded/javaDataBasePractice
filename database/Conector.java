package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
	final static String DIRECTORY = System.getProperty("user.dir");

	static final String URL = DIRECTORY + "/data/mensajes.db";
	static Connection connect;

	public static Connection connect() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + URL);
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
		return connect;
	}

	public void close() {
		try {
			connect.close();
		} catch (SQLException ex) {
			Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}