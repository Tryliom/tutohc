package client.command.commands;

import java.io.IOException;

import client.command.Command;
import client.command.CommandType;
import client.enums.Mode;
import client.utils.SaveUtils;

public class KillAuraMode extends Command {

	public KillAuraMode() {
		super("killaura mode", "Change le mode pour taper au killaura, une seule cible ou toutes", 3, "killaura mode [Single:Multi]", CommandType.killaura);
	}
	
	public void onCommand(String[] args) throws IOException {
		vm.setKillAuraMode(Mode.valueOf(args[2]));
		utils.sendChat("§aMode du KillAura redéfinit à "+args[2]);
		SaveUtils.getInstance().saveValues();
	}
}
