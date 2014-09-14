/**
 * Implementierung der Faktorisierungsmethode von Lehman
 * @author Dan Steffen
 * @version 0.1
 */
public class Lehmann
{
	/**
	 * Faktorisierung einer Zahl
	 * @param candidate die zu faktorisierende Zahl
	 * @return liefert die Zahl selbst oder 1 falls die Zahl eine Primzahl ist und sonst den Teiler der Zahl
	 */
	public long lehmannFaktor(long candidate)
	{
		double w3candidate=Math.cbrt(candidate);	// Kubikwurzel von der zu überprüfenden Zahl
		long limit=(long)Math.floor(w3candidate);	// Abgerundete Quadratwurzel von der zu prüfenden Zahl
		
		double productSqrt=0;		
		
		long y=0;	
		
		// Überprüft ob die Zahl gerade ist
		if(candidate%2==0)
		{
			return 2;
		}
		
		// Führt eine Probedivision aus
		for(long i=3; i<=limit; i=i+2)
		{
			if(candidate%i==0)
			{
				return i;
			}
		}
	
		for(long k=1; k<=limit; k++)
		{
			productSqrt=Math.sqrt((double)(4*k*candidate));
			
			limit=(long)Math.floor(productSqrt+(Math.pow(candidate, 1.0/6.0)/(4*Math.sqrt((double)k))));
			
			for(long x=(long)Math.floor(productSqrt); x<=limit; x++)
			{
				y=(x*x)-(4*k*candidate);
				
				if(Math.sqrt((double)y)%1==0)
				{
					return this.ggT(x+(long)Math.sqrt(y), candidate);
				}
			}
			
		}
		
		return 1;
	}
	
	/**
	 * Berechnung des größten gemeinsamen Teilers mit dem Euklidschen Verfahren
	 * @param p erste Zahl für die der ggT gebildet werden soll
	 * @param q zweite Zahl für die der ggT gebildet werden soll
	 * @return liefert den gemeinsamten Teiler
	 */
	private long ggT(long p, long q)
	{
		long r=1;
		
		while(q!=0)
		{
			r=p%q;
			p=q;
			q=r;
		}
		
		return p;
	}
}
