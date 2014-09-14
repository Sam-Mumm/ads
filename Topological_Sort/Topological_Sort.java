import java.util.*;

public class Topological_Sort
{	
	Procedure[] list;
	int[] dependencies;
	
	public Topological_Sort(int n)
	{
		list=new Procedure[n];
		dependencies=new int[n];
		
		for(int i=0; i<n; i++)
		{
			list[i]=null;
			dependencies[i]=0;
		}
	}
	
	// Definition von dem Prozess j der von i abhängt
	public void insert(int i, int j)
	{
		if(list[i-1]==null)
		{
			list[i-1]=new Procedure(j);
		}
		else
		{
			Procedure act=list[i-1];
			
			while(act.getNext()!=null)
			{
				act=act.getNext();
			}
			
			act.setNext(new Procedure(j));
		}
		dependencies[j-1]++;
	}

	public int[] topSort()
	{
		Queue<Integer> q=new LinkedList<Integer>();
		Procedure p=null;
		int index=0;
		int actNumber=-1;
		int[] output=new int[list.length];
		
		// Initialisierung der (leeren) Ausgabe
		for(int i=0; i<list.length; i++)
		{
			output[i]=-1;
		}

		for(int i=1; i<=dependencies.length; i++)
		{
			if(dependencies[i-1]==0)
			{
				q.offer(i);
			}
		}
		
		while(!q.isEmpty())
		{
			actNumber=q.poll();
			output[index]=actNumber;
			
			p=list[actNumber-1];
			
			while(p!=null)
			{
				dependencies[p.getNumber()-1]--;
				
				if(dependencies[p.getNumber()-1]==0)
				{
					q.offer(p.getNumber());
				}
				
				p=p.getNext();
			}
			
			index++;
		}
		
		return output;
	}
	
	public class Procedure
	{
		int number=-1;
		
		Procedure next=null;
		
		public Procedure(int n)
		{
			number=n;
		}

		public int getNumber()
		{
			return number;
		}
		
		public void setNumber(int n)
		{
			number=n;
		}
		
		public Procedure getNext()
		{
			return next;
		}
		
		public void setNext(Procedure n)
		{
			next=n;
		}		
	}
}