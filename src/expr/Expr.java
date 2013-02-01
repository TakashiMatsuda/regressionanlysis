/**
 * 
 */
package expr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author takashi
 *
 */
public class Expr {
	private int expr_id;
	private int tss_id;
	private double exprs;
	private List<double[]> histnf;
	
	
	/**
	 * histnfへの格納はあらゆる操作に対して保証されます。
	 * @param expr_id
	 * @param tss_id
	 * @param exprs
	 * @param histnf
	 */
	public Expr(int expr_id, int tss_id, double exprs, List<double[]> histnf){
		this.expr_id = expr_id;
		this.tss_id = tss_id;
		this.exprs = exprs;
		this.histnf = new ArrayList<double[]>(histnf);
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_exprid(){
		return expr_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int get_tssid(){
		return tss_id;
	}
	
	/**
	 * 
	 * @return
	 */
	public double get_exprs(){
		return exprs;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public double[] get_histnf(int n){
		return histnf.get(n);
	}
	
	
	
}
