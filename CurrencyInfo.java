import java.util.HashMap;

public class CurrencyInfo implements Currency {

	public String name;
	public HashMap<CurrencyInfo, Double> children;

	public CurrencyInfo(String name) {
		this.name = name;
		children = new HashMap<CurrencyInfo, Double>();
	}

	@Override
	public void add(CurrencyInfo currency, Double rate) {
		// TODO Auto-generated method stub
	}

	@Override
	public void remove(CurrencyInfo currency) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(CurrencyInfo currency, Double rate) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.children.size();
	}

}
