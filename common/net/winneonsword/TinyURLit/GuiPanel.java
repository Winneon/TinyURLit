package net.winneonsword.TinyURLit;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class GuiPanel extends JFrame {

	private static final long serialVersionUID = 9124996888472024064L;
	
	private JLabel enter;
	private JTextField url;
	private JButton button;
	
	private JFrame dialog;
	private JLabel shortened;
	private JTextField link;
	private JButton ok;
	
	private String shortenedLink;
	
	public GuiPanel(){
		
		super("TinyURLit - A simple TinyURL client.");
		this.dialog = new JFrame("Shortened Link");
		
		this.shortenedLink = "";
		
		Container cont = this.getContentPane();
		Container cont2 = this.dialog.getContentPane();
		
		this.enter = new JLabel("<html><strong>Enter link to shorten: </strong><html>");
		this.url = new JTextField(24);
		this.button = new JButton("Shorten!");
		this.shortened = new JLabel("<html><strong>Shortened link: </strong></html>");
		this.link = new JTextField(24);
		this.ok = new JButton("Ok");
		
		this.url.setEditable(true);
		this.url.setToolTipText("Enter link to shorten.");
		this.url.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		ActionListener textAction = new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				runShorten();
				
			}
			
		};
		
		this.url.addActionListener(textAction);
		
		this.dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dialog.setResizable(false);
		this.dialog.setSize(400, 65);
		this.dialog.setLocationRelativeTo(null);
		this.dialog.setVisible(false);
		
		this.link.setEditable(false);
		this.link.setToolTipText("Shortened link");
		this.link.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		ActionListener okAction = new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				url.setText("");
				dialog.dispose();
				
			}
			
		};
		
		this.ok.addActionListener(okAction);
		
		ActionListener action = new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				runShorten();
				
			}
			
		};
		
		this.button.addActionListener(action);
		
		cont.add(this.enter, BorderLayout.WEST);
		cont.add(this.url, BorderLayout.CENTER);
		cont.add(this.button, BorderLayout.SOUTH);
		cont.setLayout(new FlowLayout());
		
		cont2.add(this.shortened, BorderLayout.WEST);
		cont2.add(this.link, BorderLayout.CENTER);
		cont2.add(this.ok, BorderLayout.SOUTH);
		cont2.setLayout(new FlowLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 85);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void runShorten(){
		
		boolean check = LinkShortener.checkLink(url.getText());
		
		if (!(check)){
			
			JOptionPane.showMessageDialog(null, "<html><strong>That is not a valid URL!</strong></html>", null, JOptionPane.ERROR_MESSAGE);
			
		} else {
			
			shortenedLink = LinkShortener.shorten(url.getText());
			link.setText(shortenedLink);
			dialog.setVisible(true);
			
		}
		
	}
	
}
