/**
 * Implementierung des phonetischen Algorithmus SoundEx
 * @author Dan Steffen
 * @version 0.1
 */
public class SoundEx
{
	/**
	 * Ermittelung des Klangwertes mittels SoundEx
	 * @param input - Eingabestring
	 * @return SoundEx Wert der Form Anfangsbuchstabe plus 3 Zahlen
	 */
	public static String soundEx(String input)
	{
		String output="";
		String tmp1="";
		input=input.replace("ß", "S");
		input=input.toUpperCase();
		output=tmp1.valueOf(input.charAt(0));
		
		for(int pos=1; pos<input.length(); pos++)
		{
			switch(input.charAt(pos))
			{
				case 'B':
				case 'F':
				case 'P':
				case 'V': 	tmp1=tmp1+"1";
						break;
				
				case 'C':
				case 'G':
				case 'J':
				case 'K':
				case 'Q':
				case 'S':
				case 'X':
				case 'Z': 	tmp1=tmp1+"2";
						break;

				case 'D':
				case 'T': 	tmp1=tmp1+"3";
						break;

				case 'L': 	tmp1=tmp1+"4";
						break;

				case 'M':
				case 'N': 	tmp1=tmp1+"5";
						break;

				case 'R': 	tmp1=tmp1+"6";
						break;
			}
		}
				
		// Entfernen von Duplikaten
		// Übertragen des ersten Zeichens
		if(tmp1.length()!=0)
		{
			output=output+tmp1.valueOf(tmp1.charAt(0));
		}
		
		for(int i=1; i<tmp1.length() && output.length()<4; i++)
		{
			if(tmp1.charAt(i-1)!=tmp1.charAt(i))
			{
				output=output+output.valueOf(tmp1.charAt(i));
			}
		}

		if(output.length()<3)
		{
			for(int i=4-output.length(); i>0; i--)
			{
				output=output+"0";
			}
		}
		
		return output;
	}	
}