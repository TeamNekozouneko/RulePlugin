package com.nekozouneko.rulePlugin.commands

import com.nekozouneko.rulePlugin.RulePlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class ReloadCommand : RuleCommand.CommandInterface {
    override fun handle(sender: CommandSender, command: Command, args: Array<out String>): Boolean {
        RulePlugin.getInstance().reloadConfig()
        RulePlugin.fileConfiguration = RulePlugin.getInstance().config
        sender.sendMessage("§aコンフィグをリロードしました。")
        return false
    }
}