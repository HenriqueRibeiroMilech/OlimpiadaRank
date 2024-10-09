package apresentacao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import entidades.Usuario;
import persistencia.Conexao;
import persistencia.UsuarioDAO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

    private JFrame frame;
    private JTextField textUsuario;
    private JPasswordField passwordSenha;
    Connection connection = null;

    public TelaLogin() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 210);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblOlimpiadaRank = new JLabel("OlimpiadaRank");
        lblOlimpiadaRank.setHorizontalAlignment(SwingConstants.CENTER);
        lblOlimpiadaRank.setFont(new Font("Tahoma", Font.ITALIC, 30));
        lblOlimpiadaRank.setBounds(32, 11, 356, 66);
        frame.getContentPane().add(lblOlimpiadaRank);
        
        textUsuario = new JTextField();
        textUsuario.setBounds(32, 106, 130, 20);
        frame.getContentPane().add(textUsuario);
        textUsuario.setColumns(10);
        
        JLabel lblUsuario = new JLabel("Usuário (admin)");
        lblUsuario.setBounds(32, 88, 130, 14);
        frame.getContentPane().add(lblUsuario);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(258, 88, 130, 14);
        frame.getContentPane().add(lblSenha);
        
        passwordSenha = new JPasswordField();
        passwordSenha.setBounds(258, 106, 130, 20);
        frame.getContentPane().add(passwordSenha);
        
        JLabel lblMsnAutenticacao = new JLabel("");
        lblMsnAutenticacao.setBounds(179, 137, 209, 23);
        frame.getContentPane().add(lblMsnAutenticacao);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    connection = Conexao.Conectar();
                    UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                    
                    String usuarioNome = textUsuario.getText();
                    String senha = new String(passwordSenha.getPassword());
                    
                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
                    
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNome().equals(usuarioNome) && usuario.getSenha().equals(senha)) {
                        		lblMsnAutenticacao.setText("Autenticado com sucesso!");
                        		TelaRanking telaranking = new TelaRanking();
                        		frame.dispose();
                        	return;
                        }
                    }
                    lblMsnAutenticacao.setText("Usuário ou senha incorretos!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        btnLogin.setBounds(32, 137, 89, 23);
        frame.getContentPane().add(btnLogin);
        
        frame.setVisible(true);
    }
}

