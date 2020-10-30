
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Grafo { 
	class Arista { //Se crea la clase arista para poder usar mejor los datos de esta.
		int ini, dest, peso; 
		Arista() 
		{ 
			ini = dest = peso = 0; 
		} 
	}; 

	int V, A; 
	Arista arista[]; 

	Grafo(int v, int e) 
	{  // Se crea el grafo que contendrán los valores para el bellman-ford
		V = v; 
		A = e; 
		arista = new Arista[e]; 
		for (int i = 0; i < e; ++i) 
			arista[i] = new Arista(); 
	} 

	
	void BellmanFord(Grafo grafo, int ini) //Se crea la funcion bellman ford para poder calcular el mejor camino de la funcion
	{  
		int V = grafo.V, A = grafo.A; 
		int dist[] = new int[V]; 		
		for (int i = 0; i < V; ++i){
			dist[i] = Integer.MAX_VALUE; 
                }
		dist[ini] = 0; 

		for (int i = 1; i < V; ++i) { 
			for (int j = 0; j < A; ++j) { 
				int u = grafo.arista[j].ini; 
				int v = grafo.arista[j].dest; 
				int peso = grafo.arista[j].peso; 
				if (dist[u] != Integer.MAX_VALUE && dist[u] + peso < dist[v]){
                                    dist[v] = dist[u] + peso; 
                                }
					
			} 
		} 

		for (int j = 0; j < A; ++j) { 
			int u = grafo.arista[j].ini; 
			int v = grafo.arista[j].dest; 
			int peso = grafo.arista[j].peso; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + peso < dist[v]) { 
				System.out.println("Grafo contiene pesos negativos."); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	// Imprimir el arreglo
	void printArr(int dist[], int V) 
	{ 
		System.out.println("Vertice || Distancia"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t"+" || "+"\t" + dist[i]); 
	} 

	
	public static void main(String[] args) throws IOException 
	{ 
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Ingresar cantidad de vértices: ");//Se pide los vertices
                String vertice = in.readLine();
                int V = Integer.parseInt(vertice);
		System.out.println("Ingresar cantidad de aristas: ");//Se pide las aristas
		String arista = in.readLine();
                int A = Integer.parseInt(arista);
		Grafo grafo = new Grafo(V, A); 
                int cantAristas = A;// Se guarda la variable para poder usarla en la siguiente parte
                for(int i=0;i<cantAristas;i++){ //Se empieza a pedir los valores para rellenar el grafo(Inicio, final, peso)
                    System.out.println("Ingresar vertice origen: ");
                    String inicio = in.readLine();
                    int origen = Integer.parseInt(inicio);
                    grafo.arista[i].ini=origen;
                    System.out.println("Ingresar vertice destino: ");
                    String fin = in.readLine();
                    int destino = Integer.parseInt(fin);
                    grafo.arista[i].dest=destino;
                    System.out.println("Ingresar peso de la arista: ");
                    String peso = in.readLine();
                    int carga = Integer.parseInt(peso);
                    grafo.arista[i].peso=carga;
                }

		grafo.BellmanFord(grafo, 0); 
	} 
} 

