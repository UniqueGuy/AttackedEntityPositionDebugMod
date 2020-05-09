package me.uniqueman.mod;

import me.uniqueman.mod.commands.AttackedEntityPosCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommand;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "attackedentityposdebug", name = "Attacked Entity Position Debug Mod", version = "1.0", acceptedMinecraftVersions = "[1.8.9]")
public class AttackedEntityPos {

	public static boolean togglestate = false;
    private Minecraft mc;
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        ClientCommandHandler.instance.registerCommand((ICommand)new AttackedEntityPosCommand());
    }
    
    @SubscribeEvent
    public void lol(AttackEntityEvent e) {
    	if (togglestate) {
            final Entity t = e.target;
            e.entityPlayer.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED 
            		+ "x=" + t.posX + ", y=" + t.posY + ", z=" + t.posZ));
        }
    }

	public static void setToggledState(boolean b) {
		togglestate = b;
	}

	public static boolean getToggledState() {
		return togglestate;
	}
}
