
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
		// 主目標：histoncodeを独立変数、発現量を従属変数として回帰分析する。
//		HistonListは、Matrix実装に切り替える。
		
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
			String[] elements = new String[2];
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
	 * 
	 * @param filename
	 * @return
	 */
	private static Matrix readHistnCode(String filename){
		Matrix res = new Matrix();// サイズを決めなければいけない。
		try{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String elements = new String[4];// 一行の要素数を数えてここに入力してください。
			while((line = br.readLine()) != null){
				/*
				 * 新しいヒストンコードを読み込み、resに追加して返す。
				 */
				
			}
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

}