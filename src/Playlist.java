import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.css.Rule;

public class Playlist {
	// Need to support add, remove, and get random element.
		// Preferably all at constant time.
		
		private HashMap<Rule, Integer> ruleMap;
		private List<Rule> indexTable;
		
		public Playlist() {
			ruleMap = new HashMap<>();
			indexTable = new ArrayList<>();
		}
		
		public void add(Rule r) {
			ruleMap.put(r, indexTable.size());
			indexTable.add(r);
		}
		
		public void remove(Rule r) {
			if (!ruleMap.containsKey(r)) return;
			int temp = ruleMap.get(r);
			int last = indexTable.size() - 1;
			Rule lastR = indexTable.get(last);
			// Swap last element with element to be removed, remove the new last element.
			indexTable.set(temp, lastR);
			indexTable.set(last, r);
			indexTable.remove(last);
			// Do the same for the hash table
			ruleMap.put(lastR, temp);
			ruleMap.remove(r);
		}
		
		public Rule getRandom() {
			int random = (int)(Math.random() * indexTable.size());
			return indexTable.get(random);
		}
}
