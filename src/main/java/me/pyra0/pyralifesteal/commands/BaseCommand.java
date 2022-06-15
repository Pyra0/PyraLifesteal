package me.pyra0.pyralifesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand implements TabExecutor {
    protected final SenderType senderType;

    public enum SenderType {
        ALL,
        CONSOLE,
        PLAYER
    }

    public BaseCommand(SenderType senderType) {
        this.senderType = senderType;
    }

    public static List<String> matchInput(String input, List<String> completions) {
        List<String> toReturn = new ArrayList<>();
        for (String s : completions) if (s.toUpperCase().startsWith(input.toUpperCase())) toReturn.add(s);
        return toReturn;
    }

    @Override
    public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (senderType) {
            case CONSOLE:
                if (!(sender instanceof ConsoleCommandSender)) {
                    sender.sendMessage("This command may only be used from the console.");
                    return true;
                }
                break;
            case PLAYER:
                if (!(sender instanceof Player)) {
                    sender.sendMessage("This command may only be used by players.");
                    return true;
                }
                break;
        }
        return onCommandExecute(sender, command, label, args);
    }

    public abstract boolean onCommandExecute(CommandSender sender, Command command, String label, String[] args);

    @Override
    public final List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> toReturn = null;
        if (command.testPermissionSilent(sender)) toReturn = onTabCompletion(sender, command, label, args);
        return toReturn == null ? new ArrayList<>() : toReturn;
    }

    public abstract List<String> onTabCompletion(CommandSender sender, Command command, String label, String[] args);
}
