import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.richfaces.component.SortOrder;

/**
 * Class to control column order from table
 * 
 * 
 * @author DevCouty
 * 
 */
public class ColumnOrder implements Serializable {
	
	private static final long serialVersionUID = -2643599673886110434L;
	
	private Map<String, ColumnSorter> mapColumnOrder = new HashMap<String, ColumnSorter>();
	
	/**
	 * @param arrayColunas <br> Column names
	 * 
	 */
	public ColumnOrder(String... columns) {
		for(String coluna : columns) {
			mapColumnOrder.put(coluna, new ColumnSorter());
		}
	}
	
	/**
	 * Método que desordena a lista
	 * 
	 */
	public void unsortedAll() {
		for(ColumnSorter order : mapColumnOrder.values()) {
			order.unsort();
		}
	}
	
	public Map<String, ColumnSorter> getMapColumnOrder() {
		return mapColumnOrder;
	}
	
	/**
	 * Inner class to sort columns
	 * 
	 */
	public class ColumnSorter {
		
		/**
		 * Sort by this column
		 */
		public void sortBy() {
			if(sortOrder.equals(SortOrder.ascending)) {
				unsortedAll();
				sortOrder = SortOrder.descending;
			} else {
				unsortedAll();
				sortOrder = SortOrder.ascending;
			}
		}
		
		/**
		 * Unsort column
		 */
		public void unsort() {
			sortOrder = SortOrder.unsorted;
		}
		
		public SortOrder getSortOrder() {
			return sortOrder;
		}
		
		private SortOrder sortOrder = SortOrder.unsorted;
	}
	
}