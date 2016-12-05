package controller;

public class Application {
	private static Application instance = null;
	
	private ApplicationFrame appFrame;
	
	
	public Application() {
		if(instance != null) {
			throw new RuntimeException("can be instancied only once");
		}
		
		instance = this;
		init();
	}
	
	public static Application getInstance() {
		return instance;
	}
	
	public void init() {
		appFrame = new ApplicationFrame();
	}
	
	public static void main(String[] args) {
		new Application();
	}
	
}
