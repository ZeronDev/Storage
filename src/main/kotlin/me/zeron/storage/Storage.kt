package me.zeron.storage

import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.frame.InvFrame
import io.github.monun.invfx.openFrame
import me.zeron.storage.Data.storageMap
import me.zeron.storage.Data.storageName
import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound
import net.kyori.adventure.sound.Sound.sound
import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import java.util.*

class Storage {
    val storageList: MutableList<InvFrame> = mutableListOf()
    private var owner: String
    constructor(uuid: String) {
        owner = uuid

        for (i in 1..8) {
            storageList.add(frame(6, text(storageName.replace("{slot}", i.toString()))) {
                onClose {
                    storageList.removeAt(i-1)
                    storageList.add(i-1, this)

                    Bukkit.getPlayer(UUID.fromString(owner))!!.playSound(sound(Key.key("item_armor_equip_leather"), Sound.Source.PLAYER,0.5f, 1f))
                    storageMap.put(owner, this@Storage)
                }

                onClick { x, y, event -> event.isCancelled = false }

                onClickBottom {
                    it.isCancelled = false
                }

                onOpen {
                    Bukkit.getPlayer(UUID.fromString(owner))!!.playSound(sound(Key.key("item_armor_equip_leather"), Sound.Source.PLAYER,0.5f, 1f))
                }
            })
        }
    }


    fun open(storageNumber: Int) {
        Bukkit.getPlayer(UUID.fromString(owner))!!.openFrame(storageList[storageNumber - 1])
    }
}