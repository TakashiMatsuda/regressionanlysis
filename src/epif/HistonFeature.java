/**
 * 
 */
package epif;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import expr.ExprList;
import Jama.Matrix;
import rls.RegularizedLeastSquareRA;

/**
 * @author takashi
 *	ヒストン修飾のモデルです。
 */
public class HistonFeature {
	private static int CV = 5;
//	最初から全部読み込む必要がないのかもしれない。
	private Matrix code;
	
	
	/**
	 * 
	 * @param mat
	 */
	private HistonFeature(Matrix mat){
		this.code = mat;
	}
	
	/**
	 * staticファクトリーメソッド
	 * @param filename
	 * @return
	 */
	public static HistonFeature make(String filename){
		double[][] prres = new double[112994][40];
		try{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String[] elements = new String[40];
			int count = 0;
			while((line = br.readLine()) != null){
				/*
				 * 新しいヒストンコードを読み込み、resに追加して返す。
				 */
				elements = line.split(" ")[1].split(",");
				for(int j = 0; j < 40; j++){
					prres[count][j] = Double.parseDouble(elements[j]);
				}
				count++;
			}
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Matrix mat = new Matrix(prres);
	
//		これより下、staticファクトリーメソッドの作り方がわからない。
//		この中でコンストラクタを呼び出してしまっていいのだろうか。
		HistonFeature res = new HistonFeature(mat); 
		
		return res;
	}
	
	/**
	 * Histonひとつに対する解析の主人コード
	 */
	public static void run(String filename){
		HistonFeature histon = make(filename);
		
//		ここから、RLSを行う
		
	}
	
	/**
	 *	これを作ってください。
	 * @return
	 */
	public double crossval(ExprList exprlist){
//		rlsを繰り返してcrossvalidateする。
//		CV回分割
		
//		exprlistからdouble[]への型の変更が必要。
//		ExprList -> double[]
		double[] elarray = new double[exprlist.size()];
		for(int i = 0; i < exprlist.size(); i++){
			elarray[i] = exprlist.get(i).get_exprs();
		}
		
		double r = Math.pow(Math.E, 2.6);// 正規化数
		ArrayList<double[][]> coflist = new ArrayList<double[][]>(CV);
		for(int i = 0; i < CV; i++){
			coflist.add(RegularizedLeastSquareRA.rcoefficient(code, elarray, r));
		}	
		
	}
	
}
