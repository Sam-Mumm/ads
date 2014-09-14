/**
 * Die Klasse modeliert eine Adjazenzmatrix die sowohl für ungerichtete als
 * auch gerichtete Graphen verwendet werden kann
 * 
 * @author Dan Steffen
 * @version 0.1
 *
 */
public class Adjazenzmatrix
{
	int[][] matrix;
	boolean gerichtet=false;
	
	/**
	 * Konstruktor, erzeugt einen leeren Graphen
	 * @param n - Anzahl der Knoten im Graphen
	 * @param g - Indikator, ob es sich um einen (un-)gerichteten Graphen handelt
	 */
	public Adjazenzmatrix(int n, boolean g)
	{
		gerichtet=g;
		matrix=new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				matrix[i][j]=0;
			}
		}	
	}

	/**
	 * 
	 * @param n - Anzahl der Knoten im Graphen
	 */
	public Adjazenzmatrix(int n)
	{
		matrix=new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				matrix[i][j]=0;
			}
		}	
	}

	/**
	 * Setzt eine gewichtete Kante im Graphen
	 * @param von - Definiert den Startknoten im Graphen
	 * @param nach - Definiert den Endknoten im Graphen
	 * @param x - Definiert das Gewicht der Kante
	 */
	public void setEdge(int von, int nach, int x)
	{
		von=von-1;
		nach=nach-1;
		
		if(von<=matrix.length && nach<=matrix.length)
		{
			matrix[von][nach]=x;
			
			if(gerichtet==true)
			{
				matrix[nach][von]=x;
			}
		}
	}

	/**
	 * Setzt eine Kante im Graphen
	 * @param von - Definiert den Startknoten im Graphen
	 * @param nach - Definiert den Endknoten im Graphen
	 */
	public void setEdge(int von, int nach)
	{
		von=von-1;
		nach=nach-1;
		
		if(von<=matrix.length && nach<=matrix.length)
		{	
			matrix[von][nach]=1;
	
			if(gerichtet==true)
			{
			matrix[nach][von]=1;
			}
		}
	}

	/**
	 * Ausgabe der Matrix
	 */
	public void ausgabe()
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}