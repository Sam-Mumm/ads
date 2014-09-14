/**
 * Implementierung von dem Sortierverfahren Bubblesort
 * @author Dan Steffen
 * @version 0.1
 */
public class Bubblesort
{
	private int a[];
	
	/**
	 * Sortierverfahren
	 * @param b - das zu sortierende Array
	 * @return sortiertes Array
	 */
	public int[] sort(int[] b)
	{
		this.a=b;
		int tmp=0;
		
		for(int i=0; i<a.length-1; i++)
		{
			for(int j=a.length-1; j>i; j--)
			{
				if(a[j-1]>a[j])
				{
					tmp=a[j-1];
					a[j-1]=a[j];
					a[j]=tmp;
				}
			}
		}
		
		return a;
	}
}