package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdStealth extends FCommand {
    public CmdStealth() {
        this.aliases.add("ninja");
        this.aliases.add("stealth");

        this.requirements = new CommandRequirements.Builder(Permission.STEALTH)
                .playerOnly()
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        if (context.faction != null && !context.faction.getId().equalsIgnoreCase("0") && !context.faction.getId().equalsIgnoreCase("none") && !context.faction.getId().equalsIgnoreCase("safezone") && !context.faction.getId().equalsIgnoreCase("warzone")) {
            context.fPlayer.setStealth(!context.fPlayer.isStealthEnabled());
            context.msg(context.fPlayer.isStealthEnabled() ? TL.COMMAND_STEALTH_ENABLE : TL.COMMAND_STEALTH_DISABLE);
        } else {
            context.msg(TL.COMMAND_STEALTH_MUSTBEMEMBER);
        }
    }

    public TL getUsageTranslation() {
        return TL.COMMAND_STEALTH_DESCRIPTION;
    }
}
