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
	
	private double ave;

	/**
	 * 
	 * @param exprary
	 */
	public ExprList(ArrayList<Double> exprary) {
		super(exprary.size());// superの仕様を読みたい。できればもっとうまく一発superで済ましてしまいたい
		
		double prev = 0;
		for(int i = 0; i < exprary.size(); i++){
			Expr addi = new Expr(exprary.get(i));
			prev += exprary.get(i);
			this.add(addi);
		}
		
		this.ave = prev / (double)exprary.size();
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
	
	/**
	 * 
	 * @return
	 */
	public double get_ave(){
		return ave;
	}
	
}
