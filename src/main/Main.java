
/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Jama.Matrix;

import expr.*;
import epif.*;
import rls.*;

/**
 * @author takashi
 *
 */
public class Main {
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("System starting");
		
//		わからなくなったら慣れているsingletonパターンで実装しよう。
//		デザインパターンの勉強は徐々にやっていきたいな。
//		今は愚直に作る。static周りの問題がおかしかったら
		
//		全体の設計を考えよう
		// readする　rna_seq_k562をする
		ExprList exprlist = new ExprList(readRnaExprs("rna_seq_k562.txt"));
		
//		HistonFeatureList histonlist = new HistonFeatureList(readHistonCode(""));
		// 主目標：histoncodeを独立変数、発現量を従属変数として回帰分析する。
//		HistonListは、Matrix実装に切り替える。
//		HistonListは、必ずしもすべての修飾量データを保持する必要がない。
//		HistonListに読む必要はなく、12個のデータについてそれぞれ一旦呼んで戻す。
//		上位の列のみを保持すればよい。
		
//		上の機能はすべてhistonlistに所属するデータ操作であるから、
//		HistonListに入れるのが良いと思います。
//		つまり下のコード。
		
		
//		exprlistとhistonlistのバインディングクラスが必要となってくる。
		HistonFeatureList histontopslist = HistonFeatureList.rankTopHiston(exprlist);
		
		
//		exprとhistonを結びつけるクラスを書いて、そこでこれら回帰などの操作を行うことに決めました。
		
//		相関係数をどう求めるか。
//		5分割して回帰を5回行い、残差を合計して相関係数を決める。
		
		
		
		
		

	}
	
	/**
	 * 
	 * @param filename
	 * @return
	 */
	private static ArrayList<Double> readRnaExprs(String filename){
		ArrayList<Double> res = new ArrayList<Double>(112994);
		try{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			double exprs = 0;
			while((line = br.readLine()) != null){
				/*
				 * 新しい発現量を読み込み、resに追加して返す。
				 */
				res.add(Double.parseDouble(line.split(" ")[1]));
			}
			br.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return res;
		
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