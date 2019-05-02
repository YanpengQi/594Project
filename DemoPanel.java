import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JTextField;

import org.json.JSONException;

public class DemoPanel extends JPanel{
	private JLabel baseCurrency,amounts,limitNum;            
	private JButton button,button2;         
	private JTextField textCurrency, textAmounts,textlimitNum;             
    private JLabel label;         
    private JPanel panelInfo;
    private JPanel panelShowResult;
    private JPanel panelLoginButton;
    private String result;
    private ArrayList<CurrencyInfo>list;
    private String[]array= {"AED","AFN","CAD","BZD","USD","CNY","EUR","GBP","JPY","HRK","TWD","EGP","BRL","IDR","HUF","FKP","NAD","TRY","ZWL","QAR"};
	
    public JTextField getTextCurrency() {
		return textCurrency;
	}

	public JTextField getTextAmounts() {
		return textAmounts;
	}

	public JTextField getTextlimitNum() {
		return textlimitNum;
	}

	DemoPanel() throws IOException, JSONException {
		createButtonAndListener();
		createComponents();
	}
	
    public void createComponents() throws IOException, JSONException{
    	list=new ArrayList<CurrencyInfo>();
    	this.baseCurrency = new JLabel("Base currency:");
    
    	this.amounts = new JLabel("       Amounts:");
    	this.limitNum=new JLabel("Exchanging currency (1-10):");
    	
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
		 for(int i=0;i<array.length;i++) {
		    API currency = new API();
			String s = currency.createURL(array[i]);
			URL url = new URL(s);
			String response=currency.makeAPICall(url);
			CurrencyInfo cur=currency.ParseCurrencyJason(response);
			list.add(cur);
    }
    }
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
			else if(textCurrency.getText().equals("CHY")) {
				label.setText("CHY->JPY->EUR->USD->CHY "+textAmounts.getText()+"-> 101");
			}else if(textCurrency.getText().equals("USD")) {
			label.setText("USD->JPY->EUR->CHY->USD "+textAmounts.getText()+"-> 101");
			//label.setText(result);
		}else if(textCurrency.getText().equals("JPY")) {
			label.setText("JPY->CHY->USD->EUR->JPY "+textAmounts.getText()+"-> 100.3");
		}else if(textCurrency.getText().equals("EUR")) {
			label.setText("EUR->JPY->CHY->USD->EUR "+textAmounts.getText()+"-> 100.5");
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
public void setResult(String result) {
	this.result=result;
}
}
