plugins {
    kotlin("jvm") version "1.6.10"
    id("io.papermc.paperweight.userdev") version "1.3.8"
    kotlin("plugin.serialization") version "1.5.0"
}

group = "me.zeron.storage"
version = "1.0.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    paperDevBundle("1.19.2-R0.1-SNAPSHOT")
    implementation("io.github.monun:tap-api:4.7.3")
    implementation("io.github.monun:kommand-api:2.14.0")
    implementation("io.github.monun:invfx-api:3.2.0")
    compileOnly("net.kyori:adventure-api:4.11.0")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.6.0")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation(kotlin("reflect"))
}

tasks {
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }
    create<Jar>("paperJar") {
        from(sourceSets["main"].output)

        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set("")

        doLast {
            copy {
                from(archiveFile)
                val fileLoc = File("C:\\Users\\USER\\Desktop\\ZeronPlayGround\\plugins")
                into(if (File(fileLoc, archiveFileName.get()).exists()) fileLoc else fileLoc)
            }
        }
    }
}
