/**
 * Implementierung eines Stacks
 * @author Dan Steffen
 * @version 0.1
 */
public class Stack
{
	Element head=null;

	/**
	 * Überprüft ob der Stack leer ist
	 * @return true falls der Stack leer ist, sonst false
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
	 * Fügt ein neues Element in den Stack ein
	 * @param x - Element mit dem Wert x welches eingefügt wird
	 */
	public void push(int x)
	{
		Element temp1=head;
		head=new Element(x);
		head.setNext(temp1);
	}

	/** 
	 * Entnimmt nach dem LIFO Prinzip ein Element aus dem Stack
	 * @return Element aus dem Stack
	 */
	public int pop()
	{
		int x=-999;
		Element temp=head;
		
		if(!this.isEmpty())
		{
			x=temp.getValue();
			head=temp.getNext();
		}
		
		return x;
	}
	
	/**
	 * Beschreibt ein Element
	 */
	private class Element
	{
		Element next=null;
		int value=0;

		/**
		 * Erzeugt ein neues Element
		 * @param x - Wert des Elementes
		 */
		public Element(int x)
		{
			value=x;
		}
		
		/**
		 * Setzt die Referenz auf das nächste Element
		 * @param n - Element auf welches referenziert wird
		 */
		public void setNext(Element n)
		{
			next=n;
		}
		
		/**
		 * Setzt den Wert für ein Element
		 * @param x - neuer Wert für das Element
		 */
		public void setValue(int x)
		{
			value=x;
		}
		
		/**
		 * Liefert das nächste Element auf das referenziert wird
		 * @return nächstes Element, oder null falls kein Element vorhanden
		 */
		public Element getNext()
		{
			return next;
		}
		
		/**
		 * Liefert den Wert des aktuellen Elementes
		 * @return Wert des aktuellen Elementes
		 */
		public int getValue()
		{
			return value;
		}
	}
}