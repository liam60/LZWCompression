import java.io.*;
import java.util.*;

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
	    	
	   		  		

		}
	    catch(Exception e)
	    {
	    	System.err.println(e.getMessage());
	    }	
	}
}
