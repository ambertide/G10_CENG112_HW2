/**
 * Implements the RAM
 */
package parts;

public class RAM implements IProduct {

	private String state; // Manufactured, stored or sold
	private boolean initalised;
	private String type = "RAM";
	
	public RAM() {
		this.state = "";
		this.initalised = true;
	}
	
	private void isInitalised() {
		if (!this.initalised) throw new IllegalAccessError();
	}
	
	/**
	 * Return if the state is valid
	 * @param state - Any string
	 * @return true if string is a valid state, "", "manufactured", "stored", "sold". else, false.
	 */
	private static boolean isValidState(String state) {
		return state.equals("manufactured") || state.equals("stored") || state.equals("sold") || state.equals("");
	}
	
	@Override
	public boolean isManufactured() {
		isInitalised();
		return isValidState(state) && (!state.equals(""));
	}

	@Override
	public boolean isStored() {
		isInitalised();
		return state.equals("stored");
	}

	@Override
	public boolean isSold() {
		isInitalised();
		return state.equals("sold");
	}
	
	@Override
	public String getType() {
		isInitalised();
		return this.type;
	}
	
	@Override
	public boolean setState(String state) {
		isInitalised();
		if (isValidState(state)) {
			this.state = state;
			return true;
		}
		return false;
	}

}
