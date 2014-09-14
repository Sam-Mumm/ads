/**
 * Implementierung einer spärlich besetzen Matrix
 * @author Dan Steffen
 * @version 0.2
 */
public class Sparse_Matrix
{
	Element head[];
	
	/**
	 * Erzeugung einer leeren quadratischen Matrix
	 * @param n - Anzahl Zeilen / Spalten als int
	 */
	public Sparse_Matrix(int n)
	{
		head=new Element[n];
		
		for(int i=1; i<=n; i++)
		{
			head[i-1]=new Element(i, 0, 0);
		}
	}
	
	/**
	 * Fügt einen neuen Wert in die Matrix ein
	 * @param r	- Zeile in der Matrix (zwischen 0 und n-1)
	 * @param c	- Spalte in der Matrix (zwischen 0 und n-1)
	 * @param v - Wert
	 */
	public void insert(int r, int c, int v)
	{
		Element akt=head[r-1];
		Element tmp=null;
		
		while(akt.getNext()!=null && akt.getColumn()<c)
		{
			akt=akt.getNext();
		}
		
		if(akt.getNext()==null)
		{
			akt.setNext(new Element(r, c, v));
		}
		else
		{
			tmp=akt.getNext();
			akt.setNext(new Element(r, c, v));
			akt.getNext().setNext(tmp);
		}
	}
	
	/**
	 * Größe der Matrix
	 * @return Größe des Arrays als int
	 */
	public int getSize()
	{
		return head.length;
	}

	/**
	 * Ausgabe der Matrix
	 */
	public void output()
	{
		Element akt=null;
		
		for(int i=1; i<=head.length; i++)
		{
			akt=head[i-1];
			
			System.out.println(i+". Zeile");
			
			while(akt!=null)
			{
				// Column == 0 gilt beim ersten Element
				if(akt.getColumn()!=0)
				{
					System.out.println("\t Spalte: "+akt.getColumn());
					System.out.println("\t Wert: "+akt.getValue());
				}
				
				akt=akt.getNext();
			}
		}
	}
	
	public class Element
	{
		int row=0;				// Zeile
		int column=0;			// Spalte
		int value=0;
		Element next=null;
		
		/**
		 * Konstruktor für die Erzeugung eines Elementes
		 * @param r	- Zeile in der Matrix (zwischen 0 und n-1)
	 	 * @param c	- Spalte in der Matrix (zwischen 0 und n-1)
	 	 * @param v - Wert
   	 	 */
		public Element(int r, int c, int v)
		{
			row=r;
			column=c;
			value=v;
			next=null;
		}
		
		/**
		 * Definiert die Zeile
		 * @param r - Wert der Zeile (zwischen 0 und n-1)
		 */
		public void setRow(int r)
		{
			row=r;
		}
		
		/**
		 * Definiert die Spalte
		 * @param c - Wert der Zeile (zwischen 0 und n-1)
		 */
		public void setColumn(int c)
		{
			column=c;
		}
		
		/**
		 * Definiert den Wert
		 * @param v - Wert
		 */
		public void setValue(int v)
		{
			value=v;
		}
		
		/**
		 * Definiert die Referenz auf das nächste Element
		 * @param n - Referenz auf das nächste Element
		 */		
		public void setNext(Element n)
		{
			next=n;
		}
		
		/**
		 * Liefert die Zeile
		 * @return Wert der Zeile als int
		 */
		public int getRow()
		{
			return row;
		}

		/**
		 * Liefert die Spalte
		 * @return Wert der Spalte als int
		 */
		public int getColumn()
		{
			return column;
		}
		
		/**
		 * Liefert den Wert des Feldes
		 * @return - Wert des Feldes
		 */
		public int getValue()
		{
			return value;
		}

		/**
		 * Liefert die Referenz auf das nächste Element
		 * @return Referenz auf das folgende Element
		 */
		public Element getNext()
		{
			return next;
		}
	}
}
