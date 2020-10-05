package client.manager;

import java.util.ArrayList;

import client.enums.Mode;
import client.value.Type;
import client.value.Value;

public class ValueManager {
	private ArrayList<Value> values = new ArrayList<Value>();

	public ValueManager() {
		this.values.add(new Value(Type.prefixCmd, ".."));
		this.values.add(new Value(Type.killAuraCps, 5));
		this.values.add(new Value(Type.killAuraMode, Mode.Single.name()));
	}

	public ArrayList<Value> getValues() {
		return values;
	}

}
