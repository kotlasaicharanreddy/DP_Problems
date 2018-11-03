import java.io.*;
import java.util.*;

class CoinExchange_TotalNoOfWays{ //includes code 5 of class notes
	public static void main(String args[]){
		int coins[]={1,7,10};
		int y=coins.length;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=n+1;
		int t[]=new int[x];
		int total_ways=totalNoOfWays(t,coins,x,y);
		System.out.println("Total no of ways to pay:"+total_ways);
	}

	static int totalNoOfWays(int t[],int coins[],int x,int y){
		t[0]=1;
		for(int i=1;i<x;i++){
			t[i]=1;
		}
		for(int j=1;j<y;j++){
			for(int i=2;i<x;i++){
				t[i]=t[i]+(i>=coins[j]?t[i-coins[j]]:0);
			}
		}
		return t[x-1];

	}



}