package client.command;

import java.io.IOException;

import client.Client;
import client.manager.ValueManager;
import client.utils.Utils;

public class Command {
	private String name;
	private String description;
	private int minArgs;
	private String help;
	private CommandType type;
	
	protected Utils utils = Utils.getInstance();
	protected ValueManager vm = Client.getInstance().getValuemanager();
	
	public void onCommand(String[] args) throws IOException {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinArgs() {
		return minArgs;
	}

	public void setMinArgs(int minArgs) {
		this.minArgs = minArgs;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public CommandType getType() {
		return type;
	}

	public void setType(CommandType type) {
		this.type = type;
	}

	public Command(String name, String description, int minArgs, String help, CommandType type) {
		super();
		this.name = name;
		this.description = description;
		this.minArgs = minArgs;
		this.help = help;
		this.type = type;
	}

	
}
