/**
 * Modeliert einen Bitvektor
 * @author Dan Steffen
 * @version 0.1
 */

public class Bitvektor
{
	boolean[] bv;

	/**
	 * Konstruktor, erzeugt eine Menge mit n Elementen
	 * @param n - Anzahl der Elemente der Menge
	 */
	public Bitvektor(int n)
	{
		bv=new boolean[n];
		
		for(int i=0; i<n; i++)
		{
			bv[0]=false;
		}
	}
	
	/**
	 * Fügt ein Element der Menge hinzu
	 * @param i - Element i das der Menge hinzugefügt wird
	 */
	public void insert(int i)
	{
		bv[i-1]=true;
	}
	
	/**
	 * Überprüft ob ein konkretes Element in der Menge enthalten ist
	 * @param i - Überprüft ob das Element i in der Menge enthalten ist
	 * @return true falls das Element in der Menge enthalten ist, sonst false
	 */
	public boolean isElement(int i)
	{
		return bv[i-1];
	}

	/**
	 * Vereinigung von zwei Mengen
	 * @param a - Bitvektor mit dem die aktuelle Menge vereinigt wird
	 * @return Bitvektor mit der vereinigten Mengen beider Vektoren
	 */
	public Bitvektor union(Bitvektor a)
	{
		int n=0;
		Bitvektor nb;
		
		if(a.getSize()<bv.length)
		{
			nb=new Bitvektor(bv.length);
			n=bv.length;
		}
		else
		{
			nb=new Bitvektor(a.getSize());
			n=a.getSize();
		}
		
		for(int i=1; i<=n; i++)
		{
			if(bv[i]==true || a.isElement(i)==true)
			{
				nb.insert(i);
			}
		}
		
		return nb;
	}
	
	/**
	 * Bestimmt die Schnittmenge von zwei Mengen
	 * @param a - Bitvektor mit dem die aktuelle Menge geschnitten wird
	 * @return Bitvektor mit der geschnittenen Mengen beider Vektoren
	 */
	public Bitvektor intersection(Bitvektor a)
	{
		int n=0;
		Bitvektor nb;
		
		if(a.getSize()<bv.length)
		{
			nb=new Bitvektor(bv.length);
			n=bv.length;
		}
		else
		{
			nb=new Bitvektor(a.getSize());
			n=a.getSize();
		}
		

		for(int i=1; i<=n; i++)
		{
			if(bv[i]==true && a.isElement(i)==true)
			{
				nb.insert(i);
			}			
		}

		return nb;
	}
	
	/**
	 * Bestimmt die Differenz von zwei Mengen
	 * @param a - Bitvektor mit der die Differenz zu der aktuellen gebildet werden soll
	 * @return Bitvektor mit der Differenz zwischen den beiden Mengen
	 */
	public Bitvektor difference(Bitvektor a)
	{
		int n=0;
		Bitvektor nb;
		
		if(a.getSize()<bv.length)
		{
			nb=new Bitvektor(bv.length);
			n=bv.length;
		}
		else
		{
			nb=new Bitvektor(a.getSize());
			n=a.getSize();
		}
		
		for(int i=1; i<=n; i++)
		{
			if(bv[i]==true && a.isElement(i)==false)
			{
				nb.insert(i);
			}

		}
		
		return nb;
	}
	
	/**
	 * Bestimmt die symmetrische Differenz von zwei Mengen
	 * @param a - Bitvektor mit der die symmetrische Differenz zu der aktuellen gebildet werden soll
	 * @return Bitvektor mit der symmetrische Differenz zwischen den beiden Mengen
	 */
	public Bitvektor synDifference(Bitvektor a)
	{
		int n=0;
		Bitvektor nb;
		
		if(a.getSize()<bv.length)
		{
			nb=new Bitvektor(bv.length);
			n=bv.length;
		}
		else
		{
			nb=new Bitvektor(a.getSize());
			n=a.getSize();
		}
		
		for(int i=1; i<=n; i++)
		{
			if(bv[i]==true ^ a.isElement(i)==true)
			{
				nb.insert(i);
			}

		}

		return nb;
	}
	
	/**
	 * Liefert die Größe der Menge
	 * @return Anzahl der (möglichen) Elemente in der Menge
	 */
	public int getSize()
	{
		return bv.length;	
	}
}