/**
 * Implementierung des Kruskal Algorithmus zur Ermittelung von Minimalenspann Bäumen
 * @author Dan Steffen
 * @version 0.1
 */
public class Kruskal
{
	int[][] matrix;				// Adjazenzmatrix
	int[][] mst;					// Minimaler Spannbaum
	int[] sets;						// Menge der Knoten
	Edge[] edges;					// Menge der Kanten
	int counter=0;					// Anzahl der Kanten im Graphen
	
	/**
	 * Erzeugt einen leeren ungerichteten Graphen mit n Knoten
	 * @param n - Anzahl der Knoten im Graphen
	 */
	public Kruskal(int n)
	{
		matrix=new int[n][n];
		sets=new int[n];

		for(int i=1; i<=n; i++)
		{
			sets[i-1]=i;
			
			for(int j=0; j<n; i++)
			{
				matrix[i-1][j]=0;
				mst[i-1][j]=0;
			}
		}
		
		edges=new Edge[n*n];
	}

	/**
	 * Einfügen einer ungerichteten Kante
	 * @param from - Start / End-Knoten
	 * @param to - Start / End-Knoten
	 * @param weight - Gewicht der Kante
	 */
	public void insert(int from, int to, int weight)
	{
		matrix[from-1][to-1]=weight;
		matrix[to-1][from-1]=weight;
	
		// Einfügen einer Kante in die Liste
		edges[counter]=new Edge(from, to, weight);
		counter++;
	}

	
	/**
	 * Sortierung der Kanten anhand ihres Gewichtes mittels Inserationsort
	 */
	private void sort()
	{
		int j=-1;
		Edge tmp=null;
		
		for(int i=1; i<counter; i++)
		{
			j=i;
			
			while(j>=1 && edges[j-1].getWeight()>edges[j].getWeight())
			{
				tmp=edges[j];
				edges[j]=edges[j-1];
				edges[j-1]=tmp;
				
				j=j-1;
			}
		}
	}
		
	/**
	 * Algorithmus von Kruskal zur Ermittelung eines minimalen Spannbaumes
	 */
	public void mst()
	{
		Edge akt=null;
		
		// Sortieren der Kanten nach ihrem Gewicht
		this.sort();
		
		for(int i=0; i<=counter; i++)
		{
			akt=edges[i];
	
			// Würde die aktuelle Kante einen Kreis schließen
			if(sets[akt.getFrom()-1]!=sets[akt.getTo()-1])
			{
				sets[akt.getTo()-1]=sets[akt.getFrom()-1];

				// Einfügen der Kante in den Spannbaum
				mst[akt.getFrom()-1][akt.getTo()-1]=akt.getWeight();
				mst[akt.getTo()-1][akt.getFrom()-1]=akt.getWeight();
			}
		}
	}

	/**
	 * Ausgabe des minimalen Spannbaums
	 */
	public void outputMST()
	{
		for(int i=1; i<=mst.length; i++)
		{
			System.out.print("Der Knoten "+i+" ist verbunden mit: ");
			
			for(int j=1; j<=mst.length; j++)
			{
				if(mst[i-1][j-1]!=0)
				{
					System.out.println(j+"("+mst[i-1][j-1]+") ");
				}
			}
		}
	}
	
	/**
	 * Ausgabe des Graphen
	 */
	public void outputGraph()
	{
		for(int i=1; i<=matrix.length; i++)
		{
			System.out.print("Der Knoten "+i+" ist verbunden mit: ");
			
			for(int j=1; j<=matrix.length; j++)
			{
				if(mst[i-1][j-1]!=0)
				{
					System.out.println(j+"("+matrix[i-1][j-1]+") ");
				}
			}
		}
	}
	
	class Edge
	{
		int from=-1;
		int to=-1;
		int weight=-1;

		/**
		 * Erzeugt eine Kante zwischen zwei Knoten
		 * @param from - Startknoten
		 * @param to - Endknoten
		 * @param weight - Gewicht der Kante
		 */
		public Edge(int from, int to, int weight)
		{
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		/**
		 * Liefert den Startknoten
		 * @return Startknoten
		 */
		public int getFrom()
		{
			return from;
		}
		
		/**
		 * Setzt den Startknoten
		 * @param from - Startknoten
		 */
		public void setFrom(int from)
		{
			this.from = from;
		}
		
		/**
		 * Liefert den Endknoten
		 * @return Endknoten
		 */
		public int getTo()
		{
			return to;
		}
		
		/**
		 * Setzt den Endknoten
		 * @param to - Endknoten
		 */
		public void setTo(int to)
		{
			this.to = to;
		}
		
		/**
		 * Liefert das Gewicht der Kante
		 * @return Gewicht der Kante
		 */
		public int getWeight()
		{
			return weight;
		}
		
		/**
		 * Setzt das Gewicht der Kante
		 * @param weight - Gewicht der Kante
		 */
		public void setWeight(int weight)
		{
			this.weight = weight;
		}
	}
}