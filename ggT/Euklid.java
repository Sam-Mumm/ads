	/**
 * Berechnung des größten gemeinsamen Teilers
 * @author Dan Steffen
 * @version 0.1
 */
public class Euklid
{
	/**
	 * Euklidscher Algorithmus zur Berechnung zur Bestimmung des ggT
	 * @param a - erste Zahl als int
	 * @param b - zweite Zahl als int
	 * @return
	 */
	public int ggt(int a, int b)
	{
		int h=0;
		
		while(b!=0)
		{
			h=a%b;
			a=b;
			b=h;
		}		
		return a;
	}
}