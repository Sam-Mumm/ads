/**
 * Implementierung des Dijkstra-Algorithmuses für das SSSP-Problem
 * @author Dan Steffen
 * @version 0.1
 */
public class Dijkstra
{
	private Node[] head;				// Kopf der Adjazenzliste
	private Node[] prioQueue;			// Prioritätswarteschlange
	private Node[] preNode;				// Liste der Vorgänger-Knoten
	private boolean gerichtet=false;

	/**
	 * Konstruktor, erzeugt einen leeren Graphen
	 * @param n - Anzahl der Knoten im Graphen
	 * @param g - Indikator ob es sich um einen gerichteten oder ungerichteten Graphen handelt
	 */
	public Dijkstra(int n, boolean g)
	{
		head=new Node[n];
		preNode=new Node[n];
		prioQueue=new Node[n];
		
		gerichtet=g;
		
		for(int i=1; i<=n; i++)
		{
			head[i-1]=null;
			preNode[i-1]=null;
			prioQueue[i-1]=new Node(i, 99999);
		}	
	}

	/**
	 * Konstruktor, erzeugt einen leeren Graphen
	 * @param n - Anzahl der Knoten im Graphen
	 */
	public Dijkstra(int n)
	{
		head=new Node[n];
		prioQueue=new Node[n];
		
		for(int i=1; i<=n; i++)
		{
			head[i-1]=null;
			preNode[i-1]=null;
			prioQueue[i-1]=new Node(i, 99999);
		}	
	}
	
	/**
	 * Fügt eine neue Kanten in den Graphen ein
	 * @param x - Startpunkt der Kante
	 * @param y - Endpunkt der Kante
	 * @param weight - Gewicht der Kante
	 */
	public void insert(int x, int y, int weight)
	{
		Node akt=head[x-1];
		
		if(head[x-1]==null)
		{
			head[x-1]=new Node(y, weight);
		}
		else
		{
			while(akt.getNext()!=null)
			{
				akt=akt.getNext();
			}
			
			akt.setNext(new Node(y,weight));
		}

		// Falls der Graph ungerichtet ist, füge eine Kante in die Gegenrichtung ein
		if(gerichtet==false)
		{
			akt=head[y-1];
			
			if(head[y-1]==null)
			{
				head[y-1]=new Node(y, weight);				
			}
			else
			{
				while(akt.getNext()!=null)
				{
					akt=akt.getNext();
				}
				
				akt.setNext(new Node(y,weight));
			}
		}
	}

	/**
	 * Default-Aufruf für den Dijkstra-Algorithmus mit Startknoten 1
	 */
	public void dijkstra()
	{
		this.dijkstra(1);
	}
	
	/**
	 * Aufruf des Dijkstra-Algorithmuses
	 * @param nr - Startknoten
	 */
	public void dijkstra(int nr)
	{
		int weight=0;
		Node akt=head[nr-1];
		Node tmp=null;
		
		for(int i=1; i<head.length; i++)
		{
			// Betrachtung aller erreichbaren Knoten
			while(akt!=null)
			{
				// Wurde der Knoten bereits besucht?
				if(preNode[akt.getNr()-1]==null)
				{
					int j=0;
					
					// Kann der Knoten günstiger als bisher erreicht werden?
					do
					{
						j++;
					
						if((prioQueue[j-1].getNr()==akt.getNr()) && (prioQueue[j-1].getWeight()>(akt.getWeight()+weight)))
						{
							prioQueue[j-1].setPreNode(nr);
							prioQueue[j-1].setWeight((akt.getWeight()+weight));
						}
					}
					while(j<prioQueue.length);
				}
				akt=akt.getNext();
			}
			
			// Auswahl des günstigsten Knotens
			for(int k=(prioQueue.length/2); k>=1; k--)
			{
				reHeap(k, prioQueue.length-i);
			}
						
			akt=head[prioQueue[0].getNr()-1];	
			nr=prioQueue[0].getNr();
			weight=prioQueue[0].getWeight();
			
			tmp=prioQueue[0];
			preNode[prioQueue[0].getNr()-1]=prioQueue[0];
			prioQueue[0]=prioQueue[prioQueue.length-i];
			prioQueue[prioQueue.length-i]=tmp;
		}
	}

