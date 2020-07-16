package client.module.modules;

import org.lwjgl.input.Keyboard;

import client.module.Category;
import client.module.Module;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", Keyboard.KEY_K, Category.Movement);
	}
	
	public void onDisabled() {
		mc.thePlayer.setSprinting(false);
		super.onDisabled();
	}
	
	public void onUpdate() {
		mc.thePlayer.setSprinting(true);
	}
}
