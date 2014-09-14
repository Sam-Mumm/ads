public class Koelner_Phonetik
{	
	public static String phonetik(String eingabe)
	{
		String tmp1="";
		String tmp2="";
 
		eingabe=eingabe.toLowerCase();
 
		for(int i=0; i<eingabe.length(); i++)
		{
			switch(eingabe.charAt(i))
			{
				case 'a':
				case 'ä':
				case 'e':
				case 'i':
				case 'j':
				case 'o':
				case 'ö':
				case 'u':
				case 'ü':
				case 'y': 	tmp1=tmp1+"0";
							break;
 
				case 'b':	tmp1=tmp1+"1";
							break;
 
				case 'f':
				case 'v':
				case 'w':	tmp1=tmp1+"3";
							break;
 
				case 'g':
				case 'k':
				case 'q':	tmp1=tmp1+"4";
							break;
 
				case 'l':	tmp1=tmp1+"5";
							break;
 
				case 'm':
				case 'n': 	tmp1=tmp1+"6";
							break;
 
				case 'r': 	tmp1=tmp1+"7";
							break;
 
				case 's':	
				case 'z':
				case 'ß':	tmp1=tmp1+"8";
							break;
 
				case 'p':	if(i==eingabe.length()-1 || (i<eingabe.length() && eingabe.charAt(i+1)!='h'))
							{
								tmp1=tmp1+"1";
							}
							else
							{
								tmp1=tmp1+"3";
							}
							break;
 
				case 'd':
				case 't':	if(i<eingabe.length()-1)
						{
							if(eingabe.charAt(i+1)!='c' && eingabe.charAt(i+1)!='s' && eingabe.charAt(i+1)!='z')
							{
								tmp1=tmp1+"2";
							}
							else
							{
								tmp1=tmp1+"8";
							}
						}
						else // "d" oder "t" ist der letzte Buchstabe im Wort 
						{
							tmp1=tmp1+"2";								
						}
						break;
 
				case 'x':	if(i>0)
						{
							if(eingabe.charAt(i-1)!='c' && eingabe.charAt(i-1)!='k' && eingabe.charAt(i-1)!='q')
							{
								tmp1=tmp1+"48";									
							}
							else
							{
								tmp1=tmp1+"8";
							}
						}
						else // "x" ist der erste Buchstabe im Wort
						{
							tmp1=tmp1+"48";
						}
						break;
 
				case 'c':	if(i>0)
						{
							if(eingabe.charAt(i-1)=='s' || eingabe.charAt(i-1)=='z')
							{
								tmp1=tmp1+"8";
							}
							else 
							{
								// Ist "c" der letzte Buchstabe?
								if(i<eingabe.length()-1)
								{
									switch(eingabe.charAt(i+1))
									{
										case 'a': 
										case 'h': 
										case 'k': 
										case 'o': 
										case 'q': 
										case 'u': 
										case 'x':	tmp1=tmp1+"4";
													break;
 
										default:	tmp1=tmp1+"8";
														break;
									}
								}
								else
								{
									tmp1=tmp1+"8";
								}
							}
						}
						else // "c" ist der erste Buchstabe im Wort
						{
							if(eingabe.length()>1)
							{
								switch(eingabe.charAt(i+1))
								{
									case 'a': 
									case 'h': 
									case 'k': 
									case 'l': 
									case 'o': 
									case 'q': 
									case 'r':
									case 'u': 
									case 'x':	tmp1=tmp1+"4";										  		break;
									default:	tmp1=tmp1+"8";
									break;
								}
							}
							else // das Wort besteht nur aus einem Buchstaben
							{
								tmp1=tmp1+"8";
							}
						}
						break;
			} // Ende der Switch-Anweisung
		} // Ende der Schleife
 
 
		// Entfernen der Nullen
		tmp2=tmp2+tmp2.valueOf(tmp1.charAt(0));
 
		for(int i=1; i<tmp1.length(); i++)
		{
			if(tmp1.charAt(i)!='0')
			{
				tmp2=tmp2+tmp2.valueOf(tmp1.charAt(i));
			}
		}
 
		tmp1="";
 
		// Entfernen von doppelten Zahlen
		if(tmp2.length()!=0)
		{
			tmp1=tmp1+tmp1.valueOf(tmp2.charAt(0));
		}
 
		for(int i=1; i<tmp2.length(); i++)
		{
			if(tmp2.charAt(i-1)!=tmp2.charAt(i))
			{
				tmp1=tmp1+tmp1.valueOf(tmp2.charAt(i));
			}
		}
 
		return tmp1;
	}
}
 