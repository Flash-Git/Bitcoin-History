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
		int x = 0;
		
		int lines = 25;
		
		int low = (int)camera.getLow();
		int high = (int)camera.getHigh();
		int spread = high - low;
		
		int lowP = 15;
		int highP = handler.getHeight() - 30;
		int spreadP = highP - lowP;
		
		g.drawLine(15, highP, 15, lowP);
		
		for(int i = 0; i < lines+1; i++) {
			g.drawString(handler.getHeight() / spreadP * spread - (spread / (lines) * i) + low + "", 16, spreadP / (lines) * i + lowP + 5);
			//g.drawString("fu", 15, spread / spreadP * (i * lines) + highP);
			g.drawLine(13, (highP - lowP) / (lines) * i + lowP, 17, (highP - lowP) / (lines) * i + lowP);
		}
		
		for(Node node : nodes) {
			if(node.isBuy()) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.RED);
			}
			x += 50;
			//int y = (int) (spreadP + lowP - (handler.getHeight() * - spreadP / spread + (node.getRatio() * spreadP / spread)));
			
			int y = (high - (int) node.getRatio())*spreadP/spread+lowP;
			
			g.drawRect(x + 30, y, 2, 2);
			g.drawString(node.getRatio() + "", x + 13, y - 5);
			g.drawString(node.getBits() + "", x + 15, y + 17);
		}
	}
	
	//Getters and Setters
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
}
