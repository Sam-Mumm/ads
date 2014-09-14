
public class Selectionsort
{
	public int[] sort(int[] a)
	{
		int min=-1;
		int tmp=0;
		
		for(int j=0; j<a.length-1; j++)
		{
			min=j;
			for(int i=j+1; i<a.length; i++)
			{
				if(a[i]<a[min])
				{
					min=i;
				}
			}

			tmp=a[min];
			a[min]=a[j];
			a[j]=tmp;
		}
		
		return a;
	}
}