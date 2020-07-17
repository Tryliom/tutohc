package client.manager;

import java.util.ArrayList;

import client.command.Command;
import client.command.commands.Help;
import client.command.commands.Prefix;

public class CommandManager {
	private ArrayList<Command> commands = new ArrayList<Command>();
	
	public CommandManager() {
		this.commands.add(new Help());
		this.commands.add(new Prefix());
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}
}
