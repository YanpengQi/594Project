import javax.swing.JFrame;
/**
 * This is the main class for Swing demo
 * @author Yilin Sun
 *
 */
public class DemoFrame extends JFrame {
	/**
	 * Constructor for DemoFrame
	 * @param panel
	 */
	public DemoFrame(DemoPanel panel)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setTitle("Currency Change Game Demo");
		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
	}
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args)
	{
		DemoPanel panel = new DemoPanel();
		DemoFrame Frame = new DemoFrame(panel);
		//panel.setResult("aaaaa");
	}	


}
