package client.command.commands;

import java.io.IOException;

import client.command.Command;
import client.command.CommandType;
import client.enums.TargetMode;
import client.utils.SaveUtils;

public class KillAuraTargetMode extends Command {

	public KillAuraTargetMode() {
		super("killaura target", "Change le type de cible du KillAura", 3, "killaura target [Player:Mob:All]", CommandType.killaura);
	}
	
	public void onCommand(String[] args) throws IOException {
		vm.setKillAuraTargetMode(TargetMode.valueOf(args[2]));
		utils.sendChat("§aTarget du KillAura redéfinit à "+args[2]);
		SaveUtils.getInstance().saveValues();
	}
}
