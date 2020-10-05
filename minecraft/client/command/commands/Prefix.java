package client.command.commands;

import java.io.IOException;

import client.command.Command;
import client.command.CommandType;
import client.utils.SaveUtils;
import client.value.Type;

public class Prefix extends Command {

	public Prefix() {
		super("prefix", "Change le prefix des commandes", 2, "prefix [Nouveau pr�fix]", CommandType.Other);
	}
	
	public void onCommand(String[] args) throws IOException {
		vm.setPrefixCmd(args[1]);
		utils.sendChat("�aPr�fix red�finit en "+args[1]);
		SaveUtils.getInstance().saveValues();
	}
}
