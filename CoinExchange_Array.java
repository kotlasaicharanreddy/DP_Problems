import java.io.*;
import java.util.*;

class CoinExchange_Array{ //includes code 3 and code 4 of class notes
	public static void main(String args[]){
		int coins[]={1,7,10};
		int y=coins.length;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=n+1;
		int t[]=new int[x];
		int min_num_coins=minCoins(t,coins,x,y);
		System.out.println("Minimum no of coins required:"+min_num_coins);
		System.out.print("Coins used are :: ");
		usedCoins(t,coins,x,y);
	}

	static int minCoins(int t[],int coins[],int x,int y){
		t[0]=0;
		for(int i=1;i<x;i++){
			t[i]=i;
		}
		for(int j=1;j<y;j++){
			for(int i=2;i<x;i++){
				if(i>=coins[j] && t[i]>=t[i-coins[j]]+1)
					t[i]=t[i-coins[j]]+1;
			}
		}

		return t[x-1];
	}


	static void usedCoins(int t[],int coins[],int x,int y){
		int i=x-1,j=y-1;
		while(j>0){
			if(i>=coins[j] && t[i]==1+t[i-coins[j]]){
				System.out.print(coins[j]+" ");
				i=i-coins[j];
			}
			else{
				j=j-1;
			}
		}
		if(i>0){
			System.out.println("[" +i+"]"+" 1 coins");
		}
	
	}
}