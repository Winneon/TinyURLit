package net.winneonsword.TinyURLit;

import javax.swing.UIManager;

public class MainTUI {
	
	public static void main(String[] args){
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (Exception e){
			
			// Nothing!
			
		}
		
		new GuiPanel();
		
	}
	
}
