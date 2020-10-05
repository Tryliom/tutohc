package client.command.commands;

import java.io.IOException;

import client.command.Command;
import client.command.CommandType;
import client.utils.SaveUtils;

public class KillAuraRange extends Command {

	public KillAuraRange() {
		super("killaura range", "Change la range du killaura", 3, "killaura range [Nombre de blocs]", CommandType.killaura);
	}
	
	public void onCommand(String[] args) throws IOException {
		vm.setKillAuraCps(Integer.parseInt(args[2]));
		utils.sendChat("§aRange du KillAura redéfinit à "+args[2]);
		SaveUtils.getInstance().saveValues();
	}
}
