package me.zeron.storage

import io.github.monun.kommand.kommand
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.zeron.storage.ConfigControler.loadStorageName
import me.zeron.storage.ConfigControler.readStorageMap
import me.zeron.storage.ConfigControler.saveStorageMap
import me.zeron.storage.ConfigControler.setStorageItemMeta
import me.zeron.storage.Data.prefix
import me.zeron.storage.Data.storageMap
import me.zeron.storage.KommandStorage.kommandStorage
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.FileWriter

class MainCore : JavaPlugin() {
    companion object {
        lateinit var plugin: Plugin
    }

    override fun onEnable() {
        plugin = this

        if (!dataFolder.exists()) {
            dataFolder.mkdir()
        }

        storageMap.clear()

        if (!File(dataFolder, "StorageFiles").exists()) File(dataFolder, "StorageFiles").mkdir()

        saveDefaultConfig()
        saveConfig()

        readStorageMap()
        loadStorageName()
        setStorageItemMeta()

        CoroutineScope(Dispatchers.IO).launch {
            val description = File(dataFolder, "description.txt")
            withContext(Dispatchers.IO) {
                FileWriter(description).use { it.write("""
                    - [ Storage ] -
                    Permission : Storage.storage1, Storage.storage2...
                    사용법 : /창고
                    제작자 : ZeronDev
                """.trimIndent()) }
            }
        }

        logger.info("$prefix 창고 플러그인이 활성화중입니다\n제작자 : ZeronDev")
        logger.info("$prefix CONFIG가 로딩중입니다")
    }

    override fun onDisable() {
        logger.info("$prefix 창고 플러그인이 비활성화중입니다\n제작자 : ZeronDev")

        saveStorageMap()
        saveConfig()

        logger.info("$prefix CONFIG를 저장중입니다")
    }
}