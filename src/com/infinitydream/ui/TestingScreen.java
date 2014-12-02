package com.infinitydream.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.infinitydream.tester.Manager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestingScreen extends JFrame {

    private JPanel contentPane;
    private JTextField inputpath_textbox;
    private JTextField outputpath_textbox;
    private JTextField calcurl_textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TestingScreen frame = new TestingScreen();
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
    public TestingScreen() {
	setTitle("InfinityDream Claculator Tester");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 377);

	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);

	JMenuItem mntmAbout = new JMenuItem("About");
	mnHelp.add(mntmAbout);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	inputpath_textbox = new JTextField();
	inputpath_textbox.setBounds(12, 128, 309, 25);
	contentPane.add(inputpath_textbox);
	inputpath_textbox.setColumns(10);

	JButton btnBrowse = new JButton("Browse");
	btnBrowse.setBounds(333, 128, 103, 25);
	contentPane.add(btnBrowse);

	outputpath_textbox = new JTextField();
	outputpath_textbox.setEditable(false);
	outputpath_textbox.setColumns(10);
	outputpath_textbox.setBounds(12, 202, 424, 25);
	contentPane.add(outputpath_textbox);

	JLabel lblInputTestset = new JLabel("Input testset");
	lblInputTestset.setBounds(12, 83, 200, 50);
	contentPane.add(lblInputTestset);

	JLabel lblOutputTestset = new JLabel("Output testset");
	lblOutputTestset.setBounds(12, 159, 200, 50);
	contentPane.add(lblOutputTestset);

	JButton btnRunTest = new JButton("Run Test");
	btnRunTest.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		runTester();
	    }
	});
	btnRunTest.setBounds(121, 251, 217, 53);
	contentPane.add(btnRunTest);
	
	calcurl_textField = new JTextField();
	calcurl_textField.setColumns(10);
	calcurl_textField.setBounds(12, 45, 424, 25);
	contentPane.add(calcurl_textField);
	
	JLabel lblCalculatorUrl = new JLabel("Calculator url");
	lblCalculatorUrl.setBounds(12, 0, 200, 50);
	contentPane.add(lblCalculatorUrl);
	
	//default online calculator
	calcurl_textField.setText("file:///home/divoo/workspace/4th_year_workspace/CalculatorTester/WebCalculator/index.html");
	
    }

    private void runTester() {

	final String url = calcurl_textField.getText();
	final String inpath = inputpath_textbox.getText();
	int slashidx = inpath.lastIndexOf("/");
	final String outpath = inpath.substring(0, slashidx + 1) + "result_"
		+ inpath.substring(slashidx + 1);

	outputpath_textbox.setText(outpath);

	Runnable rn = new Runnable() {
	    @Override
	    public void run() {
		if (Manager.runTest(url, inpath, outpath))
		    JOptionPane.showMessageDialog(null,
			    "Testing finished successfully");
		else
		    JOptionPane.showMessageDialog(null, "Error");
	    }
	};
	
	new Thread(rn).start();
    
    }
}
