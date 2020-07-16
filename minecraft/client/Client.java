package client;

import client.manager.ModuleManager;

public class Client {
	private static Client instance = new Client();
	private ModuleManager modulemanager;
	
	public static Client getInstance() {
		return instance;
	}
	
	public void start() {
		System.out.println("Initialisation du client");
		this.modulemanager = new ModuleManager();
	}

	public ModuleManager getModulemanager() {
		return modulemanager;
	}
}
