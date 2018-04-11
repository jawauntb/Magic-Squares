import java.util.*;
//this is a program to make a magic square

public class MagicSquare {
    
    public static void main(String[] args){
	int[][]square = magicSquare(3);
	printMagic(square);
	
    }



    static boolean squareIsEmpty(int [][] magic, int row, int col){
	if(magic[row][col] == 0){
	    return true;
	}
	else{return false;}
	
    }
    

    static int fixBound(int [][] magic, int rowCol){
	int upBound = magic.length-1;
	int lowBound = 0;
	if(rowCol > upBound){
	    rowCol = lowBound;
	}
	else if(rowCol < lowBound){
	    rowCol = upBound;
	}
	else{ 
	rowCol = rowCol; 
	}
	return rowCol;
    }


    static int rowDown(int [][] magic, int row, int col){
	while(squareIsEmpty(magic, row, col) == false){
	    row += 1;
	    int r = fixBound(magic, row);
	    row = r;
	}
	    return row;
    }

    static int ifLastWasUpperRightBound(int[][] magic, int i, int row, int col){
	int upBound = 0;
	int rightBound = (magic.length - 1);
	int lastVal = (i-1);
	if(magic[upBound][rightBound] == lastVal){
	    magic[(upBound+1)][rightBound] = i;
	    row = (upBound+1);
	}
	return row;
    }


    static int[][] magicSquare(int n){

	Scanner keyboard = new Scanner(System.in);
	
	if(n % 2 == 0 || n < 3 ){ 
	    System.out.println("please enter an odd number greater than 3");
	    n = keyboard.nextInt();
	}    //needs to be odd and greater than 3

	int [][] magic = new int [n][n]; //new matrix of dimensions n*n	
	int row = 0; // tracks rows (there are n rows, from 0-(n-1)
	int col = (n/2); //there are n columns, or n values per row
	int maglength = n-1;
	magic [row][col] = 1;
	magic [2][2] = 2;
	for(int i = 3; i  <= (n*n); i++){   /* start at row 0, middle column constantly increase value */
	    ifLastWasUpperRightBound(magic, i, row, col);  //if last was the upper right bound then place i below and return row 
	    System.out.println(row + " " + col + "  before fixBound " );

	    int newRow = fixBound(magic, (row-1));             //try out a new column
	    int newCol = fixBound(magic, (col+1));             //try out a new row
	    

	    System.out.println("    these are the new values" + newRow + "r|c " + newCol);
	    if(squareIsEmpty(magic, newRow, newCol) == false){
		row = fixBound(magic, (rowDown(magic, row, col)));

	    }

	    if(squareIsEmpty(magic, newRow, newCol) == true){      //if there is space in this position
		row = newRow;                              //the row is now the newRow
		col = newCol;                              //col is the newCol
	    }
	   
   	   
	    magic[row][col] = i;     //nxt value at any position in the square will be up 1 and right 1	  

	    
	}
       
	return magic;

    }
    
    static void printMagic(int [][] magic){
	System.out.println();
	for(int i=0; i<magic.length; i++){
	    for(int j=0; j<magic[i].length; j++){
		System.out.print(magic[i][j] + " ");
	    }
		    System.out.println();
 
	}
    }










}

