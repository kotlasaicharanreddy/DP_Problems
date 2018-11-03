import java.io.*;
import java.util.*;

class CoinExchange_Table{  //includes code 1 and code 2 of class notes
	public static void main(String args[]){
		int coins[]={1,7,10};
		int y=coins.length;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=n+1;
		int table[][]=new int[x][y];
		int min_num_coins=minCoins(table,coins,y,x);
		System.out.println("Minimum no of coins required:"+min_num_coins);
		System.out.print("Coins used are :: ");
		usedCoins(table,coins,y,x);
	}

	static int minCoins(int table[][],int coins[],int y,int x){
		
		for(int j=0;j<y;j++){
			table[0][j]=0; //paying amount 0 
		}
		for(int i=0;i<x;i++){
			table[i][0]=i; //paying i rs with 1re coins 
		}
		for(int j=1;j<y;j++){
			for(int i=1;i<x;i++){
				if(i>=coins[j] && table[i][j-1]>=(table[i-coins[j]][j]+1)){
					table[i][j]=table[i-coins[j]][j]+1;
				}
				else{ //(table[i][j-1]<(1+table[i-coins[j]][j])){
					table[i][j]=table[i][j-1];
				}
			}
		}
		//System.out.println(table[x-1][y-1]);
		return table[x-1][y-1];
	}
	static void usedCoins(int t[][],int coins[],int y,int x){
		int i=x-1,j=y-1;
		while(j>0){ //looping over j as we want to know which coins are used and base condition is j==0 as in coins[0]=1;;
					//base condition is different in class notes.
			if(t[i][j]==t[i][j-1]){
				j=j-1;
			}
			else{
				System.out.print(coins[j]+" ");
				i=i-coins[j];
			}
		}
		if(i>0){
			System.out.println("and "+ "[" +i+"]"+" 1 coins");
		}
	}
}