import static java.lang.System.*;
import java.util.*;

public class GroupAnagram 
{
    public static void main(String args[])
	{
		List<List<String>> list = solve
		(new String[]{"eat","tea","tan","ate","nat","bat"});
		
		for(int i=0;i<list.size();i++)
			out.println(list.get(i));
	}
	
	
	
	
	
	// O(n^2) Solution
	
	static List<List<String>> solve(String str[])
	{
		List<List<String>> list = new ArrayList<List<String>>();
	    int n = str.length;
	    String strx[] = new String[n];
		System.arraycopy(str,0,strx,0,n); 
		
		for(int i=0;i<n; i++)
		{
			char ch[] = strx[i].toCharArray();
			Arrays.sort(ch);
			strx[i] = String.valueOf(ch);
		}
		
		for(int i=0;i<n; i++)
		{
		   List<String> tempList = new ArrayList<>();
		   boolean check = false;
		   if(!str[i].equals("0"))	
		   {
			   tempList.add(str[i]);
			   check = true;
			   str[i] = "0";
		   }
		   else 
			   continue;
		   
		   String  temp = strx[i];
		   
		   for(int j=i+1; j<n; j++)
		   {
			  if(temp.equals(strx[j])) 
				{
				  tempList.add(str[j]);
				  str[j] = "0";
				}
		   }
		   
		   if(check)
			   list.add(tempList);
		}
		
		return list;
	}
	
	// O(n^3) solution

    static List<List<String>> groupAnagarm(String str[]) 
	{
	  List<List<String>> list = new ArrayList<List<String>>();
		
      for(int i=0; i<str.length; i++)
	  {
		  String str1 = str[i];
		  List<String> tempList = new ArrayList<>();
		  boolean check = false;
		  
          if(!str1.equals("0"))
		  {
			 tempList.add(str1);
			 check = true;
			 str[i] = "0";
		  }
			
		  for(int j=0; j<str.length && !str1.equals("0"); j++)
		  {
			  String str2 =  str[j];
			  boolean flag = false;
			  
			  if(str1.length() == str2.length())
				 flag = isOk(str1, str2);
			  else
				  continue;
			  
			  if(flag)
			  {
				tempList.add(str2); 
				str[j] = "0";
			  } 
		  }
	
	    if(check)
          list.add(tempList);
	  }
	  return list;
	}
	
	static boolean isOk(String str1, String str2)
	{
		 char c1[] = str1.toCharArray();
		 char c2[] = str2.toCharArray();
        
         Arrays.sort(c1);
         Arrays.sort(c2);
		 
         int n = c1.length;
		
          for(int i=0;i<n; i++)
          {
              if(c1[i] != c2[i])
                  return false;
          }
          return true;
	}
}