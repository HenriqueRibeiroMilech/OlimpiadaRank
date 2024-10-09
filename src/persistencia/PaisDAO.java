package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Pais;

public class PaisDAO {
    private Connection connection;

    public PaisDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void cadastrarPais(Pais pais) throws SQLException {
    	String sql = "INSERT INTO paises (nome, continente) VALUES(?,?)";
    	
    	try(PreparedStatement stmt = connection.prepareStatement(sql)){
    		stmt.setString(1, pais.getNomedopais());
    		stmt.setString(2, pais.getContinente());
    		stmt.executeUpdate();
    	}catch (SQLException e){
    		throw new SQLException("Erro ao cadastrar pais: "+e.getMessage(), e);
    	}
    	
    }
    

}
