package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
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
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOlimpiadaRank = new JLabel("OlimpiadaRank");
		lblOlimpiadaRank.setHorizontalAlignment(SwingConstants.CENTER);
		lblOlimpiadaRank.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblOlimpiadaRank.setBounds(31, 11, 356, 66);
		frame.getContentPane().add(lblOlimpiadaRank);
		
		JButton btnUsuario = new JButton("Usuário");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRanking telaranking = new TelaRanking();
				telaranking.desabilitarBotoes();
			}
		});
		btnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUsuario.setBounds(31, 88, 135, 40);
		frame.getContentPane().add(btnUsuario);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telalogin = new TelaLogin();
				frame.dispose();
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdmin.setBounds(252, 88, 135, 40);
		frame.getContentPane().add(btnAdmin);
		
	}

}