	/**
	 * Herstelle der Heapeigenschaft
	 * @param i - Grenze bis zu dem die Heapeigenschaft wieder hergestellt werden soll
	 * @param n - Gesamtgröße des Heaps
	 */	
	private void reHeap(int i, int n)
	{
		int j=0;
		Node tmp=null;
		
		while(2*i<=n)
		{
			j=2*i;
			
			if(j<n)
			{
				if(prioQueue[j-1].getWeight()>prioQueue[j].getWeight())
				{
					j=j+1;
				}
			}
			
			if(prioQueue[i-1].getWeight()>prioQueue[j-1].getWeight())
			{
				tmp=prioQueue[j-1];
				prioQueue[j-1]=prioQueue[i-1];
				prioQueue[i-1]=tmp;
				i=j;
			}
			else
			{
				return;
			}
		}
	}

	/**
	 * Ausgabe aller Informationen eines Knotens
	 * @param i - Knoten der abgefragt werden soll
	 */
	public void getNode(int i)
	{
		if(preNode[i-1]==null)
		{
			System.out.println("Der Knoten wurde noch nicht erreicht");
		}
		else
		{
			System.out.println("Der Knoten "+i+" wurde von Knoten "+preNode[i-1].getPreNode()+" mit den Kosten "+preNode[i-1].getWeight()+" erreicht");
		}
	}

	/**
	 * Ausgabe des Graphen
	 */
	public void output()
	{
		Node akt;
		
		for(int i=1; i<=head.length; i++)
		{
			akt=head[i-1];
			
			if(head[i-1]!=null)
			{
				System.out.print("Der Knoten "+i+" ist mit den Knoten: ");
				while(akt!=null)
				{
					System.out.print(akt.getNr()+"("+akt.getWeight()+"), ");
					akt=akt.getNext();
				}
				System.out.print("\n");
			}
			else
			{
				System.out.println("Der Knoten "+i+" hat keine Kanten");
			}
		}
	}

	/**
	 * Liefert den Vorgänger eines Knotens
	 * @param i - Knoten zu dem der Vorgänger gesucht wird
	 * @return Vorgänger des Knotens i
	 */
	public int getPreNode(int i)
	{
		return preNode[i-1].getPreNode();
	}

	/**
	 * Liefert die Kosten mit dem der Knoten i erreicht wurde
	 * @param i - Knoten des Kosten abgefragt werden sollen
	 * @return Kosten bis zum Knoten i
	 */
	public int getCosts(int i)
	{
		return preNode[i-1].getWeight();
	}
	
	class Node
	{
		int nr=-1;
		int weight=99999;
		int preNode=-1;
		Node next=null;
		
		/**
		 * Erzeugt einen Knoten mit einer eindeutigen Nummer und dem Gewicht zu diesem Knoten
		 * @param nr - Nummer des Knotens
		 * @param weight - Gewicht der Kante zu diesem Knoten
		 */
		public Node(int nr, int weight)
		{
			this.nr=nr;
			this.weight=weight;
		}

		/**
		 * Liefert die Referenz auf den folgenden Knoten in der Adjazenzliste
		 * @return Referenz auf das folgende Element oder null
		 */
		public Node getNext()
		{
			return next;
		}

		/**
		 * Setzt die Referenz für den folgenden Knoten innerhalb der Adjazenzliste
		 * @param next - Referenz auf den folgenden Knoten in der Liste
		 */
		public void setNext(Node next)
		{
			this.next = next;
		}

		/**
		 * Liefert die Nummer des Knotens
		 * @return Nummer des Knotens
		 */		
		public int getNr()
		{
			return nr;
		}

		/**
		 * Setzt die Nummer des aktuellen Knotens
		 * @param nr - Nummer für den aktuellen KNoten
		 */
		public void setNr(int nr)
		{
			this.nr = nr;
		}
		
		/**
		 * Liefert das Gewicht der Kante von dem Ursprungsknoten zu diesem Knoten
		 * @return Gewicht der Kante
		 */
		public int getWeight()
		{
			return weight;
		}
		
		/**
		 * Setzt das Gesicht von dem Ursprungsknoten zu diesem Knoten
		 * @param weight - neues Gewicht für die Kante
		 */
		public void setWeight(int weight)
		{
			this.weight = weight;
		}

		/**
		 * Liefert den Vorgänger Knoten von diesem Knoten (wird für Queue benötigt)
		 * @return - Vorgänger Knoten
		 */
		public int getPreNode()
		{
			return preNode;
		}
		
		/**
		 * Setzt den Vorgänger Knoten
		 * @param preNode - Vorgänger Knoten zu diesem Knoten
		 */
		public void setPreNode(int preNode)
		{
			this.preNode = preNode;
		}
	}
}
