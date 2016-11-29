package controler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelMainFrame;
import view.ViewMainFrame;

public class ControlerMainFrame implements ActionListener{
	
	private final ViewMainFrame viewMainFrame;
    private final ModelMainFrame modelMainFrame;
	
	public ControlerMainFrame(ViewMainFrame viewMainFrame, ModelMainFrame modelMainFrame) {
		this.viewMainFrame = viewMainFrame;
		this.modelMainFrame = modelMainFrame;
		createTitleScreen();
	}

	// met le jeu dans une fenêtre
	public void createTitleScreen() {
        TitleScreen titleScreen = new TitleScreen();
        titleScreen.setVisible(true);
    }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
