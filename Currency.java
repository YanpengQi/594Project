
public interface Currency {
	public void add(CurrencyInfo currency, Double rate);
	
	public void remove(CurrencyInfo currency);
	
	public void remove(CurrencyInfo currency, Double rate);

	public int getSize();
}
