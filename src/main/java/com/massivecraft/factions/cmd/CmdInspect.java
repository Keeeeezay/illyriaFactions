package com.massivecraft.factions.cmd;

import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdInspect extends FCommand {
    public CmdInspect() {
        super();
        this.aliases.add("inspect");
        this.aliases.add("ins");

        this.requirements = new CommandRequirements.Builder(Permission.INSPECT)
                .playerOnly()
                .memberOnly()
                .build();
    }


    @Override
    public void perform(CommandContext context) {
        if (context.fPlayer.isInspectMode()) {
            context.fPlayer.setInspectMode(false);
            context.msg(TL.COMMAND_INSPECT_DISABLED_MSG);
        } else {
            context.fPlayer.setInspectMode(true);
            context.msg(TL.COMMAND_INSPECT_ENABLED);
        }

    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_INSPECT_DESCRIPTION;
    }
}
