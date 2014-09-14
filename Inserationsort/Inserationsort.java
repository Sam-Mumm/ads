
public class Inserationsort
{
	public int[] sort(int[] a)
	{
		int j=-1;
		int tmp=0;
		
		for(int i=1; i<a.length; i++)
		{
			j=i;
			
			while(j>=1 && a[j-1]>a[j])
			{
				tmp=a[j];
				a[j]=a[j-1];
				a[j-1]=tmp;
				
				j=j-1;
			}
		}
		
		return a;
	}
}