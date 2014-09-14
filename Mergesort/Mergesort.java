/**
 * Implementierung des Mergesort Algorithmuses
 * @author steffen
 * @version 0.1
 */
public class Mergesort
{
	/**
	 * Sortierverfahren
	 * @param b - das zu sortierende Array
	 * @return sortiertes Array
	 */
	public int[] sort(int[] b)
	{
		return this.sort(b, 1, b.length);		
	}

	/**
	 * rekursive sortierung einer Teilfolge
	 * @param b - zu sortierende Teilfolge
	 * @param l - linke Grenze der Teilfolge
	 * @param r - rechte Grenze der Teilfolge
	 * @return sortierte Teilfolge
	 */
	private int[] sort(int[] b, int l, int r)
	{
		int m;
		if(l<r)
		{
			m=(l+r)/2;
			sort(b, l, m);
			sort(b, m+1, r);
			b=merge(b, l, m, r);
		}
		
		return b;
	}

	/**
	 * Fügt zwei Teilfolgen zusammen
	 * @param b - Teilfolgen
	 * @param l - linke Grenze der Teilfolge
	 * @param m - Median der beiden Teilfolgen
	 * @param r - rechte Grenze der Teilfolge
	 * @return zusammengefügte Teilfolge
	 */
	private int[] merge(int[] b, int l, int m, int r)
	{
		int i=l;
		int j=m+1;
		int[] c=new int[b.length];
		
		for(int k=l; k<=r; k++)
		{
			if(i>m || (j<=r && b[i-1] > b[j-1]))
			{
				c[k-1]=b[j-1];
				j++;
			}
			else
			{
				c[k-1]=b[i-1];
				i++;
			}
		}
		
		for(int k=l; k<=r; k++)
		{
			b[k-1]=c[k-1];
		}
		
		return b;
	}


}
