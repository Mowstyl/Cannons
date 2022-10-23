import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    implementation("org.bstats:bstats-bukkit:2.2.1")
    compileOnly("net.milkbowl.vault:VaultAPI:1.7")
    compileOnly(libs.paper)
    compileOnly(libs.worldeditCore)
}

tasks {

    withType(ProcessResources::class) {
        filteringCharset = Charsets.UTF_8.name()
        filesMatching("plugin.yml") {
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
            expand("version" to project.version)
        }
    }

    withType(ShadowJar::class) {
        archiveClassifier.set("")
        base {
            archiveBaseName.set("Cannons")
        }
        val base = "at.pavlov.cannons.libraries"
        relocate("org.bstats", "$base.bstats")
    }

    withType(Assemble::class) {
        dependsOn(shadowJar)
    }
}
