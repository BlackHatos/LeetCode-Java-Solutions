// SLIDING WINDOW PROBLEM
// BEST PROBLEM

import static java.lang.System.*;
import java.util.*;

public class FindAllAnagrams 
{
	public static void main(String [] args)
	{
		String s = "cbaebabacd";
		String p = "abc";
		System.out.println(findAnagrams(s, p));
	}
	
// O(n^2) solution
	
	static List<Integer> findAnagrams(String s, String p)
	{
		int m = s.length();
		int n = p.length();
		
		List<Integer> list = new ArrayList<>();
		
		int sCount[] = new int[256];
		int pCount[] = new int[256];
		
		for(int i=0;i<n; i++)
		{
			sCount[s.charAt(i)]++;
			pCount[p.charAt(i)]++;
		}
		
		for(int i=n; i<m; i++)
		{
			if(compare(sCount, pCount))
				list.add(i-n);
			
			sCount[s.charAt(i)]++;
			
			sCount[s.charAt(i-n)]--;
		}
		
		if(compare(sCount, pCount))
			list.add(m-n);
		
		return list;
	}
	
	static boolean compare(int A[], int B[])
	{
		for(int i=0; i<256; i++)
		{
			if(A[i] != B[i])
				return false;
		}
		return true;
	}
}