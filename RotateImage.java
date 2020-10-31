import static java.lang.System.*;

public class RotateImage
{
	public void rotateImage(int A[][])
	{
		int n = A.length;
		
		for(int i=0;i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				int temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}
		
	  for(int i=0;i<n ; i++)
	  {
		  int l = 0;
		  int r = n-1;
		  
		  while(l<r)
		  {
			  int temp = A[i][l];
			  A[i][l] = A[i][r];
			  A[i][r] = temp;
			  l++;
			  r--;
		  }
	  }		  
	   
	}
	
	public static void main(String [] args)
	{
		int A[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
	    new RotateImage().rotateImage(A);
		for(int i=0; i<A.length; i++)
		{
			for(int j=0;j<A.length; j++)
			{
				out.print(A[i][j]+" ");
			}
			out.println();
		}
	}
}