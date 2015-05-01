package com.bon.main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame {

	private static final long serialVersionUID = -5311105052652648244L;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Hi there!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		JPanel c = new JPanel();
		c.setPreferredSize(new Dimension(500,500));
		c.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		con.weightx=.5;
		con.weighty=.5;
		con.anchor=GridBagConstraints.NORTH;
		con.fill=GridBagConstraints.HORIZONTAL;
		
		JButton button2 = new JButton("Hi");
		con.gridx=1;
		con.gridy=1;
		c.add(button2,con);
		
		con.gridx=0;
		con.gridy=2;
		JTextArea text = new JTextArea(10,10);
		text.setEditable(false);
		
		JScrollPane scroller = new JScrollPane(text);
		//scroller.setPreferredSize(new Dimension(20,20));
		c.add(scroller,con);
		
		JButton button = new JButton("Clik me nao");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				text.setText(text.getText()+"\nHi!");
			}});
		con.gridx=0;
		con.gridy=0;
		c.add(button);
		
		frame.add(c);
		frame.pack();
	}

}
