package client.manager;

import java.util.ArrayList;

import client.module.Module;
import client.module.modules.Sprint;

public class ModuleManager {
	private ArrayList<Module> modules = new ArrayList<Module>();

	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public ModuleManager() {
		this.modules.add(new Sprint());
	}
	
}
