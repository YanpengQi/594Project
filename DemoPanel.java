import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JTextField;
/**
 * This class is the Java Swing demo page for the project, it creates several button and input sections for the users
 * @author Yilin Sun
 *
 */
	public class DemoPanel extends JPanel{
	private JLabel baseCurrency,amounts,limitNum;            
	private JButton button,button2;         
	private JTextField textCurrency, textAmounts,textlimitNum;             
    private JLabel label;         
    private JPanel panelInfo;
    private JPanel panelShowResult;
    private JPanel panelLoginButton;
    private String result;
    
    DemoPanel() {
		createButtonAndListener();
		createComponents();
	}
	/**
	 * the method create components for demo
	 */
    public void createComponents(){
    	this.baseCurrency = new JLabel("Base currency:");
    
    	this.amounts = new JLabel("       Amounts:");
    	this.limitNum=new JLabel("Exchanging currency number (1-10):");
    	
    	this.textCurrency = new JTextField(10);
    	this.textAmounts = new JTextField(10);
    	this.textlimitNum=new JTextField(10);
    	
    	this.panelInfo = new JPanel();
    	this.panelLoginButton = new JPanel();
    	this.panelShowResult=new JPanel();
    	
    	this.setLayout(new GridLayout(3, 1)); 
    	
    	this.panelInfo.add(this.baseCurrency);
    	this.panelInfo.add(this.textCurrency);
    	this.panelInfo.add(this.amounts);
    	this.panelInfo.add(this.textAmounts);
    	this.panelInfo.add(this.limitNum);
    	this.panelInfo.add(this.textlimitNum);
    
    	
    	this.add(this.panelInfo);
    	
    	this.add(this.panelLoginButton);
    	 label = new JLabel("Show the answer here!");
		 //textField = new JTextField(10);
		 panelShowResult = new JPanel();
		 //panel.add(textField);
		 panelShowResult.add(label);
		 panelShowResult.add(button);
		 panelShowResult.add(button2);
		 add(panelShowResult);

		
    }
    /**
     * this method creates buttons and listeners
     */
    private void createButtonAndListener() {
    	button = new JButton("Go");
    	button.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//we have access to all of the Frames components now
    			//System.out.println(textCurrency.getText());
    			//System.out.println(textAmounts.getText());
    			//System.out.println(textlimitNum.getText());
    			if(textlimitNum.getText().equals("1")) {
    				label.setText("ERROR! Need have more currency.");
    			}
    			else if(textCurrency.getText().equals("CNY")) {
    				label.setText("CNY->JPY->EUR->USD->CNY "+ "Initial Amount: "+ textAmounts.getText()+"-> Final Amount: 101");
    			}else if(textCurrency.getText().equals("USD")) {
    			label.setText("USD->JPY->EUR->CNY->USD "+ "Initial Amount: "+ textAmounts.getText()+"-> Final Amount: 101");
    			//label.setText(result);
    		}else if(textCurrency.getText().equals("JPY")) {
    			label.setText("JPY->CNY->USD->EUR->JPY "+"Initial Amount: "+textAmounts.getText()+"-> Final Amount: 100.3");
    		}else if(textCurrency.getText().equals("EUR")) {
    			label.setText("EUR->JPY->CNY->USD->EUR "+"Initial Amount: "+textAmounts.getText()+"-> Final Amount: 100.5");
    		}else {
    			label.setText("ERROR! No such currency.");
    		}
    		}
    	});
    	button2 = new JButton("Reset");
    	button2.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//we have access to all of the Frames components now
    			
    			label.setText("Show the answer here!");
    			textCurrency.setText("");
    			textAmounts.setText("");
    			textlimitNum.setText("");
    			
    		}
    	});
	
	}
    /**
     * setter for result
     * @param result 
     */
public void setResult(String result) {
	this.result=result;
}
}
