import static java.lang.System.*;

public class TrappingRainWater
{
	public static void main(String [] args)
	{
		out.println(solve2(new int[]{3,2,5}));
	}
	
	// O(n^2) solution
	static int solve2(int A[])
	{
		int n = A.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        
        for(int i=1; i<n-1;i++)
        {
            for(int j=0; j<i; j++)
                l = Math.max(l, A[j]);
            
            r = A[i];
            
            for(int j=i+1; j<n; j++)
                r = Math.max(r, A[j]);
            
            if(Math.min(l,r)-A[i] > 0)
                sum += Math.min(l,r) - A[i]; 
        }
        
        return sum;
	}
	
	
	
	// O(n) solution 
	static int solve(int A[])
	{
		int n = A.length;
        int sum = 0;
        
		if(n==0)
			return 0;
		
        int l[] = new int[n];
        int r[] = new int[n];
        
        int max = A[0];
        
		for(int i=1; i<n; i++)
        {
            if(max < A[i])
            {
                l[i] = max;
                max = A[i];
            }
			else
				l[i] = max;
        }
        
        max = A[n-1];
		
        for(int i=n-2; i>=0; i--)
        {
            if(max < A[i])
            {
                r[i] = max;
                max = A[i];
            }
			else
				r[i] = max;
        }
        
        
        for(int i=0; i<n ; i++)
        {
           int min = Math.min(l[i], r[i]);
           if(min - A[i] > 0)
               sum += min - A[i];
        }
		
        return sum;
	}
}