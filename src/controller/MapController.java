/**
 * A class which represent a room on building.
 * @author created by : Yanfa Adi Putra
 * @since 1.5
 * @version 1.1
 */
package controller;

import model.node.*;
import model.room.*;
import java.util.LinkedList;


public class MapController {
    private LinkedList<Node> nodes;
	
    /**
     * Constructs and initializes a map controller with data from a file
     * @since 1.0
     */
    public MapController(String fileName) {
		try{
			nodes = (LinkedList<Node> )XMLProcessor.loadFromXml(fileName);
		}
		catch(Exception e){}
	}
    
    /**
     * Get the nearest room that fulfill some specified parameter.
     * @param node is a node where the initial node is
	 * @param roomName is a string that define the room name that want to be searched
     * @since 1.0
     */
	public Node nearestRoom(Node node, String roomName){
		Building building;
		int nearestRR = -1;
		for(int i = 0; i < nodes.size(); i++){
			if(nodes.get(i) instanceof Building){
				building = (Building)nodes.get(i);
				if(building.searchRoom(roomName)){
					if(nearestRR == -1){
						nearestRR = i;
					}
					else{
						if(getDistance(node, nodes.get(i)) < getDistance(node, nodes.get(nearestRR))){
							nearestRR = i;
						}
					}
				}
			}
		}
		return nodes.get(nearestRR);
    }
    
	/**
     * Get the nearest canteen
     * @param node is a node where the initial node is defined
     * @since 1.0
     */
	public Node nearestCanteen(Node node){
		Canteen canteen;
		int nearestRR = -1;
		for(int i = 0; i < nodes.size(); i++){
			if(nodes.get(i) instanceof Canteen){
				canteen = (Canteen)nodes.get(i);
				if(nearestRR == -1){
					nearestRR = i;
				}
				else{
					if(getDistance(node, nodes.get(i)) < getDistance(node, nodes.get(nearestRR))){
						nearestRR = i;
					}
				}
			}
		}
		return nodes.get(nearestRR);
    }
    
	/**
     * Get the nearest rest room
     * @param node is a node where the initial node is defined
     * @since 1.0
     */
	public Node nearestRestRoom(Node node){
		Building building;
		int nearestRR = -1;
		for(int i = 0; i < nodes.size(); i++){
			if(nodes.get(i) instanceof Building){
				building = (Building)nodes.get(i);
				for(int j = 0; j < building.getListOfRooms().size(); j++){
					if(building.getListOfRooms().get(j) instanceof Restroom){
						if(nearestRR == -1){
							nearestRR = i;
						}
						else{
							if(getDistance(node, nodes.get(i)) < getDistance(node, nodes.get(nearestRR))){
								nearestRR = i;
							}
						}
					}
				}
			}
		}
		return nodes.get(nearestRR);
    }
    
	/**
     * Get the distance of path between two node.
     * @param B1 is define initial node
	 * @param B2 is define the target node
     * @since 1.0
     */
	private double getDistance(Node B1, Node B2){
		LinkedList<Double> jarak = new LinkedList<>(); // jarak dari masing-masing node dari node B1
		LinkedList<Integer> nextNode = new LinkedList<>(); // list penampung titik yang belum dikunjungi
		double temp; // temporary variable
		for(int i = 0; i < nodes.size(); i++){
			if(i == B1.getID()){
				jarak.add(0.0); // jarak = 0 untuk node awal
			}
			else{
				jarak.add(99999999.0);
			}
		}
		nextNode.add(B1.getID());		
		// for (double jarak1 : jarak) {
		for(int i = 0; i < nextNode.size() - 1; i++){
			temp = 0;
			for(int j = 0; j < nodes.get(nextNode.get(i)).getListOfNeighbours().size(); j++){
				if(!nextNode.contains(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j))){
					nextNode.add(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j));
				}
				temp = jarak.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)) +
						nodes.get(nextNode.get(i)).getLocation().distance(nodes.get(
						nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).getLocation());
				if(temp < jarak.get(nodes.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).getID())){
					jarak.set(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j), temp);
				}
			}
		}
		return jarak.get(B2.getID());
    }
	
	/**
     * Get the direction in this case is path of node between two node.
     * @param B1 is define initial node
	 * @param B2 is define the target node
     * @since 1.0
     */
	public LinkedList<Integer> getDirection(Node B1, Node B2){
		LinkedList<LinkedList<Integer>> path = new LinkedList<>();
		LinkedList<Double> jarak = new LinkedList<>(); // jarak dari masing-masing node dari node B1
		LinkedList<Integer> nextNode = new LinkedList<>(); // list penampung titik yang belum dikunjungi
		double temp; // temporary variable
		for(int i = 0; i < nodes.size(); i++){
			if(i == B1.getID()){
				jarak.add(0.0); // jarak = 0 untuk node awal
			}
			else{
				jarak.add(99999999.0);
			}
		}
		for(int i = 0; i < nodes.size(); i++){
			path.add(new LinkedList<Integer>());
		}
		nextNode.add(B1.getID());
		path.get(B1.getID()).add(B1.getID());
		// for (double jarak1 : jarak) {
		for(int i = 0; i < nextNode.size() - 1; i++){
			temp = 0;
			for(int j = 0; j < nodes.get(nextNode.get(i)).getListOfNeighbours().size(); j++){
				if(!nextNode.contains(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j))){
					nextNode.add(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j));
				}
				temp = jarak.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)) +
						nodes.get(nextNode.get(i)).getLocation().distance(nodes.get(
						nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).getLocation());
				if(temp < jarak.get(nodes.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).getID())){
					jarak.set(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j), temp);
					path.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).clear();
					for (Integer p : path.get(nextNode.get(i))) {
						path.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j)).add(p);
					}
					path.get(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j))
							.add(nodes.get(nextNode.get(i)).getListOfNeighbours().get(j));
				}
			}
		}
		return path.get(B2.getID());
	}
	
	/**
     * Add another node to the map
     * @param node is define the node that want to be added
	 * @since 1.0
     */
	public void addNode(Node node){
		nodes.add(node);
	}
}
