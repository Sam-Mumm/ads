/**
 * Algorithmus von Hierholzer zum finden eines Eulerkreises in ungerichteten Graphen
 * @author Dan Steffen
 * @version 0.1
*/
public class Hierholzer
{
	Node[] head;
	
	/**
	 * Konstruktor der einen leeren Graphen erzeugt
	 * @param n Anzahl der Knoten im Graphen
	 */
	public Hierholzer(int n)
	{
		head = new Node[n];
		
		for(int i=0; i<n; i++)
		{
			head[i]=null;
		}
	}
	
	/**
	 * Fügt eine neue Kante in den Graphen ein
	 * @param v Knoten zwischen dem die Kante verläuft
	 * @param w Knoten zwischen dem die Kante verläuft
	 */
	public void insert(int v, int w)
	{
		Node tmp;
		
		if(head[v-1]==null)
		{
			head[v-1]=new Node(w);
		}
		else
		{
			tmp=head[v-1];
			
			while(tmp.getNext()!=null)
			{
				tmp=tmp.getNext();
			}
			tmp.setNext(new Node(w));
		}

		if(head[w-1]==null)
		{
			head[w-1]=new Node(v);
		}
		else
		{
			tmp=head[w-1];
			
			while(tmp.getNext()!=null)
			{
				tmp=tmp.getNext();
			}
			
			tmp.setNext(new Node(v));
		}
	}
		
	/**
	 * Unterteilt den Graphen anhand des Algorithmus von Hierholzer in mehrere Unterkreise
	 */
	public void eulerCircuit()
	{
		int circuit_number=1;
		int actNumber=-1;
		int preNumber=-1;
		Node[] circles=new Node[this.countNodes()];
		Node act=null;
		Node tmp=null;
		
		// Initialisieren eines leeren Graphen
		for(int i=0; i<this.countNodes(); i++)
		{
			circles[i]=null;
		}

		for(int i=0; i<this.countNodes(); i++)
		{
			while(head[i]!=null)
			{
				actNumber=i;
				do
				{
					// Verschieben der "Hinkanten" in den Hilfsgraphen
					tmp=circles[actNumber];
					circles[actNumber]=new Node(head[actNumber].getNumber(), circuit_number);
					circles[actNumber].setNext(tmp);
					preNumber=actNumber;
					actNumber=head[preNumber].getNumber()-1;
					head[preNumber]=head[preNumber].getNext();
					
					System.out.println("Füge die Kante zwischen den Knoten "+(preNumber+1)+" und "+(actNumber+1)+" zum Kreis "+circuit_number+" hinzu");
					
					// Anlegen der "Rückkante" im Hilfsgraphen
					tmp=circles[actNumber];
					circles[actNumber]=new Node(preNumber+1, circuit_number);
					circles[actNumber].setNext(tmp);
					
					// Entfernen der "Rückkante" aus dem Ursprungsgraphen
					if((head[actNumber].getNumber()-1)==preNumber)
					{
						head[actNumber]=head[actNumber].getNext();
					}
					else
					{
						act=head[actNumber];
						
						while((act.getNext().getNumber()-1)!=preNumber)
						{
							act=act.getNext();
						}
						act.setNext(act.getNext().getNext());
					}
				}
				while(actNumber!=i);
				circuit_number++;
			}
		}
	}

	/**
	 * Liefert die Anzahl der Knoten im Graphen
	 * @return Anzahl der Knoten im Graphen
	 */
	public int countNodes()
	{
		return head.length;
	}
	
	/**
	 * Gibt den Graphen auf der Konsole aus
	 */
	public void outputGraph()
	{
		Node act=null;
		
		for(int i=1; i<=head.length; i++)
		{
			act=head[i-1];
			
			if(act==null)
			{
				System.out.println("Der Knoten "+i+" ist mit keinen weiteren Knoten verbunden");
			}
			else
			{
				System.out.print("Der Knoten "+i+" ist mit den Knoten ");
				while(act!=null)
				{
					System.out.print(act.getNumber()+" ");
					act=act.getNext();
				}
				System.out.println("verbunden");
			}
		}
	}

	/**
	 * Überprüft ob im Graphen alle Knoten geraden Grad besitzt und so ein Eulerkreis existiert
	 * @return liefert true falls ein Eulerkreis existiert und sonst false
	 */
	public boolean existsCircuit()
	{
		Node act=null;
		
		for(int i=0, c=0; i<head.length; i++)
		{
			c=0;
			act=head[i];
			
			while(act!=null)
			{
				c++;
				act=act.getNext();
			}
			
			if(c%2==1)
			{
				return false;
			}
				
		}
		
		return true;
	}
	
	public class Node
	{
		Node next=null;
		int number=-1;
		int circle_no=0;
		
		/**
		 * Erzeugt einen neuen Knoten
		 * @param n Nummer des Knotens
		 */
		public Node(int n)
		{
			number=n;
		}

		/**
		 * Erzeugt einen neuen Knoten
		 * @param n Nummer des Knotens
		 * @param m Nummer des Kreises zu dem die Kante gehört
		 */
		public Node(int n, int m)
		{
			number=n;
			circle_no=m;
		}

		/**
		 * Referenz auf den nächsten Knoten in der Teilliste
		 * @return Liefert die Referenz auf den nächsten Knoten und sonst null
		 */
		public Node getNext()
		{
			return next;
		}
	
		/**
		 * Setzt die Referenz für einen Knoten
		 * @param n Knoten auf den Referenziert werden soll
		 */
		public void setNext(Node n)
		{
			next=n;
		}
		
		/**
		 * Liefert die Nummer des Knotens
		 * @return Nummer des Knotens
		 */
		public int getNumber()
		{
			return number;
		}
		
		/**
		 * Setzt die Nummer des Knotens
		 * @param n Nummer des Knotens
		 */
		public void setNumber(int n)
		{
			number=n;
		}
		
		/**
		 * Liefert die Nummer des Kreises
		 * @return Nummer des Kreises
		 */
		public int getCircleNo()
		{
			return circle_no;
		}
		
		/**
		 * Ordnet die Kante die zwischen dem aktuellen Knoten und der Liste eine Nummer zu
		 * @param n Nummer des Kreises
		 */
		public void setCircleNo(int n)
		{
			circle_no=n;
		}
	}
}