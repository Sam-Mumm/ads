import java.util.*;
/**
 * Implementierung einer Breitensuche auf einer Adjazenzliste
 * @author Dan Steffen
 * @version 0.1
 */
public class BFS
{
	private boolean gerichtet=false;                        // Art des Graphen (false = ungerichtet)
	private Node[] head;					// Adjazenzliste
	private int[] num;					// Knotennummern
	private int counter=1;
	private Queue<Integer> q=new LinkedList<Integer>();
	
	/**
	 * Default-Konstruktor zur Erzeugung des Graphen
	 * @param n Anzahl der Knoten im Graphen
	 */
	public BFS(int n)
	{
		this.gerichtet=false;

		head=new Node[n];
		num=new int[n];
		
		for(int i=0; i<n; i++)
		{
			head[i]=null;
			num[i]=0;
		}
	}
	
	/**
	 * Konstruktor zur Erzeugung des Graphen
	 * @param n Anzahl der Knoten im Graphen
	 * @param g Indikator ob der Graphn gerichtet oder ungerichtet ist
	 */
	public BFS(int n, boolean g)
	{
		this.gerichtet=g;
		
		head=new Node[n];
		num=new int[n];

		for(int i=0; i<n; i++)
		{
			head[i]=null;
			num[i]=0;
		}
	}
	
	/**
	 * Fügt eine (zwei falls der Graph ungericht ist) neue Kante(n) in den Graphen ein
	 * @param x Kante zwischen der die Kante verläuft
	 * @param y Kante zwischen der die Kante verläuft
	 */
	public void insert(int x, int y)
	{
		Node akt=null;
		
		if(head[x-1]==null)
		{
			head[x-1]=new Node(y);			
		}
		else
		{
			akt=head[x-1];
			
			while(akt.getNext()!=null)
			{
				akt=akt.getNext();
			}
			
			akt.setNext(new Node(y));
		}
		
		// Falls der Graph ungerichtet ist
		if(gerichtet==false)
		{			
			if(head[y-1]==null)
			{
				head[y-1]=new Node(x);
			}
			else
			{
				akt=head[y-1];

				while(akt.getNext()!=null)
				{
					akt=akt.getNext();
				}
				
				akt.setNext(new Node(x));
			}
		}
	}
	
	/**
	 * Aufruf der Breitensuche
	 */
	public void breadth_first_search()
	{
		for(int i=1; i<=head.length; i++)
		{
			if(head[i-1]!=null)
			{
				this.bfs(i);
			}
		}
	}
	
	/**
	 * Aufruf der Breitensuche mit einem konkreten Startknoten
	 * @param knotenNr Startknoten für die Breitensuche
	 */
	private void bfs(int knotenNr)
	{
		Node akt=null;
		int nextNode=-1;
		
		if(head[knotenNr-1]!=null)
		{
			akt=head[knotenNr-1];
			
			while(akt!=null)
			{
				if(num[akt.getValue()]!=0)
				{
					q.offer(akt.getValue());
				}
				akt=akt.getNext();
			}
		}
		
		if(q.isEmpty()!=true)
		{
			nextNode=q.peek();
			num[nextNode-1]=counter++;
			this.bfs(nextNode);
		}
	}
	
	/**
	 * Ausgabe des Graphen
	 */
	public void output()
	{
		Node akt=null;
		
		for(int i=1; i<=head.length; i++)
		{
			if(head[i-1]==null)
			{
				System.out.println("Der Knoten "+i+" ist mit keinem anderen Knoten verbunden");
			}
			else
			{
				akt=head[i-1];
				System.out.print("Der Knoten "+i+" ist mit den Knoten: ");
				
				while(akt!=null)
				{
					System.out.print(akt.getValue()+" ");
					akt=akt.getNext();
				}
				System.out.print("verbunden \n");
			}
		}
		
	}
	
	public class Node
	{
		private int value=-1;
		private Node next=null;
		
		/**
		 * Konstruktor - Definition eines neuen Knoten
		 * @param x - Nummer des Knoten
		 */
		public Node(int x)
		{
			value=x;
		}
	
		/**
		 * Setzt die Nummer des Knoten
		 * @param x - Nummer des Knoten
		 */
		public void setValue(int x)
		{
			value=x;
		}

		/**
		 * Setzt die Referenz auf den nächsten Knoten
		 * @param n - Referenz auf den nächsten Knoten
		 */
		public void setNext(Node n)
		{
			next=n;
		}

		/**
		 * Liefert die Nummer des aktuellen Knotens
		 * @return Nummer des Knotens
		 */
		public int getValue()
		{
			return value;
		}

		/**
		 * Liefert die Referenz auf den nächsten Knoten
		 * @return Referenz auf den nächsten Knoten
		 */
		public Node getNext()
		{
			return next;
		}
	}
}