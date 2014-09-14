/**
 * Bestimmung von Schaltjahren
 * @author Dan Steffen
 * @version 0.1
 */
public class Schaltjahr
{
	/**
	 * Überprüfung ob das übergebene Jahr ein Schaltjahr ist
	 * @param year - das zu Überprüfende Jahr
	 * @return true falls es sich um ein Schaltjahr handelt, sonst false
	 */
	public static boolean leapyear(int year)
	{
		if(year%400==0)
		{
			return true;
		}
		
		if(year%100==0)
		{
			return false;			
		}
		
		if(year%4==0)
		{
			return true;			
		}
		return false;
	}
}
