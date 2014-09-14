/**
 * Implementierung des Sieb des Eratosthenes
 * @author Dan Steffen
 * @version 0.1
 */

public class Eratosthenes
{
	/**
	 * Berechnung des Siebes des Eratosthenes bis zur Zahl n
	 * @param n - obere Grenze des Siebes
	 * @return Array über alle Zahlen von 1 bis n dabei gilt true=Primzahl, sonst false
	 */
	public boolean[] sieb(int n)
	{
		boolean numbers[]=new boolean[n];
		
		// Initialisierung des Arrays
		for(int i=0; i<n; i++)
		{
			numbers[i]=false;
		}
		
		numbers[0]=true;
		
		for(int i=2; i<numbers.length/2; i++)
		{
			if(numbers[i-1]==false)
			{
				for(int j=i*2; j<=numbers.length; j=j+i)
				{
					numbers[j-1]=true;
				}
			}
		}
		
		
		for(int i=2, zahl=0; i<numbers.length; i++)
		{
			if(numbers[i-1]==false)
			{
				zahl=i+1;
				
				System.out.print(i+" ");
			}
		}
		
		return numbers;
	}
}