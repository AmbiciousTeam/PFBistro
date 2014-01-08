package br.com.ambiciousteam.pfbistro.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class loadBar extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loadBar frame = new loadBar();
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
	public loadBar() {
		setUndecorated(true);
		setBounds(100, 100, 185, 75);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(19, 30, 146, 14);
		setResizable(false);
		getContentPane().add(progressBar);

	}
}
