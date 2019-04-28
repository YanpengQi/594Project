
public interface Currency {
	public void add(String currency, Double rate);
	
	public void remove(String currency);
	
	public void remove(String currency, Double rate);

	public int getSize();
}
