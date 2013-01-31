/**
 * 
 */
package math;

/**
 * 
 * 行列に関するライブラリ
 * 車輪の再発明なのでやめました。LAPACKを使います。
 * 
 * @author takashi
 * 
 */
public class Matrix {

	/**
	 * xの逆行列を返します。
	 * 
	 * @param x
	 * @return
	 */
	public static double[][] invrs(double[][] x) {
		int N = x.length;
		int M = x[0].length;
		double[][] xi = new double[M][N];

		/*
		 * Choleski分解の掛け算として再帰的に計算する。
		 */

		return xi;

	}

	/**
	 * 行列の乗法。次元があってない場合、OutOfBoundsExceptionが発火します。
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double[][] multipl(double[][] x, double[][] y) {
		double[][] a = new double[x.length][y[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				for (int k = 0; k < x[0].length; k++) {
					a[i][j] += x[i][k] * y[k][j];
				}
			}
		}

		return a;
	}

	/**
	 * transpose matrix x.
	 * 
	 * @param x
	 * @return
	 */
	public static double[][] transpose(double[][] x) {
		double[][] xt = new double[x[0].length][x.length];
		for (int i = 0; i < x[0].length; i++) {
			for (int j = 0; j < x.length; j++) {
				xt[i][j] = x[j][i];
			}
		}

		return xt;
	}

}
