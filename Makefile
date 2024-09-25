runGraph: GraphDrawing.class Vertex.class
	java --module-path javafx/lib --add-modules javafx.controls GraphDrawing
GraphDrawing.class: GraphDrawing.java
	javac --module-path javafx/lib --add-modules javafx.controls GraphDrawing.java
Vertex.class: Vertex.java
	javac Vertex.java
