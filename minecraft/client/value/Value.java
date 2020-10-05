package client.value;

import client.enums.Mode;
import client.enums.TargetMode;

public class Value {
	private Type name;
	private Object value;
	
	public Value(Type name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}
	public Type getName() {
		return name;
	}
	public void setName(Type name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

	public String getValueAsString() {
		return (String) this.value;
	}
	
	public Integer getValueAsInteger() {
		return (Integer) this.value;
	}

	public Float getValueAsFloat() {
		return (Float) this.value;
	}
	
	public Mode getValueAsMode() {
		return (Mode) this.value;
	}
	
	public TargetMode getValueAsTargetMode() {
		return (TargetMode) this.value;
	}
}
