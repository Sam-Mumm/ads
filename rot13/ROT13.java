
public class ROT13
{
	/**
	 * Ver- und Entschlüsselt einen übergebenen String mit dem ROT13-Verfahren
	 */
	public String crypt_decrypt(String input)
	{
		String output="";
		int position=-1;
		
		for(int i=0; i<input.length(); i++)
		{
			// Bestimmt anhand des ASCII Wertes die Position des Zeichen im Alphabet
			// und bestimmt das neue Zeichen nach einem zyklischen Shift um 13 Stellen
			position=input.charAt(i);

			if(position>=65 && position<=90) // Großbuchstaben
			{
				position=(((position-64)+12)%26)+1;
				position=position+64;
			}
			else if(position>=97 && position<=122) // Kleinbuchstaben
			{
				position=(((position-96)+12)%26)+1;
				position=position+96;				
			}
			
			// Bestimmt den neuen ASCII-Wert und wandelt diesen wieder in Zeichen um und
			// fügt dieses an den Ausgabestring an
			output=output+String.valueOf((char)(position));
		}
		
		return output;
	}
}
