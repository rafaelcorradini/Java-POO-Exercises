import java.io.IOException;
import java.util.LinkedList;

public class Graph {
	private LinkedList<Vertex> vertices = new LinkedList<Vertex>();
	private LinkedList<Edge> edges = new LinkedList<Edge>();
	private int numVertices = 0;
	private int numEdges = 0;

	public static void main(String[] args) throws IOException {
		int op = 1;
		Graph g = new Graph();
		String print;
		int v1, v2;
		
		print = "1 - add vertex\n";
		print += "2 - add Edge\n";
		print += "3 - remove vertex\n";
		print += "4 - remove Edge\n";
		print += "5 - print Graph\n";
		print += "0 - exit";
		System.out.println(print);
		while (op != 0) {
			op = EntradaTeclado.leInt();
			switch(op) {
				case 1: System.out.print("vertice name: ");
						g.addVertex(EntradaTeclado.leString());
						break;
				case 2: System.out.print("vertice 1 id: ");
						v1 = EntradaTeclado.leInt();
						System.out.print("vertice 2 id: ");
						v2 = EntradaTeclado.leInt();
						System.out.print("Edge weight: ");
						g.addEdge(v1, v2, EntradaTeclado.leDouble());
						break;
				case 3: System.out.print("vertice id: ");
						g.removeVertex(EntradaTeclado.leInt());
						break;
						
				case 4: System.out.print("vertice 1 id: ");
						v1 = EntradaTeclado.leInt();
						System.out.print("vertice 2 id: ");
						v2 = EntradaTeclado.leInt();
						System.out.print("Edge weight: ");
						g.addEdge(v1, v2, EntradaTeclado.leDouble());
						break;

				case 5: System.out.println(g);
						break;
			}
		}
		EntradaTeclado.leString();
	}
	
	public Vertex getVertex(int id) {
		Vertex v;
		try{
			v = vertices.get(id);
		} catch(IndexOutOfBoundsException e) {
			v = null;
		}
		return v;
	}
	
	public Edge getEdge(int id) {
		Edge e;
		try{
			e = edges.get(id);
		} catch(IndexOutOfBoundsException a) {
			e = null;
		}
		return e;
	}
	
	public Vertex removeVertex(int id) {
		Vertex v;
		
		for(Edge e: edges) {	
			if(e.getV1() == id || e.getV2() == id)
				edges.set(e.getId(), null);
		}
		
		try{
			v = vertices.set(id, null);
			if(v != null)
				numVertices--;
			return v;
		} catch(IndexOutOfBoundsException a) {
			return null;
		}
	}
	
	public Edge removeEdges(int id) {
		Edge e;
		
		try{
			e = edges.set(id, null);
			if(e != null)
				numEdges--;
			return e;
		} catch(IndexOutOfBoundsException a) {
			return null;
		}
	}
	
	public boolean addVertex(String name) {
		Vertex v = new Vertex(vertices.size(), name);
		
		vertices.add(v);
		numVertices++;
		
		return true;
	}
	
	public boolean addEdge(int v1, int v2, double weight) {
		
//      trecho usado se não puder conter arestas com nomes iguais		
//		int i = 0;
		

//		for(Edge e: edges) {
//			if((e.getV1().equals(v1) && e.getV2().equals(v2)) || (e.getV2().equals(v1) && e.getV1().equals(v2)))	
//				return false;
//		}
		
//      usado se for grafo simples
//		for(Vertex v: vertices) {
//			if(v.getName().equals(v1) || v.getName().equals(v2)){
//				i++;
//			}
//				
//		}
//		if(i < 1){
//			return false;
//		}
		
		
		try{
			if(vertices.get(v1) == null || vertices.get(v2) == null)
				return false;
		} catch(IndexOutOfBoundsException e) {
			return false;
		}
		
		
		Edge e = new Edge(edges.size(), v1, v2, weight);
		
		edges.add(e);
		numEdges++;
		
		
		return true;
	}
	
	@Override
	public String toString() {
		String ret = "vertices: \n";
		for(Vertex v: vertices)
			if(v != null)
				ret += v.getId()+" - "+v.getName()+"\n";
		ret += "edges: \n";
		for(Edge e: edges)
			if(e != null)
				ret += e.getId()+" - weight: "+e.getWeight()+" ("+e.getV1()+" - "+e.getV2()+")"+"\n";
		
		
		return ret;
		
	}
}
