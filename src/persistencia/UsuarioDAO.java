package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Usuario;

public class UsuarioDAO {
	    private Connection connection;

	    public UsuarioDAO(Connection connection) {
	        this.connection = connection;
	    }

	    public List<Usuario> listarUsuarios() {
	        List<Usuario> usuarios = new ArrayList<>();
	        String sql = "SELECT * FROM usuarios";

	        try (PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setId(rs.getInt("usuario_id"));
	                usuario.setNome(rs.getString("usuario_nome"));
	                usuario.setSenha(rs.getString("senha"));
	                usuarios.add(usuario);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return usuarios;
	    }
	}
