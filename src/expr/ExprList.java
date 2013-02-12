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
	 * @param exprary
	 */
	public ExprList(ArrayList<Double> exprary) {
		super(exprary.size());// superの仕様を読みたい。できればもっとうまく一発superで済ましてしまいたい
		for(int i = 0; i < exprary.size(); i++){
			Expr addi = new Expr(exprary.get(i));
			this.add(addi);
		}
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
