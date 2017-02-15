package dev.flash.bitcoinhistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Flash on 15/02/2017.
 */

public class NodeLoader {

	public static ArrayList<Node> readNodes(String path){
		ArrayList<Node> nodes = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null){
				String[] tokens = line.split("\\s+");
				nodes.add(new Node(Utils.parseBool(tokens[0]), Utils.parseFloat(tokens[1]), Utils.parseFloat(tokens[2])));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return nodes;
	}
	
}
