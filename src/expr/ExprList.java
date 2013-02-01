/**
 * 
 */
package expr;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author takashi
 *	
 */
public class ExprList extends ArrayList<Expr> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4317329866121071730L;

	/**
	 * 
	 */
	public ExprList() {
	}

	/**
	 * @param initialCapacity
	 */
	public ExprList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param c
	 */
	public ExprList(Collection<Expr> c) {
		super(c);
	}
	
}
