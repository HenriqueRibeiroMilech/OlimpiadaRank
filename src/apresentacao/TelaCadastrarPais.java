package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidades.Pais;
import entidades.Usuario;
import persistencia.Conexao;
import persistencia.PaisDAO;
import persistencia.UsuarioDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastrarPais {

	private JFrame frame;
	private JTextField textId;
	private JTextField textNomePais;
	private JTextField textContinente;
	private Connection connection;
	private Conexao conexao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarPais window = new TelaCadastrarPais();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastrarPais() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIdPais = new JLabel("ID:");
		lblIdPais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPais.setBounds(34, 25, 45, 13);
		frame.getContentPane().add(lblIdPais);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(56, 22, 96, 19);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblNomePais = new JLabel("Nome do Pais:");
		lblNomePais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomePais.setBounds(34, 64, 78, 13);
		frame.getContentPane().add(lblNomePais);
		
		textNomePais = new JTextField();
		textNomePais.setBounds(116, 61, 96, 19);
		frame.getContentPane().add(textNomePais);
		textNomePais.setColumns(10);
		
		textContinente = new JTextField();
		textContinente.setBounds(116, 102, 96, 19);
		frame.getContentPane().add(textContinente);
		textContinente.setColumns(10);
		
		JLabel lblContinente = new JLabel("Continenete");
		lblContinente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContinente.setBounds(34, 105, 78, 13);
		frame.getContentPane().add(lblContinente);
		
		JButton btnInserirPais = new JButton("Inserir");
		btnInserirPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPais();
				limparCampos();
			}
		});
		btnInserirPais.setBounds(34, 149, 85, 21);
		frame.getContentPane().add(btnInserirPais);
		
		JButton btnExclusao = new JButton("Exclusao");
		btnExclusao.setBounds(129, 149, 85, 21);
		frame.getContentPane().add(btnExclusao);
		
		JButton btnAlterarPais = new JButton("Alterar");
		btnAlterarPais.setBounds(224, 149, 85, 21);
		frame.getContentPane().add(btnAlterarPais);
	}
	
	private void cadastrarPais() {
	    try {
	    	connection = conexao.Conectar();
	    	PaisDAO paisDAO = new PaisDAO(connection);
	    	
	        if (textNomePais.getText().isEmpty() || textContinente.getText().isEmpty()) {
	            JOptionPane.showMessageDialog(frame, "Nome do País ou Continente em branco!", "Aviso", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        Pais pais = new Pais();
	        pais.setNomedopais(textNomePais.getText());
	        pais.setContinente(textContinente.getText());

	        paisDAO.cadastrarPais(pais);
	        JOptionPane.showMessageDialog(frame, "País cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(frame, "Erro ao cadastrar o país: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
	
	private void limparCampos() {
		textContinente.setText("");
		textNomePais.setText("");
		textId.setText("");
	}
}
