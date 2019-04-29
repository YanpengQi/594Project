import java.util.ArrayList;
import java.util.HashSet;
/**
 * This class finds profit cycle
 * @author Yanpeng Qi, Scarlett Yu, Yilin Sun 
 *
 */
public class FindCycleProfit implements FindProfitCycle{

	public ArrayList<ArrayList<CurrencyInfo>> paths;
	/**
	 * constructor for FindCycleProfit
	 */
	public FindCycleProfit() {
		paths = new ArrayList<ArrayList<CurrencyInfo>>();
	}
	/**
	 * this method implements DFS to find potentially profitable exchange cycle 
	 */
	public ArrayList<ArrayList<CurrencyInfo>> findCycle(int currencyNum, CurrencyInfo[] info, CurrencyInfo src) {

		ArrayList<CurrencyInfo> path = new ArrayList<CurrencyInfo>();
		HashSet<CurrencyInfo> set = new HashSet<CurrencyInfo>();
		path.add(src);
		set.add(src);
		double max = 0.0;
		helper(src, src, currencyNum, 0, path, set, 1.0, max);
		return paths;
	}
	
	private void helper(CurrencyInfo src, CurrencyInfo cur, int currencyNum, int i, ArrayList<CurrencyInfo> path, HashSet<CurrencyInfo> set, double amount, double max) {
		if (i == currencyNum) {
			if (cur == src) {
				if (amount > max) {
					max = amount;
					paths.add(0, path);
				}
			}
			return;
		}
		
		for (CurrencyInfo next: cur.children.keySet()) {
			if (set.contains(next)) {
				continue;
			}
			path.add(next);
			set.add(next);
			helper(src, next, currencyNum, i + 1, path, set, amount * cur.children.get(next), max);
			path.remove(path.size() - 1);
			set.remove(next);
		}
	}
}
