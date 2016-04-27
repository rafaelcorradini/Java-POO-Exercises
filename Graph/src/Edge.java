
public class Edge {
	private int id;
	private int v1;
	private int v2;
	private double weight;
	
	public Edge(int id, int v1, int v2, double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}
	
	public int getId() {
		return id;
	}
	
	public void setWeight(double w) {
		weight = w;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getV1() {
		return v1;
	}
	
	public int getV2() {
		return v2;
	}
	
	public int getAdjacencyV1() {
		return v1;
	}
	
	public int getAdjacencyV2() {
		return v2;
	}
}
