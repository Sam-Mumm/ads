/**
 * Implementierung eines Binärbaumes
 * @author Dan Steffen
 * @version 0.1
 */
public class BinTree
{
	Node root=null;
	
	/**
	 * Überprüft ob der Baum leer ist
	 * @return liefert true falls der Baum leer ist, sonst false
	 */
	public boolean isEmpty()
	{
		if(root==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Sucht nach einem Schlüssel im Baum
	 * @param x zu Suchender Schlüssel
	 * @return liefert den gesuchten Schlüssel falls er existiert und sonst null 
	 */
	public Node search(int x)
	{
		Node akt=root;
		
		while(akt!=null)
		{
			if(akt.getValue()==x)
			{
				return akt;
			}
			else if(x<akt.getValue())
			{
				akt=akt.getLeftChild();
			}
			else
			{
				akt=akt.getRightChild();			
			}
		}
		
		return akt;
	}
	
	/**
	 * Fügt einen Schlüssel in den Baum ein
	 * @param x fügt den Schlüssel x in den Baum ein
	 */
	public void insert(int x)
	{
		Node prev=root;
		Node akt=root;
		
		if(root==null)
		{
			root=new Node(x);
		}
		else
		{
			// Suche nach dem Elter-Knoten für den neuen Knoten
			while(akt!=null)
			{
				prev=akt;
				
				// Verzweigung in den Baum
				if(x<akt.getValue())
				{
					akt=akt.getLeftChild();
				}
				else
				{
					akt=akt.getRightChild();					
				}
			}
			
			// Einfügen des Knotens
			if(x<prev.getValue())
			{
				prev.setLeftChild(new Node(x));
			}
			else
			{
				prev.setRightChild(new Node(x));				
			}
		
		}
	}
	
	/**
	 * Löscht einen Schlüssel aus dem Baum
	 * @param x löscht den Schlüssel x aus dem Baum
	 */
	public void delete(int x)
	{
		Node akt=root;
		Node prev=null;
		Node tmpNode=null;
		int tmpKey=-1;
		
		// Suche nach dem Knoten mit dem Datum x
		while(akt!=null && akt.getValue()!=x)
		{
			prev=akt;
			
			if(x<akt.getValue())
			{
				akt=akt.getLeftChild();
			}
			else
			{
				akt=akt.getRightChild();				
			}
		}
		
		
		if(akt!=null)
		{
			// Der zu löschende Knoten ist ein Blatt
			if(akt.getLeftChild()==null && akt.getRightChild()==null)
			{
				// Überprüfung ob der zu löschende Knoten linkes oder rechtes Kind vom Elterknoten ist
				if(x<prev.getValue())
				{
					prev.setLeftChild(null);
				}
				else
				{
					prev.setRightChild(null);					
				}
				
			}
			else if(akt.getLeftChild()==null && akt.getRightChild()!=null) // Es existiert ein rechtes Kind
			{
				// Überprüfung ob der zu löschende Knoten linkes oder rechtes Kind vom Elterknoten ist
				if(x<prev.getValue())
				{
					prev.setLeftChild(akt.getRightChild());
				}
				else
				{
					prev.setRightChild(akt.getRightChild());					
				}
			}
			else if(akt.getLeftChild()!=null && akt.getRightChild()==null) // Es existiert ein linkes Kind
			{
				// Überprüfung ob der zu löschende Knoten linkes oder rechtes Kind vom Elterknoten ist
				if(x<prev.getValue())
				{
					prev.setLeftChild(akt.getLeftChild());					
				}
				else
				{
					prev.setRightChild(akt.getLeftChild());										
				}				
			}
			else // Es existiert ein linkes und ein rechtes Kind
			{
				tmpNode=akt;
				
				prev=akt;
				akt=akt.getLeftChild();
				
				while(akt.getRightChild()!=null)
				{
					prev=akt;
					akt=akt.getRightChild();
				}
				
				// Tausch der Schlüssel
				tmpKey=tmpNode.getValue();
				tmpNode.setValue(akt.getValue());
				akt.setValue(tmpKey);
				
				if(akt.getLeftChild()==null && akt.getRightChild()==null)
				{
					if(prev.getLeftChild()!=null && prev.getLeftChild().getValue()==x)
					{
						prev.setLeftChild(null);
					}
					else
					{
						prev.setRightChild(null);						
					}
				}
				else if(akt.getLeftChild()==null && akt.getRightChild()!=null)
				{
					if(prev.getLeftChild()!=null && prev.getLeftChild().getValue()==x)
					{
						prev.setLeftChild(akt.getRightChild());
					}
					else
					{
						prev.setRightChild(akt.getRightChild());						
					}
				}
				else if(akt.getLeftChild()!=null && akt.getRightChild()==null)
				{
					if(prev.getLeftChild()!=null && prev.getLeftChild().getValue()==x)
					{
						prev.setLeftChild(akt.getLeftChild());
					}
					else
					{
						prev.setRightChild(akt.getLeftChild());						
					}
				}
			}
		}
	}
	
	/**
	 * Tiefensuche auf dem Baum
	 */
	public void dfs()
	{
		this.dfs(root);
	}
	
	/**
	 * Tiefensuche auf dem Baum mit einem konkreten Startknoten
	 * @param akt Startknoten für die Tiefensuche
	 */
	private void dfs(Node akt)
	{
		// Falls der Knoten nocht nicht betrachtet worden ist
		if(!akt.isVisited())
		{
			akt.isVisited();
			System.out.print("Betrachteter Knoten "+akt.getValue());
			
			// Ausgabe des Linken Kindes, falls vorhanden
			if(akt.getLeftChild()!=null)
			{
				System.out.println();
				System.out.print("linkes Kind: "+akt.getLeftChild().getValue());
			}
			
			// Ausgabe des rechten Kindes falls vorhanden
			if(akt.getRightChild()!=null)
			{
				System.out.println();
				System.out.println("rechtes Kind: "+akt.getRightChild().getValue());				
			}
			
			if(akt.getLeftChild()==null && akt.getRightChild()==null)
			{
				System.out.println(": Blatt");
			}
			System.out.println();
		}

		// Besuch des linken Kindes falls es noch nicht betrachtet worden ist
		if(akt.getLeftChild()!=null && akt.getLeftChild().isVisited()==false)
		{
			this.dfs(akt.getLeftChild());
		}
		
		// Besuch des rechten Kindes falls noch nicht betrachtet worden ist
		if(akt.getRightChild()!=null && akt.getRightChild().isVisited()==false)
		{
			this.dfs(akt.getRightChild());
		}
		
		return;
	}
	
	class Node
	{
		Node leftChild=null;
		Node rightChild=null;
		int value=-1;
		boolean visited=false;

		/**
		 * Erzeugt einen neune Knoten für den Baum
		 * @param x
		 */
		public Node(int x)
		{
			value=x;
		}
		
		/**
		 * Liefert die Referenz auf das linke Kind
		 * @return linker Knoten falls er existiert sonst null
		 */
		public Node getLeftChild()
		{
			return leftChild;
		}
		
		/**
		 * Setzt die Referenz für ein linkes Kind
		 * @param leftChild zu setzende Referenz auf das linke Kind
		 */
		public void setLeftChild(Node leftChild)
		{
			this.leftChild = leftChild;
		}
		
		/**
		 * Liefert die Referenz auf das rechte Kind
		 * @return rechter Knoten falls er existiert sonst null
		 */
		public Node getRightChild()
		{
			return rightChild;
		}

		/**
		 * Setzt die Referenz für ein rechte Kind
		 * @param leftChild zu setzende Referenz auf das rechte Kind
		 */
		public void setRightChild(Node rightChild)
		{
			this.rightChild = rightChild;
		}
		
		/**
		 * Liefert den Schlüssel des Knoten
		 * @return Schlüssel des Knoten
		 */
		public int getValue()
		{
			return value;
		}
		
		/**
		 * Setzt den Schlüssel für den Knoten
		 * @param value neuer Schlüssel des Knoten
		 */
		public void setValue(int value)
		{
			this.value = value;
		}
		
		/**
		 * Liefert eine Auskunft darüber ob der Knoten bei einem DFS durchlauf bereits besucht wurde
		 * @return liefert true falls der Knoten besuchtwurde und sonst false
		 */
		public boolean isVisited()
		{
			return visited;
		}

		/**
		 * Definiert ob der Knoten bereits einmal besucht wurde
		 * @param visited Übergabe ob der Knoten bereits einmal besucht wurde
		 */
		public void setVisited(boolean visited)
		{
			this.visited = visited;
		}

	}
}