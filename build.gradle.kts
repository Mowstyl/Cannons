plugins {
    java
    `maven-publish`
    idea
}

group = "at.pavlov"
version = "2.5.13"
description = "Cannons"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

subprojects {
    apply<JavaPlugin>()
    apply<IdeaPlugin>()
    apply<MavenPublishPlugin>()

    group = rootProject.group
    version = rootProject.version
    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))


    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            url = uri("https://maven.enginehub.org/repo/")
        }

        maven {
            url = uri("https://hub.spigotmc.org/nexus/content/groups/public/")
        }

        maven {
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }

        maven {
            url = uri("https://repo.codemc.org/repository/maven-public")
        }

        maven {
            url = uri("https://jitpack.io")
        }
    }

    tasks {
        withType(JavaCompile::class) {
            options.release.set(17)
            options.encoding = Charsets.UTF_8.name()
            options.isFork = true
            options.isDeprecation = true
        }
    }

    publishing {
        publications {
            create<MavenPublication>(project.name) {
                from(components["java"])
                pom {
                    developers {
                        developer {
                            id.set("DerPavlov")
                            name.set("DerPavlov")
                            email.set("derPavlov@gmail.com")
                            roles.add("author")
                            timezone.set("+1")
                        }
                    }
                }
            }
        }
    }


}
