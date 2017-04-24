import static org.lwjgl.glfw.GLFW.* ;
import static org.lwjgl.opengl.GL11.* ;
import static org.lwjgl.system.MemoryUtil.* ;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import lwjgl.Input;

public class DisplayTest implements Runnable {
	
	private Thread thread ;
	public boolean running = true ;
	public Long window ;
	
	private GLFWKeyCallback keyCallback ;
	
	public static void main(String[] args){
	   DisplayTest game = new DisplayTest() ;
	   game.start();
	}
	
	
	public void start() {
		running = true ;
		thread = new Thread(this, "GameName") ;
		thread.start();
	}
	
	public void init() {
		
		if (glfwInit() != true) {
			System.err.println("GLFW init failed!");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		window = glfwCreateWindow(512, 512, "GameName", NULL, NULL) ;
		
		if (window == NULL) {
			System.err.println("Could not create window!");
		}
		
		glfwSetKeyCallback(window, new Input()) ;
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor()) ;
		glfwSetWindowPos(window, 100, 100);
		
		glfwMakeContextCurrent(window);
		
		glfwShowWindow(window) ;
		
		GL.createCapabilities() ;
		
		glClearColor(.56f, .258f, .425f, 1.0f);
		
		glEnable(GL_DEPTH_TEST);
		
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
	}
	
	public void update() {
		glfwPollEvents();
		
		if (Input.keys[GLFW_KEY_SPACE]) {
			System.out.println("Space KeyPressed!");
		}
	}
	
	public void render() {
		glfwSwapBuffers(window);
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	@Override
	public void run() {
		init() ;
		while(running) {
			update() ;
			render() ;
			
			
			if (glfwWindowShouldClose(window)) {
				running = false ;
			}
		}
		
	}
}
