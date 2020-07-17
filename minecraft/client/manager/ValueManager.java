package client.manager;

import java.util.ArrayList;

import client.value.Type;
import client.value.Value;

public class ValueManager {
	private ArrayList<Value> values = new ArrayList<Value>();

	public ValueManager() {
		this.values.add(new Value(Type.prefixCmd, ".."));
	}

	public ArrayList<Value> getValues() {
		return values;
	}

}
