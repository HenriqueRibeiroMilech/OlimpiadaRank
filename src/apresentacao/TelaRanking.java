package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class TelaRanking {

	private JFrame frame;
	private JTable tableRanking;
	private JButton btnCadastrarModalidade;
	private JButton btnCadastrarPais;
	private JButton btnRandomizar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaRanking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tableRanking = new JTable();
		tableRanking.setBounds(33, 37, 365, 170);
		frame.getContentPane().add(tableRanking);
		
		JLabel lblRanking = new JLabel("Ranking");
		lblRanking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanking.setBounds(28, 12, 370, 19);
		frame.getContentPane().add(lblRanking);
		
		btnCadastrarModalidade = new JButton("<html><center>Cadastrar<br>Modalidade</center></html>");
		btnCadastrarModalidade.setBounds(33, 218, 89, 44);
		frame.getContentPane().add(btnCadastrarModalidade);
		
		btnCadastrarPais = new JButton("<html><center>Cadastrar<br>País</center></html>");
		btnCadastrarPais.setBounds(132, 218, 89, 44);
		frame.getContentPane().add(btnCadastrarPais);
		
		btnRandomizar = new JButton("Randomizar");
		btnRandomizar.setBounds(231, 218, 122, 44);
		frame.getContentPane().add(btnRandomizar);
		
		frame.setVisible(true);
	}
	
	public void desabilitarBotoes() {
		btnCadastrarPais.setEnabled(false);
		btnCadastrarModalidade.setEnabled(false);
		btnRandomizar.setEnabled(false);
	}

}
