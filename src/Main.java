import org.lwjgl.Version;
import static org.lwjgl.glfw.GLFW.* ;

public class Main {
	
	public Main() {
		glfwInit() ;
		
		long win = glfwCreateWindow(640, 480, "Window", 0, 0);
		
		glfwShowWindow(win);
		
		while (!glfwWindowShouldClose(win)) {
			glfwShowWindow(win);
		}
	}
	
	
	public static void main(String[] args){
		new Main();
		
		
	}
}
