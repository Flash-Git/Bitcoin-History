package dev.flash.bitcoinhistory;

/**
 * Created by Flash on 15/02/2017.
 */

public class Handler {
	public Instance instance;
	
	public Handler(Instance instance) {
		this.instance = instance;
	}
	
	public int getHeight(){
		return instance.getHeight();
	}
}
