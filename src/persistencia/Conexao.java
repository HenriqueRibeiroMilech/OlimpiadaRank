package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	  public static Connection Conectar() throws SQLException {
	        String url = "jdbc:mysql://localhost:3306/olimpiadarank";
	        String user = "FRmodena";
	        String password = "123456";
	        return DriverManager.getConnection(url, user, password);
	    }
}
