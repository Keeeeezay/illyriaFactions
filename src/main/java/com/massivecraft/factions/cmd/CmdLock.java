package com.massivecraft.factions.cmd;

import com.massivecraft.factions.SavageFactions;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.util.TL;

public class CmdLock extends FCommand {

    // TODO: This solution needs refactoring.
    /*
       factions.lock:
	description: use the /f lock [on/off] command to temporarily lock the data files from being overwritten
	default: op
	 */

    public CmdLock() {
        super();
        this.aliases.add("lock");
        this.optionalArgs.put("on/off", "flip");

        this.requirements = new CommandRequirements.Builder(Permission.LOCK)
                .build();
    }

    @Override
    public void perform(CommandContext context) {
        SavageFactions.plugin.setLocked(context.argAsBool(0, !SavageFactions.plugin.getLocked()));
        context.msg(SavageFactions.plugin.getLocked() ? TL.COMMAND_LOCK_LOCKED : TL.COMMAND_LOCK_UNLOCKED);
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_LOCK_DESCRIPTION;
    }

}
