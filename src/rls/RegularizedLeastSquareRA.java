/**
 * 
 */
package rls;

import Jama.Matrix;
import Jama.CholeskyDecomposition;

/**
 * @author takashi
 * 
 */
public class RegularizedLeastSquareRA {

	/**
	 * 単回帰分析に実装。これができたら重解析分析のコードも書く。
	 * 
	 * @param independent
	 * @param dependent
	 * @param regparameter
	 * @return
	 */
	public static double[] coefficientset(double independent[],
			double dependent[], double regparameter) {
		double[] w = new double[2];// xの次元数 + 1
		System.err.println("not implemented");
		return w;
	}

	/**
	 * 
	 * 
	 * 
	 * implements　Least Square regression. regparameter is
	 * recommended to be "ln(r) = 2.6" independent(input) dependent(target)
	 * 
	 * @param independent
	 * @param dependent
	 * @return
	 */
	public static double[][] coefficientset(double[][] independent,
			double[][] dependent) {
//		double[] w = new double[independent.length + 1];// xの次元 + 1, (基底の数)
		
		int M = independent[0].length + 1;
		int N = independent.length;
		Matrix w = new Matrix(N, M);
		
		/*
		 * 行列計算をする。
		 */

		// double[][] dtd = new double[M][M];
		// for(int i = 0; i < M; i++){
		// for(int j = 0; j < N; j++){
		//
		// /*
		// * 各項の計算
		// */
		// for(int k = 0; k < N; k++){
		// dtd[i][j] += independent[k][i] * independent[k][j];
		// }
		//
		// }
		// dtd[i][i] += regparameter;
		// }

		Matrix x = new Matrix(independent);
		Matrix y = new Matrix(dependent);
		
		w = x.inverse().times(y);

		return w.getArray();// 重回帰分析・非正規化線形回帰の結果
	}
	
//	FIXME 正規化線形回帰も実装してください。
	
	

	/**
	 * 
	 * @param coefficient
	 * @return
	 */
	public static double[] regressedmodel(double[] coefficient) {

		return null;
	}

}
