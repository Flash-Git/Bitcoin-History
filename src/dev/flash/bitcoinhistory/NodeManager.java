package dev.flash.bitcoinhistory;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Flash on 15/02/2017.
 */

public class NodeManager {
	private Handler handler;
	private ArrayList<Node> nodes = new ArrayList<>();
	private Camera camera;
	private int spread, spreadP;
	
	public NodeManager(Handler handler) {
		this.handler = handler;
		this.camera = handler.getCamera();
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
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		int x = 15;
		
		int lines = 25;
		
		int low = (int) camera.getLow();
		int high = (int) camera.getHigh();
		spread = high - low;
		
		int lowP = 15;
		int highP = handler.getHeight() - 30;
		spreadP = highP - lowP;
		
		g.drawLine(15, lowP, 15, highP);
		
		for(int i = 0; i < lines + 1; i++) {
			int pY = i * handler.getHeight() / lines;//Pixel Coords height -> 0
			
			int nY = handler.getHeight() - pY;//Node Coords 0 -> heights
			nY = nY * (high - low) / handler.getHeight() + low;//Node Coords low -> high
			
			pY = pY * (highP - lowP) / handler.getHeight() + lowP;//Pixel Coords set to graph
			
			g.drawString(nY + "", x + 2, pY + 5);
			g.drawLine(x - 2, pY, x + 2, pY);
		}
		
		for(Node node : nodes) {
			x += 50;
			
			if(node.isBuy()) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.RED);
			}
			
			float nY = handler.getHeight() - (node.getRatio() - low) / spread * handler.getHeight();//Ratio from low -> high
			int pY = (int) (nY * spreadP / handler.getHeight() + lowP);//Ratio set to graph
			
			g.fillRect(x + 30, pY - 2, 4, 4);
			g.drawString(node.getRatio() + "", x + 13, pY - 5);
			g.drawString(node.getBits() + "", x + 15, pY + 17);
		}
	}
	
	//Getters and Setters
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public int getSpread() {
		return spread;
	}
	
	public int getSpreadP() {
		return spreadP;
	}
}
