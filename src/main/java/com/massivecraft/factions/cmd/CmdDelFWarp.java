package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.command.Command;

public class CmdDelFWarp extends FCommand {

    public CmdDelFWarp() {
        super();
        this.aliases.add("delwarp");
        this.aliases.add("dw");
        this.aliases.add("deletewarp");
        this.requiredArgs.add("warp name");

        this.requirements = new CommandRequirements.Builder(Permission.SETWARP)
                .playerOnly()
                .memberOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        String warp = context.argAsString(0);
        if (context.faction.isWarp(warp)) {
            if (!transact(context.fPlayer, context)) {
                return;
            }
            context.faction.removeWarp(warp);
            context.msg(TL.COMMAND_DELFWARP_DELETED, warp);
        } else {
            context.msg(TL.COMMAND_DELFWARP_INVALID, warp);
        }
    }

    private boolean transact(FPlayer player, CommandContext context) {
        return !SavageFactions.plugin.getConfig().getBoolean("warp-cost.enabled", false) || player.isAdminBypassing() || context.payForCommand(SavageFactions.plugin.getConfig().getDouble("warp-cost.delwarp", 5), TL.COMMAND_DELFWARP_TODELETE.toString(), TL.COMMAND_DELFWARP_FORDELETE.toString());
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_DELFWARP_DESCRIPTION;
    }
}
