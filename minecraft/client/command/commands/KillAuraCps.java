package client.command.commands;

import java.io.IOException;

import client.command.Command;
import client.command.CommandType;
import client.utils.SaveUtils;

public class KillAuraCps extends Command {

	public KillAuraCps() {
		super("killaura cps", "Change les coups par secondes du KillAura", 3, "killaura cps [Coups par secondes]", CommandType.killaura);
	}
	
	public void onCommand(String[] args) throws IOException {
		vm.setKillAuraCps(Integer.parseInt(args[2]));
		utils.sendChat("§aCps du KillAura redéfinit à "+args[2]);
		SaveUtils.getInstance().saveValues();
	}
}
