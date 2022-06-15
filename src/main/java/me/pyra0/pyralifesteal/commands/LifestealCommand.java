package me.pyra0.pyralifesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class LifestealCommand extends BaseCommand {

    public LifestealCommand() {
        super(SenderType.ALL);
    }

    @Override
    public boolean onCommandExecute(CommandSender sender, Command command, String label, String[] args) {
        // Come up with sub commands:
        // /lifesteal heartcap
        // /lifesteal heartcap <number>
        // /lifesteal recipe
        // /lifesteal recipe edit
        // /lifesteal checkhearts
        // /lifesteal checkhearts <name>
        // /lifesteal sethearts <name> <number>
        return false;
    }

    @Override
    public List<String> onTabCompletion(CommandSender sender, Command command, String label, String[] args) {
        //if (args.length == 1) return matchInput(args[0], Arrays.asList("", ""));
        return null;
    }
}
