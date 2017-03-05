package dev.flash.bitcoinhistory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Flash on 15/02/2017.
 */

public class NodeLoader {
	
	public static ArrayList<Node> readNodes(String path) {
		ArrayList<Node> nodes = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				String[] tokens = line.split("\\s+");
				nodes.add(new Node(Utils.parseBool(tokens[0]), Utils.parseFloat(tokens[1]), Utils.parseFloat(tokens[2])));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return nodes;
	}
	
	public static ArrayList<Node> readCoinFloorNodes(String path) {
		ArrayList<Node> nodes = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				String[] linetokens = line.split("\\s+");
				
				String newString = linetokens[2];
				String[] infoTokens = newString.split(",");
				//System.out.println(infoTokens[0] + ", " + infoTokens[1] + ", " + infoTokens[2] + ", " + infoTokens[3] + ", " + infoTokens[4] + ", " + infoTokens[5] + ", " + infoTokens[6]);
				//infoTokens[0] = timezone
				//infoTokens[1] = currency type (GBP)
				//infoTokens[2] = btc
				//infoTokens[3] = price
				//infoTokens[4] = GBP
				//infoTokens[5] = fee
				//infoTokens[6] = Buy/Sell
				
				
				nodes.add(new Node(Utils.parseBuySell(infoTokens[6]), Utils.parseFloat(infoTokens[4]), Utils.parseFloat(infoTokens[2])*1000));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return nodes;
	}
	
}
