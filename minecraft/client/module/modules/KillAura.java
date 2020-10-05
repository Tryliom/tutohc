package client.module.modules;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import org.lwjgl.input.Keyboard;

import client.Client;
import client.enums.Mode;
import client.enums.TargetMode;
import client.manager.ValueManager;
import client.module.Category;
import client.module.Module;
import client.utils.Utils;
import client.value.Type;
import client.value.Value;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class KillAura extends Module {
	private Timer timer = new Timer(1000, new attack());
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_V, Category.Combat);
	}
	
	public void onEnabled() {
		int cps = Utils.getInstance().getValueByType(Type.killAuraCps).getValueAsInteger();
		this.timer.setDelay(1000 / cps);
		this.timer.start();
		super.onDisabled();
	}
	
	public void onDisabled() {
		this.timer.stop();
		super.onDisabled();
	}
	
	public void updateCps(int cps) {
		Value value = utils.getValueByType(Type.killAuraCps);
		value.setValue(cps);
		this.timer.setDelay(1000 / cps);
	}
}

class attack implements ActionListener {
	Utils utils = Utils.getInstance();
	Minecraft mc = Minecraft.getMinecraft();
	Client client = Client.getInstance();
	ValueManager vm = client.getValuemanager();
	
	public Boolean isEntityViable(Entity entity) {
		
		if (entity.isInvisible())
			return false;
		
		if (entity == mc.thePlayer)
			return false;
		
		if (mc.thePlayer.getDistance(entity.posX, entity.posY, entity.posZ) > vm.getKillAuraRange())
			return false;
		
		if (vm.getKillAuraTargetMode().equals(TargetMode.Mob) && utils.isPlayer(entity))
			return false;
		
		return true;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		TargetMode tm = vm.getKillAuraTargetMode();
		Mode mode = vm.getKillAuraMode();
		List<?> list = tm.equals(TargetMode.Player) ? mc.theWorld.playerEntities : mc.theWorld.loadedEntityList;
		
		for (Object obj : list) {
			if (obj instanceof EntityLivingBase) {
            	EntityLivingBase entity = (EntityLivingBase) obj;
            	
				if (isEntityViable(entity)) {
					utils.attackEntity(entity);
					mc.thePlayer.swingItem();
				}
				
				if (mode.equals(Mode.Single))
					break;
			}
    	}
	}
	
}
