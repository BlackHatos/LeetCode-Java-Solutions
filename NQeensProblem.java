import static java.lang.System.*;
import java.util.*;

public class NQeensProblem
{
	static void printSolution(int board[][], int n)
	{
		for(int i=0;i<n; i++)
		{
			for(int j=0;j<n; j++)
				out.print(" "+board[i][j]+"  ");
			out.println("\n");
		}
		
		out.println("\n------------------------");
	}
	
	static boolean isSafe(int board[][], int row, int col, int n)
	{
		// check left side in the row
		for(int i=0; i<col; i++)
			if(board[row][i] == 1)
				return false;
		
		// check upper diagonal
		for(int i=row, j=col; i>=0 && j>=0 ; i--,j--)
			if(board[i][j] == 1)
				return false;
		
       // lower diagonal

       for(int i=row, j=col; i<n && j>=0; i++,j--)	
		if(board[i][j] == 1)
			return false;
		
	   return true;		
	}
	
	static boolean placeTheQueen(int board[][], int col, int n)
	{
		boolean res = false; 
		
		if(col==n)
		{
			printSolution(board, n);
			return true;
		}
						
		for(int i=0; i<n; i++)
		{
			if(isSafe(board,i,col,n))
			{
				board[i][col] = 1;
				res = placeTheQueen(board,col+1,n);
				board[i][col] = 0;
			}
		}
		return res;
	}
	
	public static void main(String [] args)
	{
	   Scanner sc = new Scanner(in);
	   int n = sc.nextInt();	
	   int board[][] = new int [n][n];
		
       boolean status = placeTheQueen(board,0,n);	
       out.print(status);	   
	}
}