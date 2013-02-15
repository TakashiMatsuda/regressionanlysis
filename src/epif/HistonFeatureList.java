/**
 * 
 */
package epif;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author tks
 *	ArrayListで実装しています。必要に応じてLinkedListに変えて下さい。
 */
public class HistonFeatureList extends ArrayList<HistonFeature> {
//	double[] decoptn;
	private ArrayList<Double> decoptn;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7829708898401105757L;

	/**
	 * 
	 */
	public HistonFeatureList() {
	}

	/**
	 * @param initialCapacity
	 */
	public HistonFeatureList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param c
	 */
	public HistonFeatureList(Collection<HistonFeature> c) {
		super(c);
	}
	
	
	
	/**
	 * まだ実装していません。
	 * @return
	 */
	public ArrayList<HistonFeature> sort(){
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
