/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.node.*;


import java.util.LinkedList;

/**
 *
 * @author Yanfa
 */
public class MapController {
    private LinkedList<Node> nodes;
    
    public MapController() {
		nodes = new XMLProcessor().loadFromXml("input.txt");
		
    }
    
    // Fungsi untuk mencari ruangan dengan nama roomName yang terdekat dari node
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
    
	// Fungsi untuk mengukur jarak terdekat dari Node B1 ke Node B2
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

	// Fungsi untuk mencari node-node terdekat yang harus dilewati jika dari Node B1 ke Node B2 
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

	public void addNode(Node node){
		nodes.add(node);
	}
}
