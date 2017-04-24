package lwjgl;

import org.lwjgl.glfw.GLFWKeyCallback ;
import static org.lwjgl.glfw.GLFW.* ;

public class Input extends GLFWKeyCallback {
	
	public static boolean[] keys = new boolean[65535] ;

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		// TODO Auto-generated method stub
		keys[key] = action != GLFW_RELEASE ;
	}

}
