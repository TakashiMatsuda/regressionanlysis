/**
 * 
 */
package rls;

/**
 * @author takashi
 *
 */
public class RegularizedLeastSquareRA{
	/**
	 * 
	 * implements Regularized Least Square regression.
	 * regparameter is recommended to be "ln(r) = 2.6"
	 * independent(input)
	 * dependent(target)
	 * 
	 * @param independent
	 * @param dependent
	 * @param regparameter
	 * @return
	 */
	public static double[] coefficientset(double[][] independent, double[] dependent, double regparameter) {
		double[] w = new double[independent.length];
		int M = independent[0].length;
		int N = independent.length;
		
		/*
		 * 行列計算をする。
		 */
		
//		FIXME LAPACKを使った形に切り替えて下さい。
//		double[][] dtd = new double[M][M];
//		for(int i = 0; i < M; i++){
//			for(int j = 0; j < N; j++){
//				
//				/*
//				 * 各項の計算
//				 */
//				for(int k = 0; k < N; k++){
//					dtd[i][j] += independent[k][i] * independent[k][j];
//				}
//				
//			}
//			dtd[i][i] += regparameter;
//		}
		
		/*
		 * 逆行列の計算
		 */
		
		return w;
	}

	/**
	 * 
	 * @param coefficient
	 * @return
	 */
	public static double[] regressedmodel(double[] coefficient) {
		
		return null;
	}

}
