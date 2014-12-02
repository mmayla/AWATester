package com.infinitydream.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class About extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    About frame = new About();
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
    public About() {
    	setTitle("About");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 342, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel logolabel = new JLabel("");
	logolabel.setIcon(new ImageIcon(About.class.getResource("/com/infinitydream/ui/Infinity_Dream_logo_small.png")));
	logolabel.setBounds(50, 12, 213, 140);
	contentPane.add(logolabel);
	
	JLabel lblNewLabel = new JLabel("team");
	lblNewLabel.setBounds(275, 64, 64, 50);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Ahmed AlZoghby");
	lblNewLabel_1.setBounds(50, 151, 164, 34);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblMohamedMayla = new JLabel("Mohamed Mayla");
	lblMohamedMayla.setBounds(175, 180, 164, 34);
	contentPane.add(lblMohamedMayla);
	
	JLabel lblRaneemMedhat = new JLabel("Raneem Medhat");
	lblRaneemMedhat.setBounds(50, 210, 164, 34);
	contentPane.add(lblRaneemMedhat);
	
	JLabel lblBy = new JLabel("By");
	lblBy.setBounds(14, 0, 200, 50);
	contentPane.add(lblBy);
    }
}
