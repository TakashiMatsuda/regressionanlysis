/**
 * 
 */
package epif;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Jama.Matrix;

/**
 * @author tks
 *	ArrayListで実装しています。必要に応じてLinkedListに変えて下さい。
 */
public class HistonFeatureList extends ArrayList<HistonFeature> {
//	double[] decoptn;
	private ArrayList<Double> decoptn;// ちょっとよくわからない
	/**
	 * 
	 */
	private static final long serialVersionUID = 7829708898401105757L;

	/**
	 * 
	 */
	public HistonFeatureList() {
	}

	/**
	 * @param initialCapacity
	 */
	public HistonFeatureList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param c
	 */
	public HistonFeatureList(Collection<HistonFeature> c) {
		super(c);
	}
	
	
	
	/**
	 * まだ実装していません。
	 * @return
	 */
	public ArrayList<HistonFeature> sort(){
		return null;
	}
	
	
	/**
	 * これはHistonListの上位3つをピックアップする関数。メインです。これの中にはヒストンコードファイルからの読み込みが含まれます。Mainから呼び出される唯一の手続きです。
	 * @return
	 */
	public static HistonFeatureList rankTopHiston(){
//		ヒストンコードの名前は具体的に依存する。
//		各ファイル名を記入してください。
		
//		フォルダ内のすべてのファイルを網羅する機能がないか調べてください。
		
		
//		ループのなかで次のことを行う。{
		
		Matrix histon = readHistonCode("");
//		ヒストンコードと遺伝子発現量の相関の評価。クロスバリデーション。rls.
		histon.crossval();
		
		
		
		
		return null;
	}
	
	
	
	/**
	 * 一つのヒストンについてそのヒストンコードを入力する関数。HistonFeatureListの中に移動しました。
	 * String -> Matrix
	 * @param filename
	 * @return
	 */
	private static Matrix readHistonCode(String filename){
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
		
		Matrix res = new Matrix(prres);
		return res;
	}
	
	
	
	
	
	
}
