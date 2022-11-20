package me.zeron.storage

import me.zeron.storage.MainCore.Companion.plugin
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import java.io.File


object Data {
    var prefix: String = "[ §aStorage §f]"
    var unlockedStorage: ItemStack = ItemStack(Material.CHEST)
    var lockedStorage: ItemStack = ItemStack(Material.ENDER_CHEST)
    var pane: ItemStack = ItemStack(Material.GRAY_STAINED_GLASS_PANE)
    var storageName: String = "창고{slot}"
    val storageMap: MutableMap<String, Storage> = mutableMapOf() //UUID
    val storageDirectory: File = File(plugin.dataFolder, "StorageFiles")
}