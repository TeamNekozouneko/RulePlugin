package com.nekozouneko.rulePlugin

import com.nekozouneko.rulePlugin.commands.RuleCommand
import com.nekozouneko.rulePlugin.listener.JoinEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class RulePlugin : JavaPlugin() {
    companion object{
        val deserializer: LegacyComponentSerializer = LegacyComponentSerializer.builder().extractUrls().character(LegacyComponentSerializer.SECTION_CHAR).build();
        lateinit var plugin: JavaPlugin
        lateinit var fileConfiguration: FileConfiguration
        fun getInstance() : JavaPlugin { return plugin }
        fun getConfiguration() : FileConfiguration { return fileConfiguration }

        fun showRules(player: Player){
            val rules = getConfiguration().getStringList("rules")
            if(rules.isEmpty()) return
            for(message in rules)
                player.sendMessage(deserializer.deserialize(message)) // これが修正案
        }
        fun showRules(sender: CommandSender){
            val rules = getConfiguration().getStringList("rules")
            if(rules.isEmpty()) return
            for(message in rules) sender.sendMessage(Component.text(message))
        }
    }

    override fun onEnable() {
        plugin = this

        saveDefaultConfig()
        fileConfiguration = config

        server.pluginManager.registerEvents(JoinEvent(), this)

        getCommand("rule")?.setExecutor(RuleCommand())
    }

    override fun onDisable() {}
}
