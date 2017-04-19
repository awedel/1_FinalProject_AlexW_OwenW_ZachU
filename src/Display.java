


public class Display {

	public static void main(String[] args) {
		StdDraw.filledRectangle(.5, .5, .5, .5);
		
		StdDraw.picture(.5, .5, "New Piskel.png");
		try {
			Thread.sleep(30000);
			StdDraw.clear();
			StdDraw.rectangle(.25, .25, .1, .1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
