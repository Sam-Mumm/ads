/**
 * Implementierung des offenen Hashings
 * @author Dan Steffen
 * @version 0.1
 */
public class Open_Hashing
{
	Element[] head;
	
	/**
	 * Konstruktor erzeugt einen Adressbereich mit der Länge n
	 * @param n - anzahl der Adressen der Hashtabelle
	 */
	public Open_Hashing(int n)
	{
		head=new Element[n];
		
		for(int i=0; i<n; i++)
		{
			head[i]=null;
		}
	}
	
	/**
	 * Fügt einen neuen Wert in die Hashtabelle ein
	 * @param x Schlüssel der eingefügt werden soll
	 */
	public void insert(int x)
	{
		Element tmp=null;
		int key=this.getHash(x);
		
		if(head[key]==null)
		{
			head[key]=new Element(x);
		}
		else
		{
			tmp=head[key];
			
			while(tmp.getNext()!=null)
			{
				tmp=tmp.getNext();
			}
			
			tmp.setNext(new Element(x));
		}
		
	}
	
	/**
	 * Löscht einen Schlüssel aus der Hashtabelle
	 * @param x - Schlüssel der gelöscht werden soll
	 */
	public void delete(int x)
	{
		int key=this.getHash(x);
		Element akt=head[key];
		Element prev=null;
		
		if(head[key]==null)
		{
			return;
		}
		else if(head[key].getValue()==x)
		{
			head[key]=akt.getNext();
		}
		else
		{
			while(akt.getValue()!=x && akt.getNext()!=null)
			{
				prev=akt;
				akt=akt.getNext();
			}

			if(akt.getValue()==x)
			{
				prev.setNext(akt.getNext());
			}
		}
		
	}
	
	/**
	 * Durchsucht die Hashtabelle nach dem entsprechenden Schlüssel
	 * @param x - Schlüssel nach dem gesucht werden soll
	 * @return Liefert das gesuchte Element, sonst null
	 */
	public Element search(int x)
	{
		int key=this.getHash(x);
		Element tmp=head[key];
		
		while(tmp!=null)
		{
			if(tmp.getValue()==key)
			{
				return tmp;
			}
			tmp=tmp.getNext();
		}
		
		return null;
	}
	
	/**
	 * Liefert die Adresse zu einem einzufügenden Schlüssel
	 * @param x - Schlüssel der eingefügt werden soll
	 * @return Hashwert des Schlüssels
	 */
	private int getHash(int x)
	{
		return x%head.length;
	}
	
	/**
	 * Ausgabe der Hashtabelle
	 */
	public void output()
	{	
		Element tmp=null;
		
		for(int i=0, key=1; i<head.length; i++)
		{
			System.out.print("Adresse "+key+": ");
						
			if(head[i]==null)
			{
				System.out.print(" ist leer");
			}
			else
			{
				tmp=head[i];
				
				while(tmp!=null)
				{
					System.out.print(tmp.getValue()+", ");
					tmp=tmp.getNext();
				}
			}
			
			System.out.print("\n");
			key++;
		}
	}
	
	public class Element
	{
		Element next=null;
		int value=-1;
		
		/**
		 * Konstruktor - erzeugt ein neues Element
		 * @param n Schlüssel des neuen Elementes
		 */
		public Element(int n)
		{
			value=n;
		}

		/**
		 * Liefert den Schlüssel des aktuellen Elementes
		 * @return - Schlüssel des Elementes
		 */
		public int getValue()
		{
			return value;
		}
		
		/**
		 * Liefert die Referenz auf das nächste Element
		 * @return Referenz auf das nächste Element
		 */
		public Element getNext()
		{
			return next;
		}
		
		/**
		 * Setzt den Schlüssel für das aktuelle Element
		 * @param n - neuer Wert des Elementes
		 */
		public void setValue(int n)
		{
			value=n;
		}
		
		/**
		 * Liefert die Referenz auf das nächste Element
		 * @param n - Referenz auf das nächste Element oder null
		 */
		public void setNext(Element n)
		{
			next=n;
		}
	}
}