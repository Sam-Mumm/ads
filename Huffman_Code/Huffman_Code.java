
public class Huffman_Code
{
	Node characters[];
	String codes[];
	Node list=null;
	
	/**
	 * Konstruktor der eine Tabelle für die 128-ASCII Zeichen und einen leeren erzeugt
	 */
	public Huffman_Code()
	{
		characters=new Node[128];
		codes=new String[128];
		String c="";
		
		for(int i=0; i<128; i++)
		{
			codes[i]="";
			characters[i]=new Node(c.valueOf((char)i));
		}
	}
	
	/**
	 * Erzeugt den Huffman-Code sowie den dazu benötigten Baum
	 * @param str - Eingabe die kodiert werden soll
	 */
	public void encodeText(String str)
	{
		this.generateTree(str);
	}

	/**
	 * Liefert zu einem Codewort das passende Zeichen
	 * @param str - Codewort das ein Zeichen codiert
	 * @return liefert null wenn der Baum leer ist und sonst das Zeichen
	 */
	public String decodeWord(String str)
	{
		Node actNode=list;
		
		if(list==null)
		{
			return null;
		}

		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i)=='0')
			{
				actNode=actNode.getRightChild();
			}
			else
			{
				actNode=actNode.getLeftChild();
			}
		}
		return actNode.getCharacter();
	}
	
	/**
	 * Erzeugt den Huffman-Baum
	 * @param str Wort über den der Baum erzeugt werden soll
	 */
	private void generateTree(String str)
	{
		Node tree=null;
		Node actNode=null;
		Node preNode=null;
		Node tmp;
		
		for(int i=0; i<str.length(); i++)
		{
			characters[(int)str.charAt(i)].increaseCounter();
		}
		
		// Sortierung der Zeichen nach ihrer Häufigkeit
		this.sort();

		if(characters[0].getCounter()>0)
		{
			list=characters[0];
			preNode=list;
		}
		
		for(int i=1; i<characters.length && characters[i].getCounter()>0; i++)
		{
			preNode.setNext(characters[i]);
			preNode=preNode.getNext();
		}
		
		actNode=list;

		// Durchlauf der Liste(n) solange mehr als Knoten existiert
		while(actNode.getNext()!=null)
		{
			while(actNode!=null)
			{
				// Es existieren noch mindestens 2 Knoten
				if(actNode.getNext()!=null)
				{
					tmp=new Node();
					tmp.setCounter(actNode.getCounter()+actNode.getNext().getCounter());
					tmp.setCharacter(actNode.getCharacter()+actNode.getNext().getCharacter());
					tmp.setRightChild(actNode.getNext());
					tmp.setLeftChild(actNode);
					
					this.generateCode(actNode, "1");
					this.generateCode(actNode.getNext(), "0");
					
					actNode=actNode.getNext().getNext();					
				}
				else
				{
					tmp=actNode;
					actNode=actNode.getNext();
				}

				if(tree==null)
				{
					tree=tmp;
					preNode=tree;
				}
				else
				{
					preNode.setNext(tmp);
					preNode=preNode.getNext();
				}
			}
			list=tree;
			tree=null;
			actNode=list;
		}
	}
	
	/**
	 * Hiflsmethode die anhand eines Knoten den Huffman-Code erweitert 
	 * @param n Knoten im Baum
	 * @param c Kennzeichen ob es sich um einen linkes oder rechtes Kindhandelt (0/1)
	 */
	private void generateCode(Node n, String c)
	{
		String str=n.getCharacter();
		for(int i=0, index=0; i<str.length(); i++)
		{
			index=(int)str.charAt(i);
			codes[index]=c+codes[index];
		}
	}

	/**
	 * Ausgabe der Codes (zum Debuggen)
	 */
	public void outputCodes()
	{
		for(int i=0; i<codes.length; i++)
		{
			if(!codes[i].isEmpty())
			System.out.println((char)i+"= "+codes[i]);
		}
	}

	/**
	 * Aufsteigende sortierung der Zeichen mittels Selectionsort
	 */
	private void sort()
	{
		int j=-1;
		Node tmp=null;
		
		for(int i=1; i<characters.length; i++)
		{
			j=i;
 
			while(j>=1 && characters[j-1].getCounter()<characters[j].getCounter())
			{
				tmp=characters[j];
				characters[j]=characters[j-1];
				characters[j-1]=tmp;
 
				j=j-1;
			}
		}
	}
	
	public class Node
	{
		String character;
		int counter=0;
		Node leftChild=null;
		Node rightChild=null;
		Node next=null;

		public Node()
		{
			counter=0;
			Node leftChild=null;
			Node rightChild=null;
			Node next=null;
		}

		public Node(String s)
		{
			this.character=s;
			counter=0;
			Node leftChild=null;
			Node rightChild=null;
			Node next=null;
		}

		public int getCounter()
		{
			return counter;
		}
		
		public void setCounter(int c)
		{
			counter=c;
		}
		
		public void increaseCounter()
		{
			counter++;
		}

		public void increaseCounter(int c)
		{
			counter=counter+c;
		}
		
		public Node getLeftChild()
		{
			return leftChild;
		}

		public Node getRightChild()
		{
			return rightChild;
		}

		public Node getNext()
		{
			return next;
		}

		public void setLeftChild(Node l)
		{
			leftChild=l;
		}

		public void setRightChild(Node r)
		{
			rightChild=r;
		}
		
		public void setNext(Node n)
		{
			next=n;
		}
		
		public String getCharacter()
		{
			return character;
		}
		
		public void setCharacter(String s)
		{
			character=s;
		}
	}
}