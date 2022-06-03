package chekk.santa.domains;

import java.util.ArrayList;

public class SantaDTO {
	private int hood_capacity;
	private ArrayList<Integer> present_weights;

	public int getHood_capacity() {
		return hood_capacity;
	}

	public void setHood_capacity(int hood_capacity) {
		this.hood_capacity = hood_capacity;
	}

	public ArrayList<Integer> getPresent_weights() {
		return present_weights;
	}

	public void setPresent_weights(ArrayList<Integer> present_weights) {
		this.present_weights = present_weights;
	}

}
