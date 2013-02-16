/**
 * 
 */
package epif;

import java.io.BufferedReader;
import java.io.FileReader;
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
	public double crossval(){
//		rlsを繰り返してcrossvalidateする。
//		CV回分割
		for(int i = 0; i < CV; i++){
			RegularizedLeastSquareRA.rcoefficient(independent, dependent, reg);// 引数を
		}
	}
	
	
	
}
