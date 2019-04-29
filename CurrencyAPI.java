import java.net.URL;
import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * class that parses API 
 * @author Yanpeng Qi, Yilin Sun, Scarlett Yu
 *
 */
public class CurrencyAPI {
		ArrayList<CurrencyInfo> currenciesList;
		
		
	/**
	 * Parse the JSON response String
	 * @param jsonResponse
	 * @return CurrencyInfo object
	 * @throws JSONException 
	 */ 
	public CurrencyInfo ParseCurrencyJason(String jsonResponse) throws JSONException {
        //create a JSON object with the String response
        JSONObject jObj = new JSONObject(jsonResponse);
        //Look at the raw String response
        //Look for the results key
        //After the colon there is a square bracket indicating a JSONArray
        String name = jObj.getString("base");
        CurrencyInfo cur = new CurrencyInfo(name);
        JSONArray jArray1 = jObj.getJSONArray("rates");
        
        for(int i = 0; i < jArray1.length(); i++) {
        String xCurrency=jArray1.getJSONObject(i).getString("rates");
        CurrencyInfo newCur = new CurrencyInfo(xCurrency);
        double xrate = jArray1.getJSONObject(i).getDouble(xCurrency);
        cur.add(newCur, xrate);
        }
 

        return cur;
		
	}
	
	/**
	 * method that forms the URL for currency
	 * @param baseCurrency
	 * @return URL
	 */
	public String createURL(String baseCurrency) {
		String baseURL = "https://data.fixer.io/api/";
        String url2 = "latest ? access_key = ";
        String key = "7967581a70b4177df6a605ba5cd9e60e";
        String base = "& base =";
        String currencyUrl = baseURL + url2 + key + base + baseCurrency;
        return  currencyUrl;
	}
	/**
	 * Makes the API call and returns the JSON result as a String
	 * @param url
	 * @return JSON result
	 * @throws IOException 
	 */
	public String makeAPICall(URL url) throws IOException {
        URLConnection yc;
        BufferedReader in;
        yc = url.openConnection();
        in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        //Why StringBuffer? - StringBuffer is mutable so we can append to it
        StringBuffer response = new StringBuffer();
        //BufferedReader does not have a "hasNext" type method so this is how to check for
        //more input
        //if it has more input append to the StringBuffer
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
	}
}
