package client.manager;

import java.util.ArrayList;

import client.enums.Mode;
import client.enums.TargetMode;
import client.utils.Utils;
import client.value.Type;
import client.value.Value;

public class ValueManager {
	private ArrayList<Value> values = new ArrayList<Value>();
	
	private Utils utils = Utils.getInstance();

	public ValueManager() {
		this.values.add(new Value(Type.prefixCmd, ".."));
		this.values.add(new Value(Type.killAuraCps, 5));
		this.values.add(new Value(Type.killAuraMode, Mode.Single));
		this.values.add(new Value(Type.killAuraTarget, TargetMode.Player));
		this.values.add(new Value(Type.killAuraRange, 5));
	}

	public ArrayList<Value> getValues() {
		return values;
	}

	public void setPrefixCmd(String prefix) {
		utils.getValueByType(Type.prefixCmd).setValue(prefix);
	}
	
	public String getPrefixCmd() {
		return utils.getValueByType(Type.prefixCmd).getValueAsString();
	}
	
	public void setKillAuraCps(int cps) {
		utils.getValueByType(Type.killAuraCps).setValue(cps);
	}
	
	public int getKillAuraCps() {
		return utils.getValueByType(Type.killAuraCps).getValueAsInteger();
	}
	
	public void setKillAuraMode(Mode m) {
		utils.getValueByType(Type.killAuraMode).setValue(m);
	}
	
	public Mode getKillAuraMode() {
		return utils.getValueByType(Type.killAuraMode).getValueAsMode();
	}
	
	public void setKillAuraTargetMode(TargetMode m) {
		utils.getValueByType(Type.killAuraTarget).setValue(m);
	}
	
	public TargetMode getKillAuraTargetMode() {
		return utils.getValueByType(Type.killAuraTarget).getValueAsTargetMode();
	}
	
	public void setKillAuraRange(int range) {
		utils.getValueByType(Type.killAuraRange).setValue(range);
	}
	
	public int getKillAuraRange() {
		return utils.getValueByType(Type.killAuraRange).getValueAsInteger();
	}
}
