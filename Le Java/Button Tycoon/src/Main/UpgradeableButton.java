package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UpgradeableButton extends JButton{
	
	private boolean bought = false;
	private int initCost;
	private int generation;
	private String message;
	
	public void buy()
	{
		this.bought = true;
		this.setText("Generating $" + this.generation + "/s");
		Main.money-=this.initCost;
	}
	public boolean isBought()
	{
		return bought;
	}
	public String getMessage()
	{
		return this.message;
	}
	
	public UpgradeableButton(int initCost, int generation)
	{
		super();
		this.generation = generation;
		this.initCost = initCost;
		this.setText("Initial cost: " + initCost + " Generates: $" + generation + "/s");
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isBought() && Main.money >= initCost)
				{
					buy();
					(new Thread(new Incrementing(generation))).start();;
				}
			}});
	}
}
