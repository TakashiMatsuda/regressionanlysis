/**
 * 
 */
package expr;

import java.io.BufferedReader;
import java.io.FileReader;
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
	
	
	public static ExprList load_ExprList(String filename){
//		ArrayList<Double> res = new ArrayList<Double>(112994);
		ExprList res2 = new ExprList(112994);
		try{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			double exprs = 0;
			double prev = 0;
			while((line = br.readLine()) != null){
				/*
				 * 新しい発現量を読み込み、resに追加して返す。
				 */
				exprs = Double.parseDouble(line.split(" ")[1]);
				prev += exprs;
				res2.add(new Expr(exprs));
				
//				res.add(Double.parseDouble(line.split(" ")[1]));
			}
			br.close();
			res2.ave = prev / (double) res2.size();
		} catch(Exception e){
			e.printStackTrace();
		}
//		return res;
		
		return res2;
		
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
