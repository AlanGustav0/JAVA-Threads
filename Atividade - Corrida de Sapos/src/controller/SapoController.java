package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SapoController implements ActionListener {

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnIniciar;
	private JLabel puloSapo1;
	private JLabel puloSapo2;
	private JLabel puloSapo3;
	private JLabel puloSapo4;
	private JLabel puloSapo5;


	public SapoController(JLabel lblNewLabel, JLabel lblNewLabel_1, JLabel lblNewLabel_2, JLabel lblNewLabel_3,
			JLabel lblNewLabel_4, JButton btnIniciar,JLabel puloSapo1,JLabel puloSapo2,JLabel puloSapo3,JLabel puloSapo4,JLabel puloSapo5) {
		this.lblNewLabel = lblNewLabel;
		this.lblNewLabel_1 = lblNewLabel_1;
		this.lblNewLabel_2 = lblNewLabel_2;
		this.lblNewLabel_3 = lblNewLabel_3;
		this.lblNewLabel_4 = lblNewLabel_4;
		this.btnIniciar = btnIniciar;
		this.puloSapo1 = puloSapo1;
		this.puloSapo2 = puloSapo2;
		this.puloSapo3 = puloSapo3;
		this.puloSapo4 = puloSapo4;
		this.puloSapo5 = puloSapo5;


	}

	private void botaoSapos() {
		Thread sapo1 = new ThreadSapos(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,
				btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		Thread sapo2 = new ThreadSapos(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,
				btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		Thread sapo3 = new ThreadSapos(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,
				btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		Thread sapo4 = new ThreadSapos(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,
				btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		Thread sapo5 = new ThreadSapos(lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4,
				btnIniciar,puloSapo1,puloSapo2,puloSapo3,puloSapo4,puloSapo5);
		sapo1.start();
		sapo2.start();
		sapo3.start();
		sapo4.start();
		sapo5.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoSapos();

	}

}
