package com.nekozouneko.rulePlugin

import org.bukkit.plugin.java.JavaPlugin

class RulePlugin : JavaPlugin() {
    lateinit var instance: JavaPlugin
    fun getInstance() : JavaPlugin { return instance }

    override fun onEnable() {
        instance = this
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
