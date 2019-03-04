
//Your code. A class called APSpec1.java should include the main demonstrating the
//functionality required for spec 1. 
import java.util.Scanner;
	import java.lang.*;

public class APSpec1 {
	
	 public static void printRow(int[] row) {
	        for (int i : row) {
	            System.out.print(i);
	            System.out.print("|");
	        }
	        System.out.println();
	    }
	 
	 public static void printColumn(int[] column) {
	        for (int k : column) {
	            System.out.print(k);
	            System.out.print("_");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        int traffic[][]= new int[10][20];
	        int i,j; 

	        for(i=0;i<10;i++) {
	            for(j=0;j<20;j++) {
	                //traffic[i][j];
	            }
	        }

	        for(int[] row : traffic) {
	            printRow(row);
	        }
	    }
	}



