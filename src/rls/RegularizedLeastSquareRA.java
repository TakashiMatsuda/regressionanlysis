/**
 * 
 */
package rls;

import Jama.Matrix;
import Jama.CholeskyDecomposition;

/**
 * 
 * 最小二乗法による線形回帰の実装
 * @author takashi
 * 
 */
public class RegularizedLeastSquareRA {

	/**
	 * 単回帰分析の実装。これができたら重解析分析のコードも書く。
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
	
//	FIXME 引数仕様の変更をしたので、ここを修正してください。
	/**
	 * 
	 * @param independent
	 * @param dependent
	 * @param reg
	 * @return
	 */
	public static double[][] rcoefficient(Matrix independent, double[] dependent, double reg){
		int M = independent[0].length;
		int N = independent.length;
		Matrix w = new Matrix(N, M);
		Matrix x = new Matrix(independent);
		Matrix y = new Matrix(dependent);
		
		w = x.transpose().times(x).plus(Matrix.identity(M, M).times(reg));
		w = w.inverse().times(x).times(y);
		
		return w.getArray();
	}

	/**
	 * 
	 * @param coefficient
	 * @return
	 */
//	public static double[] regressedmodel(double[] coefficient) {
//
//		return null;
//	}

}
