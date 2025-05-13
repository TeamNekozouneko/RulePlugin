package com.nekozouneko.rulePlugin.listener

import com.nekozouneko.rulePlugin.RulePlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class JoinEvent : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent){
        RulePlugin.showRules(event.player)
    }
}