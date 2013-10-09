package flayr.magiclights;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler {

	private void onPlayerTick(EntityPlayer player) {
		if(player.getCurrentItemOrArmor(0) != null){
			ItemStack hand = player.getCurrentItemOrArmor(0);
			
			if(hand.getItem() == MagicLights.lightStaff){
				player.addPotionEffect((new PotionEffect(Potion.nightVision.getId(), 100, 0)));
			}
		}
		}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
