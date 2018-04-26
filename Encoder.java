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
			Trie dict = new Trie();					

			while(true)
			{
				s = reader.readLine();
				if ("RESET".equals(s)) 
				{
            		System.out.println("Exiting");
                	break;
            	}

				textByte = s.getBytes();
				int i = 0;
				while(dict.current == true)
				{
					System.out.println(textByte[i]);
					i++;
				}
				System.out.println(dict.add(textByte[i]) + "  " + textByte[i]);
			}
		}
	    catch(Exception e)
	    {
	    	System.err.println(e.getMessage());
	    }	
	}
}

class Trie
{
	Node _root;
	Node _curr;
	int _nextPhraseNum;

	public Trie()
	{
		nextPhraseNum = 1;
		root = new Node(null, 0);
	}

	public int add(byte b)
	{
		_curr.addChild(new Node(b, _nextPhraseNum));
		_nextPhraseNum++;
		int code = _curr.PhraseNum();
		_curr = _root;
		return code;
	}

	public boolean find(byte b)
	{
		if(_curr.hasChild(b))
		{
			_curr = _curr.getChild(b);
			return true;
		}
		return false;
	}

	class Node
	{
		byte _contents;
		int _phrase;
		ArrayList<Node> _children;

		public Node(byte b, int p)
		{
			_contents = b;
			_phrase = p;
			_children = new ArrayList<Node>();
		}

		public void addChild(Node n)
		{
			_children.add(n);
		}

		public Node getChild(byte b)
		{
			for(int i = 0; i < _children.count(); i++)
			{
				if(b == _children[i].getContents()) { return _children[i]; }
			}
			return null;
		}

		public boolean hasChild(byte b)
		{
			for(int i = 0; i < _children.count(); i++)
			{
				if(b == _children[i].getContents()) { return true; }
			}
			return false;
		}
	
		public int PhraseNum(){ return _phrase; }
		public byte getContents() { return _contents; }
	}


}

