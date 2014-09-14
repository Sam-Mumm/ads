/**
 * Implementierung von Quicksort
 * @author Dan Steffen
 * @version 0.1
 */
public class Quicksort
{
	private int[] a;
	
	/**
	 * Sortierverfahren
	 * @param b - das zu sortierende Array
	 * @return sortiertes Array
	 */
	public int[] sort(int[] a)
	{
		this.a=a;
		return this.sort(1, a.length);
	}
	
	/**
	 * Aufruf des Sortierverfahrens mit den Grenzen
	 * @param l - Linke Grenze des zu sortierenden Bereichs
	 * @param r - Rechte Grenze des zu sortierenden Bereichs
	 * @return sortiertes Array
	 */
	private int[] sort(int l, int r)
	{
		int p=-1;
		if(l<r)
		{
			p=partition(l, r);
			sort(l, p-1);
			sort(p+1, r);
		}
		
		return a;
	}
	
	/**
	 * Tausch der Elemente anhand des pivot Elementes 
	 * @param l - linke Grenze des zu untersuchenden Bereichs
	 * @param r - rechte Grenze des zu untersuchenden Bereichs
	 * @return - korrekte getauschter Intervall
	 */
	private int partition(int l, int r)
	{
		int i=l;
		int j=r-1;
		int pivot=a[r-1];
		int tmp=0;
		
		do
		{
			while(a[i-1]<=pivot && i<r)
			{
				i++;
			}
			
			while(a[j-1]>=pivot && j>l)
			{
				j--;
			}
			
			if(i<j)
			{
				tmp=a[i-1];
				a[i-1]=a[j-1];
				a[j-1]=tmp;
			}
		}
		while(i<j);
		
		if(a[i-1]>pivot)
		{
			tmp=a[i-1];
			a[i-1]=a[r-1];
			a[r-1]=tmp;
		}
		
		return i;
	}
}