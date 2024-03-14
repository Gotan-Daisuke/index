package main;



public class Main {

	public static void main(String[] args) {
		//変数定義
		String[] x = new String[3];
		x[0] = "hoge";
		x[1] = "huga";
		
		//繰り返し処理
		for(String i:x) {
			
			//nullチェック
			if(i == null) {
				System.out.println("値がありません");
				continue;
			}
			
			//入力値チェック
			System.out.println(i);
		}
	}
}
