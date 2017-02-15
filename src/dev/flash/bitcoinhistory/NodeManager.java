package dev.flash.bitcoinhistory;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Flash on 15/02/2017.
 */

public class NodeManager {
    private ArrayList<Node> nodes = new ArrayList<>();

    public NodeManager() {

    }

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }

    public void removeNode(Node newNode) {
        for(Node node : nodes) {
            if(node.equals(newNode)) {
                nodes.remove(node);
            }
        }
    }

    public void tick(){
        
    }

    public void render(Graphics g){

    }

    //Getters and Setters
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}
