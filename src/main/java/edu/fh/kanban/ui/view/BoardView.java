package edu.fh.kanban.ui.view;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView implements View{

	@Override
	public JComponent getComponent() {
		return new JPanel();
	}
	
	public void boardy(){
		JLabel jl = new JLabel("Hallo");
		jl.setBounds(100, 100, 50, 20);
		getComponent().add(jl);
	}

	

}