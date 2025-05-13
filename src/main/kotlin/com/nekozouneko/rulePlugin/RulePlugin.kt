package com.nekozouneko.rulePlugin

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

class RulePlugin : JavaPlugin() {
    lateinit var instance: JavaPlugin
    lateinit var configuration: FileConfiguration
    fun getInstance() : JavaPlugin { return instance }

    override fun onEnable() {
        instance = this
        saveDefaultConfig()
    }

    override fun onDisable() {}
}
