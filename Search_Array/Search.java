/**
 * Implementierung von der binären, linearer und geometrischer Suche
 * @author Dan Steffen
 * @version 0.1
 */
public class Search
{
	private int a[];
	
	/**
	 * lineare Suche
	 * @param b - Array auf dem die Suche ausgeführt werden soll
	 * @param key - Schlüssel nach dem gesucht werden soll
	 * @return true falls das Element enthalten ist, sonst false
	 */
	public boolean linSearch(int[] b, int key)
	{
		this.a=b;
		
		for(int i=0; i<a.length; i++)
		{
			if(a[i]==key)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * binäre Suche
	 * @param b - Array auf dem die Suche ausgeführt werden soll
	 * @param key - Schlüssel nach dem gesucht werden soll
	 * @return true falls das Element enthalten ist, sonst false
	 */
	public boolean binSearch(int[] b, int key)
	{
		this.a=b;
		int l=0;
		int r=a.length-1;
		int m=-1;
		
		
		while(l <= r)
		{
			m=(l+r)/2;
			
			if(a[m]==key)
			{
				return true;
			}
			else
			{
				if(key<a[m])
				{
					r=m-1;
				}
				else
				{
					l=m+1;
				}
			}
		}
		
		return false;	
	}
	
	/**
	 * geometrische Suche
	 * @param b - Array auf dem die Suche ausgeführt werden soll
	 * @param key - Schlüssel nach dem gesucht werden soll
	 * @return true falls das Element enthalten ist, sonst false
	 */
	public boolean geoSearch(int[] b, int key)
	{
		int pot=1;
		int pot_prev=pot;

		while(pot<b.length)
		{
			if(b[pot-1]==key)
			{
				return true;
			}
			
			
			if(b[pot-1]>key)
			{
				return binSearch(pot_prev, pot, b, key);
			}
			
			pot_prev=pot;
			pot=pot*2;
		}
		
		return binSearch(pot_prev, b.length, b, key);
	}
	
	/**
	 * binäre Suche auf einem eingeschränkten Intervall
	 * @param b - Array auf dem die Suche ausgeführt werden soll
	 * @param key - Schlüssel nach dem gesucht werden soll
	 * @param start - Startpunkt des Intervalls
	 * @param end - Endpunkt des Intervalls
	 * @return true falls das Element enthalten ist, sonst false
	 */
	private boolean binSearch(int start, int end, int[] b, int key)
	{
		int l=start;
		int r=end;
		int m=-1;
		this.a=b;
		
		while(l <= r)
		{
			m=(l+r)/2;
			
			if(a[m-1]==key)
			{
				return true;
			}
			else
			{
				if(key<a[m])
				{
					r=m-1;
				}
				else
				{
					l=m+1;
				}
			}
		}
		
		return false;	
	}
}