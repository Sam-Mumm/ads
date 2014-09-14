class Adjazenzliste
{
	Node[] head;
	boolean directed=false;
	
	/**
	 * Konstruktor der einen leeren Graphen erzeugt
	 * @param n Anzahl der Knoten
	 * @param d Indikator ob es sich um einen gerichteten Graphen handelt
	 */
	public Adjazenzliste(int n, boolean d)
	{
		directed=d;
		head=new Node[n];
	
		for(int i=0; i<head.length; i++)
		{
			head[i]=null;
		}		
	}
	
	/**
	 * Konstruktor der einen leeren Graphen erzeugt
	 * @param n Anzahl der Knoten im Graphen
	 */
	public Adjazenzliste(int n)
	{
		head=new Node[n];
	
		for(int i=0; i<head.length; i++)
		{
			head[i]=null;
		}				
	}

	/**
	 * Fügt eine Kante in den Graphen ein
	 */
	public void insert(int f, int t)
	{
		Node act=null;
		if(head[f-1]==null)
		{
			head[f-1]=new Node(t);
		}
		else
		{
			act=head[f-1];
			while(act.getNext()!=null)
			{
				act=act.getNext();
			}
			act.setNext(new Node(t));
		}
		
		if(directed==false)
		{
			act=head[t-1];
			
			if(head[t-1]==null)
			{
				head[t-1]=new Node(f);
			}
			else
			{
				while(act.getNext()!=null)
				{
					act=act.getNext();
				}
				act.setNext(new Node(f));
			}
			
		}
	}
	
	/**
	 * Fügt eine Kante in den Graphen mit dem Gewicht w ein
	 */
	public void insert(int f, int t, int w)
	{
		Node act=null;
		if(head[f-1]==null)
		{
			head[f-1]=new Node(t);
		}
		else
		{
			act=head[f-1];
			while(act.getNext()!=null)
			{
				act=act.getNext();
			}
			act.setNext(new Node(t, w));
		}
		
		if(directed==false)
		{
			act=head[t-1];
			
			if(head[t-1]==null)
			{
				head[t-1]=new Node(f);
			}
			else
			{
				while(act.getNext()!=null)
				{
					act=act.getNext();
				}
				act.setNext(new Node(f, w));
			}
		}		
	}

	/**
	 * Ausgabe des Graphen
	 */
	public void output()
	{
		int number=0;
		Node act=null;
		
		for(int i=0; i<head.length; i++)
		{
			number=i+1;

			if(head[i]==null)
			{
				System.out.print("Der Knoten "+number+" besitzt keine Kanten");
			}
			else
			{
				act=head[i];
				System.out.print("Der Knoten "+number+" ist adjazent mit den Knoten ");
				while(act!=null)
				{
					System.out.print(act.getNumber()+" ");
					act=act.getNext();
				}
			}
			System.out.println();
		}
	}
	
	// Definition eines Knotens
	class Node
	{
		int number=-1;
		int weight=-999;
		Node next;
		
		// Konstruktor der einen neuen Knoten erzeugt
		public Node(int n)
		{
			number=n;
		}

		// Konstruktor der einen neuen Knoten erzeugt		
		public Node(int n, int w)
		{
			number=n;
			weight=w;
		}
		
		public void setNumber(int n)
		{
			number=n;
		}
		
		public void setNext(Node n)
		{
			next=n;
		}
		
		public void setWeight(int w)
		{
			weight=w;
		}
		
		public int getNumber()
		{
			return number;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public int getWeight()
		{
			return weight;
		}
	}
}