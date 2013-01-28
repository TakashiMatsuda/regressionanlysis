/**
 * 
 */
package rls;

/**
 * @author takashi
 *
 */
public interface RegressionAnalysis {
	
	
	// 関数を返したいですね
//	できないので、一旦線形モデルの係数と定数を返し、それを受け取ってモデルを構成する関数を別に作ります。
	/**
	 * 
	 * @param independent
	 * @param dependent
	 * @return
	 */
	public double[] coefficientset(double[] independent, double[] dependent);
	
	/**
	 * 
	 * @param coefficient
	 * @return
	 */
	public double[] regressedmodel(double[] coefficient);

}
