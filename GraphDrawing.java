import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.lang.Math;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDrawing extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a button and place it in the scene
    // Create nodes as shapes of circle and text
    
//    int verticePos [][] = {
//	    {200+(int)Math.round(200*Math.random()),(int)Math.round(200*Math.random())}, 
//	    {(int)Math.round(200*Math.random()),200+(int)Math.round(200*Math.random())}, 
//	    {200+(int)Math.round(200*Math.random()),200+(int)Math.round(200*Math.random())}, 
//	    {400+(int)Math.round(200*Math.random()),200+(int)Math.round(200*Math.random())}, 
//	    {(int)Math.round(200*Math.random()),400+(int)Math.round(200*Math.random())}, 
//	    {200+(int)Math.round(200*Math.random()),400+(int)Math.round(200*Math.random())}, 
//	    {400+(int)Math.round(200*Math.random()),400+(int)Math.round(200*Math.random())}
//    };
    
    //make vertices for graph 1
    ArrayList<Vertex> adjListEmpty = new ArrayList<Vertex>(); //since we do not have all of the vertices made yet
    int [][] adjacencyList = {
    	{0,1,1,0,0,0,1},//1
	{1,0,0,1,1,0,0},//2
	{1,0,0,0,1,0,1},//3
	{0,1,0,0,0,1,0},//4
	{0,1,1,0,0,0,1},//5
	{0,0,0,1,0,0,1},//6
	{1,0,1,0,1,1,0},//7
    };
    Vertex vertex1 = new Vertex(
		    "1", //name of vertex
		    200, //random offset is added by the vertex class
		    0, //random offset is added by the vertex class
		    adjListEmpty, //defined above, lists vertices adjacent to this one
		    0 //not technically needed for first graph, but used to set height of node
		    );
    Vertex vertex2 = new Vertex("2",0,200,adjListEmpty,1);
    Vertex vertex3 = new Vertex("3",200,200,adjListEmpty,1);
    Vertex vertex4 = new Vertex("4",400,200,adjListEmpty,1);
    Vertex vertex5 = new Vertex("5",0,400,adjListEmpty,2);
    Vertex vertex6 = new Vertex("6",200,400,adjListEmpty,2);
    Vertex vertex7 = new Vertex("7",400,400,adjListEmpty,2);
    //create list of vertices
    ArrayList<Vertex> vertices = new ArrayList<Vertex>(Arrays.asList(vertex1,vertex2,vertex3,vertex4,vertex5,vertex6,vertex7));
    //set adjacency lists
    for (int i=0;i<adjacencyList.length;i++){
	int[] subList = adjacencyList[i];
	ArrayList<Vertex> vertexAdjList = new ArrayList<Vertex>();
    	for (int j=0;j<subList.length;j++){
		if (subList[j] == 1){
			vertexAdjList.add(vertices.get(j));
		}
	}
	//System.out.println("adjList: " + vertexAdjList.toString());	
	vertices.get(i).setAdjList(vertexAdjList);
    }
    //vertex1.setAdjList(new Vertex[] {vertex2,vertex3,vertex7});
    //vertex2.setAdjList(new Vertex[] {vertex4,vertex5});
    //vertex3.setAdjList(new Vertex[] {vertex5,vertex7});
    //vertex4.setAdjList(new Vertex[] {vertex6});
    //vertex5.setAdjList(new Vertex[] {vertex7});
    //vertex6.setAdjList(new Vertex[] {vertex7});
    //vertex7.setAdjList(adjList7);
    
    // Create a pane
    Pane pane = new Pane();
    
    //create circle for each vertex
    for (int i=0;i<vertices.size();i++){
	Vertex currentVertex = vertices.get(i);
	double radiusLength = 20.0;
    	Circle circle = new Circle();
	circle.setCenterX(currentVertex.getVertexX());
	circle.setCenterY(currentVertex.getVertexY());
	circle.setRadius((double)radiusLength);
	circle.setFill(Color.TRANSPARENT);
	circle.setStroke(Color.BLACK);
	circle.setStrokeWidth(3);
    	pane.getChildren().add(circle);
	
	//add vertex label
	Integer vertexNum = (Integer) i + 1;
	Text text = new Text();
	text.setText(currentVertex.getVertexName());
	text.setX(currentVertex.getVertexX());
	text.setY(currentVertex.getVertexY());
	pane.getChildren().add(text);

	//add edges
	ArrayList<Vertex> adjList = currentVertex.getAdjList();
	for (int j=0;j<adjList.size();j++){
		Line line = new Line(currentVertex.getVertexX(),currentVertex.getVertexY(),
				adjList.get(j).getVertexX(),adjList.get(j).getVertexY());
		pane.getChildren().add(line);		
	
	//add colors

	}
    }
    // Create edges that connect the nodes using lines
    //
    // Add the circle, text, and line nodes into the pane
    Scene scene = new Scene(pane, 600, 600);
    primaryStage.setTitle("Graph Drawing"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
 
    //Implement BFS to get layer number
    breadthFirstSearch(vertices);
    
    //make vertices for graph 2 (BFS)
    //Vertex bfs1 = new Vertex("1",200,0,adjListEmpty,0);
    //Vertex bfs2 = new Vertex("2",0,200,adjListEmpty,1);
    //Vertex bfs3 = new Vertex("3",200,200,adjListEmpty,1);
    //Vertex bfs4 = new Vertex("4",0,400,adjListEmpty,2);
    //Vertex bfs5 = new Vertex("5",200,400,adjListEmpty,2);
    //Vertex bfs6 = new Vertex("6",400,400,adjListEmpty,2);
    //Vertex bfs7 = new Vertex("7",400,200,adjListEmpty,1);
    //set adjacency lists
    //bfs1.setAdjList(new Vertex[] {bfs2,bfs3,bfs7});
    //bfs2.setAdjList(new Vertex[] {bfs4, bfs5});
    //bfs7.setAdjList(new Vertex[] {bfs6});
    //ArrayList<Vertex> bfsVertices = new ArrayList<Vertex>(Arrays.asList(bfs1,bfs2,bfs3,bfs4,bfs5,bfs6,bfs7));

    // Create a pane
    Pane bfsPane = new Pane();
    
    //create circle for each vertex
    for (int i=0;i<vertices.size();i++){
	Vertex currentVertex = vertices.get(i);
	double radiusLength = 20.0;
    	Circle circle = new Circle();
	circle.setCenterX(currentVertex.getVertexX());
	circle.setCenterY(currentVertex.getVertexY());
	circle.setRadius((double)radiusLength);
	circle.setFill(Color.TRANSPARENT);
	circle.setStrokeWidth(3);
    	bfsPane.getChildren().add(circle);
	
	//add vertex label
	Integer vertexNum = (Integer) i + 1;
	Text text = new Text();
	text.setText(currentVertex.getVertexName());
	text.setX(currentVertex.getVertexX());
	text.setY(currentVertex.getVertexY());
	bfsPane.getChildren().add(text);

	//add colors
	if (currentVertex.getLayerNum() == 0){
		circle.setStroke(Color.BLACK);
		text.setFill(Color.BLACK);
	}
	else if (currentVertex.getLayerNum() == 1){
		circle.setStroke(Color.RED);
		text.setFill(Color.RED);
	}
	else if (currentVertex.getLayerNum() == 2){
		circle.setStroke(Color.GREEN);
		text.setFill(Color.GREEN);
	}
	
	//add edges
	ArrayList<Vertex> adjList = currentVertex.getAdjList();
	for (int j=0;j<adjList.size();j++){
		Line line = new Line(currentVertex.getVertexX(),currentVertex.getVertexY(),
				adjList.get(j).getVertexX(),adjList.get(j).getVertexY());
		bfsPane.getChildren().add(line);		
	}
    }
    Stage bfsStage = new Stage();
    Scene bfsScene = new Scene(bfsPane, 600, 600);
    bfsStage.setTitle("BFS Tree Drawing");
    bfsStage.setScene(bfsScene);
    bfsStage.show();
  }


  public void breadthFirstSearch(ArrayList<Vertex> vertices)
  {
    //Implement BFS to get layer number
	//set all nodes to "undiscovered"
	for (int m=0;m<vertices.size();m++){
		vertices.get(m).setLayerNum(-1);
	}
	//create queue and set start point
    	Queue<Vertex> queue = new LinkedList<Vertex>();
	Vertex startPoint = vertices.get(0);
	//mark startPoint "discovered"
	startPoint.setLayerNum(0);
	//add startpoint to queue
	queue.add(startPoint);
	//discovered if layerNum <> -1
	while (queue.size() > 0){
		Vertex currentVertex = queue.remove();
		System.out.println("current vertex: " + currentVertex.getVertexName());
		ArrayList<Vertex> edgesToKeep = new ArrayList<Vertex>();
		for(int k=0;k<currentVertex.getAdjList().size();k++){
			//if node not discovered
			System.out.println("checking " + currentVertex.getVertexName() + " to " + currentVertex.getAdjList().get(k).getVertexName());
			if (currentVertex.getAdjList().get(k).getLayerNum() < 0){
				//add neighbor node to queue
				System.out.println("add to queue: " + currentVertex.getAdjList().get(k).getVertexName());
				queue.add(currentVertex.getAdjList().get(k));
				//set layer number for neighbor node
				currentVertex.getAdjList().get(k).setLayerNum(currentVertex.getLayerNum()+1);
				//update Ycoordinate of vertex to match layerNum
				currentVertex.getAdjList().get(k).setVertexY(200*(currentVertex.getLayerNum()+1));
				//discard edges that are not part of the BFS tree	
				edgesToKeep.add(currentVertex.getAdjList().get(k));
			}
		}
		currentVertex.setAdjList(edgesToKeep);
	}

  }
}
