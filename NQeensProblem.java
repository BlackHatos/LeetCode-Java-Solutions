import static java.lang.System.*;
import java.util.*;

public class NQueenProblem 
{
	static List<char[]> mList;
	static List<List<String>> list = new ArrayList<List<String>>();
	
	public static void main(String [] args)
	{       
	    int n = 4;
		mList  = new ArrayList<>();
		
		for(int i=0;i<n; i++)
        {
           char ch[] = new char[n];
           Arrays.fill(ch, '.');
           mList.add(ch); 
        }    
        
		placeTheQueen(0,n);
		printList(n);
	}
	
	static boolean placeTheQueen(int col, int n)
	{
		if(col==n)
		{
			List<String> temp = new ArrayList<>();
			for(int i=0;i<n; i++)
				temp.add(String.valueOf(mList.get(i)));
			list.add(temp);
			return true;
		}
			
		boolean res = false;
		
		for(int i=0; i<n; i++)
		{
			if(isSafe(i,col,n))
			{
				mList.get(i)[col] = 'Q';
		        res = placeTheQueen(col+1,n) || res;
				mList.get(i)[col] = '.';
			}
		}
		return res;
 	}
	
	static boolean isSafe(int row, int col, int n)
	{
		// check left side in the row
		for(int i=0; i<col; i++)
			if(mList.get(row)[i] == 'Q')
				return false;
		
		// check upper diagonal
		for(int i=row, j=col; i>=0 && j>=0 ; i--,j--)
			if(mList.get(i)[j] == 'Q')
				return false;
		
       // lower diagonal
       for(int i=row, j=col; i<n && j>=0; i++,j--)	
		if(mList.get(i)[j] == 'Q')
			return false;
		
	   return true;		
	}
	
	static void printList(int n)
	{
		for(int i=0; i<list.size(); i++)
		{
		    for(String x: list.get(i))
			{
				out.println(x);
			}
			out.println("\n");
		}
	}
 }
