package com.nekozouneko.rulePlugin

import com.nekozouneko.rulePlugin.commands.RuleCommand
import com.nekozouneko.rulePlugin.listener.JoinEvent
import net.kyori.adventure.text.Component
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class RulePlugin : JavaPlugin() {
    companion object{
        lateinit var instance: JavaPlugin
        lateinit var configuration: FileConfiguration
        fun getInstance() : JavaPlugin { return instance }
        fun getConfiguration() : FileConfiguration { return configuration }

        fun showRules(player: Player){
            val rules = getConfiguration().getStringList("rules")
            if(rules.isEmpty()) return
            for(message in rules) player.sendMessage(Component.text(message))
        }
        fun showRules(sender: CommandSender){
            val rules = getConfiguration().getStringList("rules")
            if(rules.isEmpty()) return
            for(message in rules) sender.sendMessage(Component.text(message))
        }
    }

    override fun onEnable() {
        instance = this

        saveDefaultConfig()
        configuration = config

        server.pluginManager.registerEvents(JoinEvent(), this)

        getCommand("rule")?.setExecutor(RuleCommand())
    }

    override fun onDisable() {}
}
