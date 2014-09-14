/**
 * Implemenmtierung einer Queue
 * @author Dan Steffen
 * @version 0.1
 *
 */
public class Queue
{
	Element head=null;
	
	/**
	 * Überprüft ob die Queue leer ist
	 * @return true falls ja, sonst false
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
	 * Fügt ein Element x in die Queue ein
	 * @param x - Element das eingefügt werden soll
	 */
	public void insert(int x)
	{
		Element temp;
		
		if(this.isEmpty())
		{
			head=new Element(x);
		}
		else
		{
			temp=head;
			
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			
			temp.setNext(new Element(x));
		}
	}
	
	/**
	 * Liefert nach dem FIFO Prinzip ein Element aus der Queue
	 * @return erste Element aus der Queue
	 */
	public int getElement()
	{
		int x=-999;
		Element temp=head;;
		
		if(!this.isEmpty())
		{
			x=temp.getValue();
			head=temp.getNext();
		}
		
		return x;
	}
	
	/**
	 * Beschreibung eines Elementes der Queue
	 */
	private class Element
	{
		Element next=null;
		int value=0;
		
		/**
		 * Konstruktor, erzeugt ein neues Element mit dem Wert x
		 * @param x - Wert des neuen Elementes
		 */
		public Element(int x)
		{
			value=x;
		}
		
		/**
		 * Setzt die Referenz auf das nächste Element
		 * @param n - das zu referenzierendes Element
		 */
		public void setNext(Element n)
		{
			next=n;
		}
		
		/**
		 * Setzt den Wert für ein Element
		 * @param x - neuer Wert des Elementes
		 */
		public void setValue(int x)
		{
			value=x;
		}
		
		/**
		 * Liefert die Referenz auf das nächste Element
		 * @return Referenz auf das Element oder null, falls keine Referenz vorhanden ist
		 */
		public Element getNext()
		{
			return next;
		}
		
		/**
		 * Wert des Elementes
		 * @return Wert des Elementes
		 */
		public int getValue()
		{
			return value;
		}
	}
}