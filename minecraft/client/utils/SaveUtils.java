package client.utils;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import client.Client;
import client.manager.ModuleManager;
import client.manager.ValueManager;
import client.module.Module;
import client.value.Type;
import client.value.Value;

public class SaveUtils {
	private static SaveUtils instance;
	private Client client = Client.getInstance();
	private ValueManager valuemanager = client.getValuemanager();
	private ModuleManager modulemanager = client.getModulemanager();
	private Utils utils = Utils.getInstance();
	
	public static SaveUtils getInstance() {
		return instance == null ? instance = new SaveUtils() : instance;
	}

	private void createSaveDirIfNotExist() {
		File dir = new File(System.getenv("APPDATA") + File.separator + "client");
		if (!dir.exists())
			dir.mkdir();
	}
	
	private void createFileIfNotExist(File file) throws IOException {
		if (!file.exists())
			file.createNewFile();
	}
	
	private void saveContentToFile(String filename, String content) throws IOException {
		this.createSaveDirIfNotExist();
		File file = new File(System.getenv("APPDATA") + File.separator + "client" + File.separator + filename + ".txt");
		this.createFileIfNotExist(file);
		
		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
	}
	
	private List<String> getContentFromFile(String filename) throws IOException {
		this.createSaveDirIfNotExist();
		File file = new File(System.getenv("APPDATA") + File.separator + "client" + File.separator + filename + ".txt");
		
		if (file.exists()) {
			return Files.readAllLines(file.toPath());
		}
		
		return null;
	}
	
	public void saveValues() throws IOException {
		String content = "";
		
		for (Value v : valuemanager.getValues()) {
			if (!content.isEmpty())
				content += "\n";
			
			content += v.getName().name() + "=";
			
			if (v.getValue() instanceof String) {
				content += v.getValueAsString();
			}
		}
		
		this.saveContentToFile("values", content);
	}
	
	public void saveModules() throws IOException {
		String content = "";
		
		for (Module m : modulemanager.getModules()) {
			if (!content.isEmpty())
				content += "\n";
			
			content += m.getName();
		}
		
		this.saveContentToFile("modules", content);
	}
	
	public void loadValues() throws IOException {
		List<String> content = this.getContentFromFile("values");
		if (content != null) {
			for (String line : content) {
				String[] values = line.split("=");
				String type = values[0];
				String rawValue = values[1];
				
				if (!utils.isValueType(type))
					continue;
				
				Value value = utils.getValueByType(Type.valueOf(type));
				
				if (value.getValue() instanceof String) {
					value.setValue(rawValue);
				}
			}
		}
	}
	
	public void loadModules() throws IOException {
		List<String> content = this.getContentFromFile("modules");
		if (content != null) {
			for (String line : content) {
				utils.toggleModule(line);
			}
		}
	}
	
}
