package client.command.commands;

import java.util.ArrayList;

import client.command.Command;
import client.command.CommandType;
import client.value.Type;

public class Help extends Command {

	public Help() {
		super("help", "Affiche l'aide pour les commandes", 1, "help [Nom de cheat]", CommandType.Other);
	}
	
	public void onCommand(String[] args) {
		ArrayList<Command> list = new ArrayList<Command>();
		String prefix = utils.getValueByType(Type.prefixCmd).getValueAsString();
		
		if (args.length == 1) {
			list = utils.getCommandByType(CommandType.Other);
		} else if (CommandType.valueOf(args[1].toLowerCase()) != null) {
			list = utils.getCommandByType(CommandType.valueOf(args[1].toLowerCase()));
		} else {
			utils.sendChat("§cCette aide n'existe pas");
		}
		
		for (Command cmd : list) {
			utils.sendChat(prefix + cmd.getHelp() + ": " + cmd.getDescription());
		}
	}

}
