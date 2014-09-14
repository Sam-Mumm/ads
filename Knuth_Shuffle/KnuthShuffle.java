import java.util.Random;


public class KnuthShuffle
{	
	public int[] shuffle(int from, int to)
	{
		int[] v;
		int length=to-from+1;
		Random rm=new Random();
		
		v=new int[length];
		
		for(int i=0; i<length; i++)
		{
			v[i]=from;
			from++;
		}
		
		for(int i=0, tmp=0, rn=0; i<v.length; i++)
		{
			rn=rm.nextInt(length);
			tmp=v[i];
			v[i]=v[rn];
			v[rn]=tmp;			
		}
		
		return v;
	}
}
