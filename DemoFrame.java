import javax.swing.JFrame;

public class DemoFrame extends JFrame {
	public DemoFrame(DemoPanel panel)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setTitle("Currency Change Game Demo");
		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		DemoPanel panel = new DemoPanel();
		DemoFrame Frame = new DemoFrame(panel);
		//panel.setResult("aaaaa");
	}	


}
