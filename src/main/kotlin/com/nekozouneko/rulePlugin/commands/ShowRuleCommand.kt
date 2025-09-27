package com.nekozouneko.rulePlugin.commands

import com.nekozouneko.rulePlugin.RulePlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class ShowRuleCommand : RuleCommand.CommandInterface {
    override fun handle(sender: CommandSender, command: Command, args: Array<out String>): Boolean {
        RulePlugin.showRules(sender)
        return true
    }
}