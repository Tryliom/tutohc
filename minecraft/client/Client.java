package client;

import java.io.IOException;

import client.manager.CommandManager;
import client.manager.ModuleManager;
import client.manager.ValueManager;
import client.utils.SaveUtils;

public class Client {
	private static Client instance = new Client();
	private ModuleManager modulemanager;
	private ValueManager valuemanager;
	private CommandManager commandmanager;
	
	public static Client getInstance() {
		return instance;
	}
	
	public void start() {
		System.out.println("Initialisation du client");
		this.modulemanager = new ModuleManager();
		this.valuemanager = new ValueManager();
		this.commandmanager = new CommandManager();
		try {
			SaveUtils.getInstance().loadModules();
			SaveUtils.getInstance().loadValues();
		} catch (IOException e) {
			System.out.println("Error while loading data: "+e.getMessage());
		}
	}

	public ModuleManager getModulemanager() {
		return this.modulemanager;
	}

	public ValueManager getValuemanager() {
		return valuemanager;
	}

	public CommandManager getCommandmanager() {
		return commandmanager;
	}
}
