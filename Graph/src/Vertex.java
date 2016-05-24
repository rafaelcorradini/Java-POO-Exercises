public class Vertex {
	private String name;
	private int id;
	
//	public boolean areAdjacent(Vertex v) {
//		
//	}
	
	public Vertex(int n, String name) {
		this.name = name;
		this.id = n;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
//	public LinkedList incidentEdges(Vertex v) {
//		LinkedList<Edge> edges = new LinkedList<Edge>();
//		
//		for(Edge e: edges) {
//			if(e)
//		}
//	}
}
