package me.zeron.storage

import io.github.monun.invfx.InvFX.frame
import io.github.monun.invfx.openFrame
import io.github.monun.kommand.PluginKommand
import me.zeron.storage.Data.lockedStorage
import me.zeron.storage.Data.pane
import me.zeron.storage.Data.storageMap
import me.zeron.storage.Data.storageSelectWindowName
import me.zeron.storage.Data.unlockedStorage
import me.zeron.storage.MainCore.Companion.plugin
import net.kyori.adventure.text.Component.text
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent

object KommandStorage {
    fun kommandStorage(kommand: PluginKommand) {
        kommand.register("창고") {
            requires { sender is Player }
            executes {
                invSetting(player)
            }
        }
    }

    private fun invSetting(p: Player) {
        val paneList = mutableListOf(0 to 0, 2 to 0, 4 to 0, 6 to 0, 8 to 0,
            0 to 1, 1 to 1, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1, 7 to 1, 8 to 1,
            0 to 2, 2 to 2, 4 to 2, 6 to 2, 8 to 2)

        val storageFrame = frame(3, text(storageSelectWindowName)) {
            slot(1, 0) {
                if (p.hasPermission("Storage.storage1")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "1") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                        map { it.replace("&", "§").replace("{slot}", "1") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(1)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "1") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "1") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock


                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(3, 0) {
                if (p.hasPermission("Storage.storage2")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "2") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "2") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(2)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "2") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "2") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(5, 0) {
                if (p.hasPermission("Storage.storage3")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "3") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "3") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(3)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "3") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "3") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(7, 0) {
                if (p.hasPermission("Storage.storage4")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "4") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "4") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(4)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "4") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "4") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(1, 2) {
                if (p.hasPermission("Storage.storage5")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "5") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "5") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(5)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "5") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "5") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(3, 2) {
                if (p.hasPermission("Storage.storage6")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "6") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "6") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(6)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "6") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "6") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(5, 2) {
                if (p.hasPermission("Storage.storage7")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "7") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "7") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(8)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "7") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "7") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }
                }
            }
            slot(7, 2) {
                if (p.hasPermission("Storage.storage8")) {
                    val unlock = unlockedStorage
                    val unlockMeta = unlock.itemMeta
                    unlockMeta.displayName(text(plugin.config.getString("storageUnlocked.name")?.replace("&", "§")?.replace("{slot}", "8") ?: "§cCONFIG ERROR"))
                    unlockMeta.lore(plugin.config.getStringList("storageUnlocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "8") }.map(::text))

                    unlock.itemMeta = unlockMeta

                    item = unlock

                    onClick {
                        val storage = storageMap[p.uniqueId.toString()] ?: Storage(p.uniqueId.toString()) // 없을 시 새로 생성
                        storageMap.put(p.uniqueId.toString(), storage)
                        p.closeInventory()
                        storage.open(8)
                    }
                } else {
                    val lock = lockedStorage
                    val lockMeta = lock.itemMeta
                    lockMeta.displayName(text(plugin.config.getString("storageLocked.name")?.replace("&", "§")?.replace("{slot}", "8") ?: "§cCONFIG ERROR"))
                    lockMeta.lore(plugin.config.getStringList("storageLocked.lore").
                    map { it.replace("&", "§").replace("{slot}", "8") }.map(::text))

                    lock.itemMeta = lockMeta

                    item = lock

                    onClick {
                        it.isCancelled = true
                    }

                }
            }

            onOpen {
                paneList.forEach {
                    item(it.first, it.second, pane)
                }
            }

            onClick { x: Int, y: Int, event: InventoryClickEvent ->
                paneList.forEach {
                    if (it.first == x && it.second == y) {
                        event.isCancelled = true
                    }
                }
            }
        }

        p.openFrame(storageFrame)
    }
}