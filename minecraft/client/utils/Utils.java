package client.utils;

import java.io.IOException;
import java.util.ArrayList;

import client.Client;
import client.command.Command;
import client.command.CommandType;
import client.manager.CommandManager;
import client.manager.ModuleManager;
import client.manager.ValueManager;
import client.module.Module;
import client.value.Type;
import client.value.Value;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.ChatComponentText;

public class Utils {
	private static Utils instance = new Utils();
	private Minecraft mc = Minecraft.getMinecraft();
	private Client client = Client.getInstance();
	private ValueManager valuemanager = client.getValuemanager();
	private ModuleManager modulemanager = client.getModulemanager();
	
	public static Utils getInstance() {
		return instance;
	}
	
	public void sendChat(String text) {
		if (mc.ingameGUI != null)
			mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[Client] "+text));
	}
	
	public Value getValueByType(Type name) {
		for (Value value : valuemanager.getValues()) {
			if (value.getName().equals(name)) {
				return value;
			}
		}
		return null;
	}
	
	public Boolean isValueType(String name) {
		try {
			Type.valueOf(name);
			return true;
		} catch (Exception e) {}
		return false;
	}
	
	public void toggleModule(String name) throws IOException {
		for (Module m : modulemanager.getModules()) {
			if (m.getName().equalsIgnoreCase(name))
				m.toggle(!m.isToggled());
		}
	}
	
	public ArrayList<Command> getCommandByType(CommandType type) {
		CommandManager commandManager = client.getCommandmanager();
		ArrayList<Command> list = new ArrayList<Command>();
		for (Command cmd : commandManager.getCommands()) {
			if (cmd.getType().equals(type))
				list.add(cmd);
		}
		
		return list;
	}
	
	public Command getCommandStartByName(String name) {
		CommandManager commandManager = client.getCommandmanager();
		for (Command cmd : commandManager.getCommands()) {
			if (name.startsWith(cmd.getName())) 
				return cmd;
		}
		
		return null;
	}
	
	public void onCommand(String message) throws IOException {
		Command cmd = this.getCommandStartByName(message);
		String[] args = message.split(" ");
		
		if (cmd != null) {
			
			if (args.length < cmd.getMinArgs()) {
				this.sendChat("§cErreur, il manque des arguments");
			} else {
				cmd.onCommand(args);
			}
			
		} else {
			this.sendChat("§cCommande inexistante !");
		}
	}
	
	public void attackEntity(Entity en) {
		mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(en, C02PacketUseEntity.Action.ATTACK));
	}
}










