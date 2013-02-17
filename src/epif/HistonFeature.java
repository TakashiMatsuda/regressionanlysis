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
public class HistonFeature implements Comparable<HistonFeature>{
	private static int CV = 5;
//	最初から全部読み込む必要がないのかもしれない。
	private Matrix code;
	
	/*
	 * result of crossvalidation 
	 */
	private double R;
	
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
	 *	rlsクロスバリデーション
	 * @return
	 */
	public double crossval(ExprList exprlist){
//		rlsを繰り返してcrossvalidateする。
//		CV回分割
		
		/*
		 * ExprListからdouble[]を生成。これは入力から考えると二度手間です。
		 */
		double[] elarray = new double[exprlist.size()];
		for(int i = 0; i < exprlist.size(); i++){
			elarray[i] = exprlist.get(i).get_exprs();
		}
		
		/*
		 * 各validateを行います。
		 */
//		FIXME まだcrosvalidateできていません。code, elarrayをcrossvalidationのために分割するコードを追加してください。
		double r = Math.pow(Math.E, 2.6);// 正規化数
		ArrayList<Matrix> coflist = new ArrayList<Matrix>(CV);// ここMatrixにしなきゃダメですね、修正して下さい。内積の計算が使いづらいので、修正する必要があります。
		ArrayList<double[]> crossEL = new ArrayList<>(CV);
		ArrayList<Matrix> crossCD = new ArrayList<>(CV);
		double sume = 0;
		for(int i = 0; i < CV; i++){
//			RLS
			coflist.add(RegularizedLeastSquareRA.rcoefficient(crossCD.get(i), crossEL.get(i), r));
			for(int j = 0; j < crossEL.get(i).length; j++){
//				Calculation for e
				sume += Math.pow(crossEL.get(i)[j] - coflist.get(i).inverse().times(null), 2.0);// ここに計算式をコードして下さい。まだ内積計算の部分が不完全です。
//				FIXME 内積計算の記述だけ
				
			}
			
		}
		
		double sumy = 0;
		for(int i = 0; i < elarray.length; i++){
			sumy += Math.pow(elarray[i] - exprlist.get_ave(), 2.0);
		}
		
		return (1 - (sume / sumy));// ここに最終計算式をコードして下さい。
		
	}

	@Override
	public int compareTo(HistonFeature o) {
		if (this.R > o.R){
			return 1;
		}
		else
			return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getR(){
		return R;
	}
	
	/**
	 * 
	 * @param r
	 */
	public void setR(double r){
		this.R = r;
	}
	
}
