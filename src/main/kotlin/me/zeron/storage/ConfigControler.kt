package me.zeron.storage

import io.github.monun.invfx.InvFX.frame
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.zeron.storage.Data.lockedStorage
import me.zeron.storage.Data.storageDirectory
import me.zeron.storage.Data.storageMap
import me.zeron.storage.Data.storageName
import me.zeron.storage.Data.unlockedStorage
import me.zeron.storage.MainCore.Companion.plugin
import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound
import net.kyori.adventure.text.Component.text
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.util.*

object ConfigControler {
    private val config = plugin.config

    fun setStorageItemMeta() {
        val unlocked = ItemStack(Material.CHEST, 1)
        val locked = ItemStack(Material.ENDER_CHEST, 1)
        val unlockedMeta = unlocked.itemMeta
        val lockedMeta = locked.itemMeta

        unlockedMeta.displayName(text(config.getString("storageUnlocked.name") ?: "§cCONFIG ERROR"))
        unlockedMeta.lore(config.getStringList("storageUnlocked.lore").map(::text))

        lockedMeta.displayName(text(config.getString("storageLocked.name") ?: "§cCONFIG ERROR"))
        lockedMeta.lore(config.getStringList("storageLocked.lore").map(::text))

        unlocked.itemMeta = unlockedMeta
        locked.itemMeta = lockedMeta

        unlockedStorage = unlocked
        lockedStorage = locked

        val pane = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
        val paneMeta = pane.itemMeta.apply {
            displayName(text(" "))
        }
        pane.itemMeta = paneMeta

        Data.pane = pane
    }

    fun loadStorageName() {
        storageName = config.getString("storageName") ?: "§cCONFIG ERROR"
    }

    fun saveStorageMap() {
        storageMap.entries.remove(storageMap.entries.first())
        storageMap.entries.forEach { entry ->
            val file = File(storageDirectory, entry.key + ".yml")

            if (!file.exists()) file.createNewFile()

            val yaml = YamlConfiguration.loadConfiguration(file)
            for (inv in 1..8) {
                yaml.set("Storage$inv", null)
                for (x in 0..8) {
                    for (y in 0..5) {
                        if (entry.value.storageList[inv - 1].item(x, y) != null) {
                            yaml.set("Storage$inv.${x},${y}", entry.value.storageList[inv - 1].item(x, y))
                        }
                    }
                }
            }

            yaml.save(file)
        }
    }

    fun readStorageMap() {
        storageDirectory.walk().forEach {
            try {
                val yaml = YamlConfiguration.loadConfiguration(it)
                val storage = Storage(it.name.slice(0 until it.name.indexOf(".")))
                for (i in 1..8) {
                    yaml.getConfigurationSection("Storage$i")?.getKeys(false)?.forEach { index ->
                        storage.storageList[i - 1].apply {
                            item(
                                index.slice(0 until index.indexOf(",")).toInt(), //x
                                index.slice(index.indexOf(",") + 1 until index.length).toInt(), //y
                                yaml.getItemStack("Storage${i}.$index")
                            )
                        }
                    }

                }

                storageMap.put(it.name.slice(0 until it.name.indexOf(".")), storage)
            } catch (e: Exception) {
                plugin.logger.info("§cCONFIG ERROR")
                e.printStackTrace()
            }
        }
    }
}