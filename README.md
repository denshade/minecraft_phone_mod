# Villager Phone

Every villager is glued to their phone. All of them. No exceptions.

![Villagers on their phones](villagersonphones.png)

A Fabric mod for **Minecraft Java 26.1.2** that equips all villagers with a phone and makes them hold it up while staring at the screen.

## Requirements

- **Minecraft Java Edition 26.1.2**
- **Fabric Loader** 0.19.2 or newer ([fabricmc.net/use](https://fabricmc.net/use/))
- **Fabric API** for 26.1.2 ([Modrinth](https://modrinth.com/mod/fabric-api) or [CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api))
- **Java 25+** (required by Minecraft 26.1)

## Installation

1. **Install Fabric Loader** for Minecraft 26.1.2 from [fabricmc.net/use](https://fabricmc.net/use/).
2. **Download Fabric API** matching 26.1.2 (for example `fabric-api-0.148.0+26.1.2.jar`).
3. **Build or download this mod** (see [Building from source](#building-from-source) below).
4. Open your Minecraft folder:
   - Windows: `Win + R` → `%appdata%\.minecraft` → Enter
   - macOS: `~/Library/Application Support/minecraft`
   - Linux: `~/.minecraft`
5. Put both JAR files in the **`mods`** folder (create it if it does not exist):
   ```
   mods/
     fabric-api-0.148.0+26.1.2.jar
     villager-phone-1.0.0.jar
   ```
   Leave the files as `.jar` files — do not unzip them.
6. In the Minecraft Launcher, select the **Fabric 26.1.2** profile and start the game.
7. On the main menu, open **Mods** and confirm **Fabric API** and **Villager Phone** are listed.

Visit any village — every villager should be on their phone.

### Troubleshooting

- **Purple/black checkerboard on the phone:** the mod JAR may be outdated. Rebuild, replace the file in `mods`, and press **F3 + T** in-game to reload resources.
- **Black screen or crash on launch:** check `logs/latest.log` in your Minecraft folder for lines containing `villagerphone` or `ERROR`.
- **Log location:** `%appdata%\.minecraft\logs\latest.log` (Windows)

Test the phone item in your inventory:

```
/give @s villagerphone:phone
```

## Building from source

Requires **Java 25+** and Git.

```powershell
git clone <repository-url>
cd minecraft_phone_mod
.\gradlew.bat build
```

The mod JAR is written to:

```
build\libs\villager-phone-1.0.0.jar
```

Copy that file into your `mods` folder.

### Run a development client

```powershell
.\gradlew.bat runClient
```

## License

MIT
