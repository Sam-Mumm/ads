/**
 * Implementierung einr linearen Liste
 * @author Dan Steffen
 * @version 0.1
 */
public class Linear_List
{
	private Element head=null;
	private int counter=0;
	
	/**
	 * Überprüft ob die Liste leer ist
	 * @return liefert true falls die Liste leer ist, sonst false
	 */
	public boolean isEmpty()
	{
		if(head==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Fügt ein neues Element in die Liste ein
	 * @param Schlüssel des neuen Wertes
	 */
	public void insert(int x)
	{
		Element akt=head;
		Element tmp=null;
		
		this.increaseCounter();
		if(head==null)
		{
			head=new Element(x);
		}
		else if(head.value>x)
		{
			tmp=head;
			head=new Element(x);
			head.setNext(tmp);
		}
		else
		{
			while(akt.getNext()!=null && x>akt.getNext().getValue())
			{
				akt=akt.getNext();
			}
			
			if(akt.getNext()==null)
			{
				akt.setNext(new Element(x));
			}
			else
			{
				tmp=akt.getNext();
				akt.setNext(new Element(x));
				akt.getNext().setNext(tmp);
			}
		}
	}

	/**
	 * Löscht ein Element aus der Liste
	 * @param x - Schlüssel der gelöscht werden soll
	 */
	public void delete(int x)
	{
		Element akt=head;
		Element prev=head;
		
		if(head!=null)
		{
			if(head.getValue()==x)
			{
				System.out.println("ja");
				head=akt.getNext();
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
			this.degreaseCounter();
		}
	}
	
	/**
	 * Durchsucht die Liste nach dem angegebenen Schlüssel
	 * @param x - Schlüssel nachdem gesucht werden soll
	 * @return liefert das Element falls es gefunden wird, sonst null
	 */
	public Element search(int x)
	{
		Element akt=head;
		
		while(akt.getNext()!=null && akt.getValue()!=x)
		{
			akt=akt.getNext();
		}
		
		if(akt.getValue()==x)
		{
			return akt;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Ausgabe der Liste
	 */
	public void output()
	{
		int pos=1;
		Element akt=head;
		
		if(head==null)
		{
			System.out.println("Die Liste ist leer");
		}
		else
		{
			while(akt!=null)
			{
				System.out.println(pos+". Position: "+akt.getValue());
				pos++;
				akt=akt.getNext();
			}
		}
		System.out.println("");
		
	}
	
	/**
	 * Liefert die Anzahl der Elemente in der Liste 
	 * @return Anzahl der Elemente in der Liste
	 */
	public int getCounter()
	{
		return counter;
	}
	
	/**
	 * Verringert die Anzahl der Elemente in der Liste
	 */
	private void degreaseCounter()
	{
		counter--;
	}

	/**
	 * Erhöht die Anzahl der Elemente in der Liste
	 */
	private void increaseCounter()
	{
		counter++;
	}
	
	class Element
	{ 
		private int value=999;
		private Element next=null;
		
		/**
		 * Konstruktor - erzeugt ein neues Element
		 * @param x - Schlüssel des neuen Elementes
		 */
		public Element(int x)
		{
			this.setValue(x);
		}

		/**
		 * Setzt die Referenz auf das nächste Element
		 * @param n - das zu referenzierende Element
		 */
		public void setNext(Element n)
		{
			next=n;
		}
		
		/**
		 * Liefert die Referenz auf das nächste Element
		 * @return - Referenz auf das nächste Element und sonst null
		 */
		public Element getNext()
		{
			return next;
		}

		/**
		 * Setzt den Wert für das Element
		 * @param x - Wert für Element
		 */
		public void setValue(int x)
		{
			value=x;
		}
		
		/**
		 * Liefert den Wert von dem aktuellen Element
		 * @return Wert von dem Element
		 */
		public int getValue()
		{
			return value;
		}		
	}
}