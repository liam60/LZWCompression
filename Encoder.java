import java.io.*;
import java.util.*;
import java.net.*;

public class Encoder
{
	public static void main(String [] args)
	{
		if(args.length != 1)
		{
	      	System.err.println("Usage:  java MakeRuns <integer-k>");
	      	return;
    	}
	    try
		{
	    	int k = Integer.parseInt(args[0]);
			System.out.println(k);
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			byte[] textByte;
			String s;						
 
			while(true)
			{
				s = reader.readLine();
				if ("RESET".equals(s)) 
				{
            		System.out.println("Exit!");
                	System.exit(0);
            	}
				textByte = s.getBytes();
                String str = new String(textByte);
				System.out.println(str);
			}
		}
	    catch(Exception e)
	    {
	    	System.err.println(e.getMessage());
	    }	
	}
}

public class Trie
{
    





    


}
