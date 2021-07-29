package view;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.SapoController;
import controller.ThreadSapos;

public class PrincipalInterfaceGrafica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalInterfaceGrafica frame = new PrincipalInterfaceGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	/**
	 * Create the frame.
	 */
	public PrincipalInterfaceGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Icon icon = new ImageIcon(
				"C:\\workspaces\\ws-eclipse\\Ex04_Thread_Corrida_Sapos\\src\\panel\\sapo_pequeno.png");
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setText("1");
		lblNewLabel.setBounds(24, 42, 87, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(icon);
		lblNewLabel_1.setText("2");
		lblNewLabel_1.setBounds(24, 99, 87, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(icon);
		lblNewLabel_2.setText("3");
		lblNewLabel_2.setBounds(24, 162, 87, 28);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(icon);
		lblNewLabel_3.setText("4");
		lblNewLabel_3.setBounds(24, 218, 87, 28);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(icon);
		lblNewLabel_4.setText("5");
		lblNewLabel_4.setBounds(24, 282, 87, 28);
		contentPane.add(lblNewLabel_4);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(256, 327, 95, 28);
		contentPane.add(btnIniciar);
		
		

		JLabel puloSapo1 = new JLabel();
		puloSapo1.setBounds(530, 11, 56, 14);
		contentPane.add(puloSapo1);

		JLabel puloSapo2 = new JLabel();
		puloSapo2.setBounds(530, 39, 56, 14);
		contentPane.add(puloSapo2);

		JLabel puloSapo3 = new JLabel();
		puloSapo3.setBounds(530, 64, 56, 14);
		contentPane.add(puloSapo3);

		JLabel puloSapo4 = new JLabel();
		puloSapo4.setBounds(530, 89, 56, 14);
		contentPane.add(puloSapo4);

		JLabel puloSapo5 = new JLabel();
		puloSapo5.setBounds(530, 113, 56, 14);
		contentPane.add(puloSapo5);

		JLabel distancia1 = new JLabel("Distancia 1");
		distancia1.setBounds(456, 11, 64, 14);
		contentPane.add(distancia1);

		JLabel distancia2 = new JLabel("Distancia 2");
		distancia2.setBounds(456, 39, 64, 14);
		contentPane.add(distancia2);

		JLabel distancia3 = new JLabel("Distancia 3");
		distancia3.setBounds(456, 64, 64, 14);
		contentPane.add(distancia3);

		JLabel distancia4 = new JLabel("Distancia 4");
		distancia4.setBounds(456, 89, 64, 14);
		contentPane.add(distancia4);

		JLabel distancia5 = new JLabel("Distancia 5");
		distancia5.setBounds(456, 110, 64, 14);
		contentPane.add(distancia5);

		SapoController sapocontroller = new SapoController(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3,
				lblNewLabel_4, btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		btnIniciar.addActionListener(sapocontroller);

	}
}
