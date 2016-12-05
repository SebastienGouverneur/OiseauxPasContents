import controller.ControlerMainFrame;
import model.ModelMainFrame;
import view.ViewMainFrame;

public class Main {

		public static void main(String[] args) {
			
			ModelMainFrame modelMainFrame = new ModelMainFrame();
	        ViewMainFrame viewMainFrame = new ViewMainFrame(modelMainFrame);
	        ControlerMainFrame controlerMainFrame = new ControlerMainFrame(viewMainFrame, modelMainFrame);
		}
}
