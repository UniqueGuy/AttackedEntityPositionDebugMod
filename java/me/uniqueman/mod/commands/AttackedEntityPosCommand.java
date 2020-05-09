package me.uniqueman.mod.commands;

import me.uniqueman.mod.AttackedEntityPos;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class AttackedEntityPosCommand extends CommandBase {
	
	@Override
	public String getCommandName() {
        return "positiondebug";
    }
    
	@Override
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName();
    }
    
    @Override
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        if (!AttackedEntityPos.getToggledState()) {
            AttackedEntityPos.setToggledState(true);
            sender.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.GREEN + "Position debug: On"));
        }
        else {
            AttackedEntityPos.setToggledState(false);
            sender.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Position debug: Off"));
        }
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_1) {
        return true;
    }
}
