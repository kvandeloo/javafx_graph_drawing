import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
	private String vertexName;
	private double vertexX;
	private double vertexY;
	//private String[] adjList; //list of names of nodes adjacent to this one
	private ArrayList<Vertex> adjList; //list nodes adjacent to this one
	private int layerNum;
	
	public Vertex(){} //no argument constructor
	//constructor		  
	public Vertex(String vertexName, double vertexX, double vertexY, ArrayList<Vertex> adjList, int layerNum){ 
		this.vertexName = vertexName;
		this.vertexX = vertexX + (int)Math.round(200*Math.random());
		this.vertexY = vertexY + (int)Math.round(200*Math.random());
		this.adjList = adjList; //list of names of nodes adjacent to this one
		this.layerNum = layerNum;
	}

	public String getVertexName(){
		return vertexName;
	}
	public double getVertexX(){
		return vertexX;
	}
	public double getVertexY(){
		return vertexY;
	}
	public ArrayList<Vertex> getAdjList(){
		return adjList;
	}
	public int getLayerNum(){
		return layerNum;
	}

	public void setVertexName(String vertexName){
		this.vertexName = vertexName;
	}
	public void setVertexX(double vertexX){
		this.vertexX = vertexX + (int)Math.round(200*Math.random());
	}
	public void setVertexY(double vertexY){
		this.vertexY = vertexY + (int)Math.round(200*Math.random());
	}
	public void setAdjList(ArrayList<Vertex> adjList){
		this.adjList = adjList;
	}
	public void setLayerNum(int layerNum){
		this.layerNum = layerNum;
	}
}
