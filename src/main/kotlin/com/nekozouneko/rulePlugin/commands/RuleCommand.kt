package com.nekozouneko.rulePlugin.commands

import com.nekozouneko.rulePlugin.RulePlugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class RuleCommand : CommandExecutor, TabExecutor {
    interface CommandInterface{
        fun handle(sender: CommandSender, command: Command, args: Array<out String>?) : Boolean { return false }
    }
    enum class Commands{
        SHOW_RULES,
        RELOAD
    }
    val instances: Map<Commands, CommandInterface> = mapOf(
        Commands.SHOW_RULES to ShowRuleCommand(),
        Commands.RELOAD to ReloadCommand()
    )

    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>?): Boolean {
        var handle = Commands.SHOW_RULES
        if(p3?.size == 1 && p3[0] == "reload" && p0.hasPermission("rule.reload")){
            handle = Commands.RELOAD
        }
        if(instances[handle]?.handle(p0, p1, p3) == true) return true
        return false
    }

    override fun onTabComplete(
        p0: CommandSender,
        p1: Command,
        p2: String,
        p3: Array<out String>?
    ): MutableList<String>? {
        if(p3?.size == 0 && p0.hasPermission("rule.reload")) return mutableListOf("reload")
        return null
    }
}