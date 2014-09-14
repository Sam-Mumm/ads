/**
 * Implementierung des Heron-Verfahrens (Berechnung der Quadratwurzel)
 * @author Dan Steffen
 * @version 0.1
 */
public class Heron
{
	/**
	 * Berechnung der Quadratwurzel
	 * @param a - Zahl von der die Quadratwurzel bestimmt werden soll
	 * @param n - Anzahl der Iterationen
	 * @return Quadratwurzel von a als double
	 */
	public double squareRoot(double a, long n)
	{
		return squareRoot(a, a, n);
	}
	
	/**
	 * Berechnung der Quadratwurzel
	 * @param a - Zahl von der die Quadratwurzel berechnet werden soll
	 * @param x0 - Startwert für das Heron-Verfahren
	 * @param n - Anzahl der Iterationen
	 * @return - Quadratwurzel von a als double
	 */
	public double squareRoot(double a, double x0, long n)
	{
		double x1=-1;
		
		if(a<0)
		{
			return -1;
		}
		
		for(int i=1; i<=n; i++)
		{
			x1=(x0+(a/x0))/2;
			x0=x1;
		}
		
		return x1;
	}
}
