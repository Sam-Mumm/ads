
public class Floyd_Warshall
{
	int[][] matrix;
	int[][] act;
	
	public Floyd_Warshall(int n)
	{
		matrix=new int[n][n];
		act=new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				matrix[i][j]=999999;
				act[i][j]=999999;
			}
		}
	}
	
	public Floyd_Warshall(int[][] m)
	{
		matrix=m;
		act=m;
	}
	
	public void insert(int x, int y, int w)
	{
		act[x-1][y-1]=w;
	}
	
	public void apsp()
	{
		int n=matrix.length;
		
		for(int k=0; k<n; k++)
		{
			for(int i=0; i<n; i++)
			{
				for(int j=0, temp=0; j<n; j++)
				{
					temp=act[i][k]+act[k][j];
						
					if(temp < act[i][j])
					{
						matrix[i][j]=temp;
					}
					else
					{
						matrix[i][j] = act[i][j];
					}

				}
			}
			act=matrix;
		}
	}
	
	public void output()
	{
		for(int i=0; i<matrix.length; i++)
		{
			for(int j=0; j<matrix.length; j++)
			{
				if(matrix[i][j]>=999999)
				{
					System.out.print("∞\t");					
				}
				else
				{
					System.out.print(matrix[i][j]+"\t");										
				}
			}
			System.out.println();
		}
	}	
	
	public int[][] getMatrix()
	{
		return matrix;
	}	
}