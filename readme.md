# OpenGLDebug
This mod aims to annotate many of Minecraft's graphics internals for capture by external tools such as [RenderDoc](https://renderdoc.org/).

----

## How to launch Minecraft with RenderDoc
These steps are modloader-agnostic (even Architectury), but only tested on Windows. The steps below will demonstrate how to launch Minecraft for RenderDoc debugging.
1. IntelliJ:
   1. Open IntelliJ's "Edit Configurations" window
   2. Select "runClient" / "Minecraft Client" underneath "**Applications**"
   3. Far right from the title "**Build and Run**", are "Modify options". Under "Java" under "Modify options" is an option "Shorten command line". If this has a checkmark, uncheck it.
   4. Launch the client configuration
   5. No further action is needed after launching, you will only need to look for the generated command-line arguments in the Run console in the RenderDoc steps.
   6. Close the game, but keep the Run console open. There will be information necessary for copying into your RenderDoc launch configuration.

----

The Gradle-generated command-line launch configuration can look similar to these examples:
<details>
<summary>NeoForged example</summary>

```
C:\Users\USERNAME\.gradle\jdks\jdk-17.0.1+12\bin\java.exe
-Dforge.logging.console.level=debug
-Dfml.earlyprogresswindow=false
-Dmixin.env.disableRefMap=true
-DlegacyClassPath.file=C:\Users\USERNAME\IdeaProjects\twilightforest\build\classpath\runClient_minecraftClasspath.txt
-DignoreList=bootstraplauncher,securejarhandler,asm-commons,asm-util,asm-analysis,asm-tree,asm,JarJarFileSystems,events-47.1.47.jar,core-47.1.47.jar,language-java,language-lowcode,language-minecraft,client-extra,forge-
-Dfml.gameLayerLibraries=events-47.1.47.jar
-DmergeModules=jna-5.10.0.jar,jna-platform-5.10.0.jar
-Dforge.enabledGameTestNamespaces=twilightforest
-Dforge.enableGameTest=true
-Dfml.pluginLayerLibraries=core-47.1.47.jar,language-java-47.1.47.jar,language-lowcode-47.1.47.jar,language-minecraft-47.1.47.jar
-Djava.net.preferIPv6Addresses=system
-p C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\cpw.mods\bootstraplauncher\1.1.2\c546e00443d8432cda6baa1c860346980742628\bootstraplauncher-1.1.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\cpw.mods\securejarhandler\2.1.10\51e6a22c6c716beb11e244bf5b8be480f51dd6b5\securejarhandler-2.1.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-commons\9.5\19ab5b5800a3910d30d3a3e64fdb00fd0cb42de0\asm-commons-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-util\9.5\64b5a1fc8c1b15ed2efd6a063e976bc8d3dc5ffe\asm-util-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-analysis\9.5\490bacc77de7cbc0be1a30bb3471072d705be4a4\asm-analysis-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-tree\9.5\fd33c8b6373abaa675be407082fdfda35021254a\asm-tree-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\9.5\dc6ea1875f4d64fbc85e1691c95b96a3d8569c90\asm-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\JarJarFileSystems\0.3.19\2464eb7d6b9ddb9db36a82cf8a95193e5c6fe020\JarJarFileSystems-0.3.19.jar
--add-modules ALL-MODULE-PATH
--add-opens java.base/java.util.jar=cpw.mods.securejarhandler
--add-opens java.base/java.lang.invoke=cpw.mods.securejarhandler
--add-exports java.base/sun.security.util=cpw.mods.securejarhandler
--add-exports jdk.naming.dns/com.sun.jndi.dns=java.naming
-XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump
-javaagent:C:\Users\USERNAME\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\231.9011.34\lib\idea_rt.jar=53482:C:\Users\USERNAME\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\231.9011.34\bin
-Dfile.encoding=UTF-8
-classpath C:\Users\USERNAME\IdeaProjects\twilightforest\out\production\classes;
C:\Users\USERNAME\IdeaProjects\twilightforest\out\production\resources;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\mezz\jei\jei-1.20.1-forge\15.2.0.25_mapped_parchment_2023.07.30-1.20.1\jei-1.20.1-forge-15.2.0.25_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\top\theillusivec4\curios\curios-forge\5.2.0-beta.3+1.20.1_mapped_parchment_2023.07.30-1.20.1\curios-forge-5.2.0-beta.3+1.20.1_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\curse\maven\jade-324717\4681833_mapped_parchment_2023.07.30-1.20.1\jade-324717-4681833_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\IdeaProjects\twilightforest\build\fg_cache\net\neoforged\forge\1.20.1-47.1.70_mapped_parchment_2023.07.30-1.20.1\forge-1.20.1-47.1.70_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\minecraft_repo\versions\1.20.1\client-extra.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\loader\47.1.47\69ee070bf404064508f5d7ce76b85787eeea7f54\loader-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\JarJarSelector\0.3.19\376cc9c8ea60720cf027c01fc033de915699801c\JarJarSelector-0.3.19.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\JarJarMetadata\0.3.19\83feaa9b770e6ac0e96ee4fc23fa89325c5fe2\JarJarMetadata-0.3.19.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.code.findbugs\jsr305\3.0.2\25ea2e8b0c338a877313bd4672d3fe056ea78f0d\jsr305-3.0.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\ca.weblite\java-objc-bridge\1.1\1227f9e0666314f9de41477e3ec277e542ed7f7b\java-objc-bridge-1.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\forgespi\7.0.1\3b4972a0cdb135853dba219be61a79b22cff1309\forgespi-7.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\mergetool\1.1.5\f3da18e12c696d35a47c82cbb2cc8b5aa15e1154\mergetool-1.1.5-api.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.jetbrains\annotations\24.0.1\13c5c75c4206580aa4d683bffee658caae6c9f43\annotations-24.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\earlydisplay\47.1.47\46509b19504a71e25b115383e900aade5088598a\earlydisplay-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\cpw.mods\securejarhandler\2.1.10\51e6a22c6c716beb11e244bf5b8be480f51dd6b5\securejarhandler-2.1.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.openjdk.nashorn\nashorn-core\15.3\43977e804697048fc8d81d333a36c17d07a5b3dd\nashorn-core-15.3.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-commons\9.5\19ab5b5800a3910d30d3a3e64fdb00fd0cb42de0\asm-commons-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-util\9.5\64b5a1fc8c1b15ed2efd6a063e976bc8d3dc5ffe\asm-util-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-analysis\9.5\490bacc77de7cbc0be1a30bb3471072d705be4a4\asm-analysis-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-tree\9.5\fd33c8b6373abaa675be407082fdfda35021254a\asm-tree-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\9.5\dc6ea1875f4d64fbc85e1691c95b96a3d8569c90\asm-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\accesstransformers\8.0.4\272d240aa73f42195b2a68e2ebd8b701ecf41f63\accesstransformers-8.0.4.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.antlr\antlr4-runtime\4.9.1\428664f05d2b7f7b7610204b5aa7c1763f62011a\antlr4-runtime-4.9.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\events\47.1.47\d6bf266eabb0c7e353d3a2e47a47e6ba6392ab96\events-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\core\47.1.47\915a0dc36418f3c3bf74e56015d1cb79ef5430f0\core-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\eventbus\6.0.5\699143dd438431d06b57416944f7cedbe52e1475\eventbus-6.0.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\coremods\5.0.1\386b00279628b105b2d507539c46e134e96f6237\coremods-5.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\unsafe\0.2.0\54d7a0a5e8fdb71b973025caa46f341ae5904f39\unsafe-0.2.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.electronwill.night-config\toml\3.6.4\51d6cefb2b55ee55ee26b16391212fb2c7dfb4f4\toml-3.6.4.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.electronwill.night-config\core\3.6.4\510f174abbf1c947494db50ef2445683bd52c230\core-3.6.4.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.maven\maven-artifact\3.8.5\4433f50c07debefaed0553bd0068f4f48d449313\maven-artifact-3.8.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.jodah\typetools\0.6.3\a01aaa6ddaea9ec07ec4f209487b7a46a526283a\typetools-0.6.3.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecrell\terminalconsoleappender\1.2.0\96d02cd3b384ff015a8fef4223bcb4ccf1717c95\terminalconsoleappender-1.2.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.jline\jline-reader\3.12.1\4382ab1382c7b6f379377ed5f665dc2f6e1218bc\jline-reader-3.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.jline\jline-terminal\3.12.1\c777448314e050d980a6b697c140f3bfe9eb7416\jline-terminal-3.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.spongepowered\mixin\0.8.5\9d1c0c3a304ae6697ecd477218fa61b850bf57fc\mixin-0.8.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\language-java\47.1.47\9f5f057de5fea5106fca0df2b0faea12a85bc283\language-java-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\language-lowcode\47.1.47\b9cb4bc84722dc99e902883f8ea5a952c0415d5c\language-lowcode-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.neoforged.fancymodloader\language-minecraft\47.1.47\70c137579710b203f0220b80a90eff3db19b32a2\language-minecraft-47.1.47.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\cpw.mods\bootstraplauncher\1.1.2\c546e00443d8432cda6baa1c860346980742628\bootstraplauncher-1.1.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\JarJarFileSystems\0.3.19\2464eb7d6b9ddb9db36a82cf8a95193e5c6fe020\JarJarFileSystems-0.3.19.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.guava\guava\31.1-jre\60458f877d055d0c9114d9e1a2efb737b4bc282c\guava-31.1-jre.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.github.oshi\oshi-core\6.2.2\54f5efc19bca95d709d9a37d19ffcbba3d21c1a6\oshi-core-6.2.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.code.gson\gson\2.10\dd9b193aef96e973d5a11ab13cd17430c2e4306b\gson-2.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.guava\failureaccess\1.0.1\1dcf1de382a0bf95a3d8b0849546c88bac1292c9\failureaccess-1.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.ibm.icu\icu4j\71.1\9e7d3304c23f9ba5cb71915f7cce23231a57a445\icu4j-71.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\authlib\4.0.43\2ff9d747a77570a07a60d32ac77eb6162ad2a2d9\authlib-4.0.43.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\blocklist\1.0.10\5c685c5ffa94c4cd39496c7184c1d122e515ecef\blocklist-1.0.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\brigadier\1.1.8\5244ce82c3337bba4a196a3ce858bfaecc74404a\brigadier-1.1.8.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\datafixerupper\6.0.8\3ba4a30557a9b057760af4011f909ba619fc5125\datafixerupper-6.0.8.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\logging\1.1.1\832b8e6674a9b325a5175a3a6267dfaf34c85139\logging-1.1.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\patchy\2.2.10\da05971b07cbb379d002cf7eaec6a2048211fefc\patchy-2.2.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\text2speech\1.17.9\3cad216e3a7f0c19b4b394388bc9ffc446f13b14\text2speech-1.17.9.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.httpcomponents\httpclient\4.5.13\e5f6cae5ca7ecaac1ec2827a9e2d65ae2869cada\httpclient-4.5.13.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-codec\commons-codec\1.15\49d94806b6e3dc933dacbd8acb0fdbab8ebd1e5d\commons-codec-1.15.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-io\commons-io\2.11.0\a2503f302b11ebde7ebc3df41daebe0e4eea3689\commons-io-2.11.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-logging\commons-logging\1.2\4bfc12adfe4842bf07b657f0369c4cb522955686\commons-logging-1.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-handler\4.1.82.Final\644041d1fa96a5d3130a29e8978630d716d76e38\netty-handler-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-codec\4.1.82.Final\b77200379acb345a9ffdece1c605e591ac3e4e0a\netty-codec-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-classes-epoll\4.1.82.Final\e7c7dd18deac93105797f30057c912651ea76521\netty-transport-classes-epoll-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-native-unix-common\4.1.82.Final\3e895b35ca1b8a0eca56cacff4c2dde5d2c6abce\netty-transport-native-unix-common-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport\4.1.82.Final\e431a218d91acb6476ccad5f5aafde50aa3945ca\netty-transport-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-buffer\4.1.82.Final\a544270cf1ae8b8077082f5036436a9a9971ea71\netty-buffer-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-resolver\4.1.82.Final\38f665ae8dcd29032eea31245ba7806bed2e0fa8\netty-resolver-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-common\4.1.82.Final\22d148e85c3f5ebdacc0ce1f5aabb1d420f73f3\netty-common-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\it.unimi.dsi\fastutil\8.5.9\bb7ea75ecdb216654237830b3a96d87ad91f8cc5\fastutil-8.5.9.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.java.dev.jna\jna-platform\5.12.1\97406a297c852f4a41e688a176ec675f72e8329\jna-platform-5.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.java.dev.jna\jna\5.12.1\b1e93a735caea94f503e95e6fe79bf9cdc1e985d\jna-5.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.sf.jopt-simple\jopt-simple\5.0.4\4fdac2fbe92dfad86aa6e9301736f6b4342a3f5c\jopt-simple-5.0.4.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-compress\1.21\4ec95b60d4e86b5c95a0e919cb172a0af98011ef\commons-compress-1.21.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-lang3\3.12.0\c6842c86792ff03b9f1d1fe2aab8dc23aa6c6f0e\commons-lang3-3.12.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.httpcomponents\httpcore\4.4.15\7f2e0c573eaa7a74bac2e89b359e1f73d92a0a1d\httpcore-4.4.15.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-core\2.19.0\3b6eeb4de4c49c0fe38a4ee27188ff5fee44d0bb\log4j-core-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-slf4j2-impl\2.19.0\5c04bfdd63ce9dceb2e284b81e96b6a70010ee10\log4j-slf4j2-impl-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-api\2.19.0\ea1b37f38c327596b216542bc636cfdc0b8036fa\log4j-api-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.joml\joml\1.10.5\22566d58af70ad3d72308bab63b8339906deb649\joml-1.10.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\cbac1b8d30cb4795149c1ef540f912671a8616d0\lwjgl-glfw-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\ed892f945cf7e79c8756796f32d00fa4ceaf573b\lwjgl-glfw-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\beda65ee503443e60aa196d58ed31f8d001dc22a\lwjgl-glfw-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\b997e3391d6ce8f05487e7335d95c606043884a1\lwjgl-glfw-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\a817bcf213db49f710603677457567c37d53e103\lwjgl-jemalloc-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\948a89b76a16aa324b046ae9308891216ffce5f9\lwjgl-jemalloc-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\cae85c4edb219c88b6a0c26a87955ad98dc9519d\lwjgl-jemalloc-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\fb476c8ec110e1c137ad3ce8a7f7bfe6b11c6324\lwjgl-jemalloc-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\2623a6b8ae1dfcd880738656a9f0243d2e6840bd\lwjgl-openal-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\30a474d0e57193d7bc128849a3ab66bc9316fdb1\lwjgl-openal-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\40d65f1a7368a2aa47336f9cb69f5a190cf9975a\lwjgl-openal-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\888349f7b1be6fbae58bf8edfb9ef12def04c4e3\lwjgl-openal-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\831a5533a21a5f4f81bbc51bb13e9899319b5411\lwjgl-opengl-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\c1807e9bd571402787d7e37e3029776ae2513bb8\lwjgl-opengl-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\527d78f1e9056aff3ed02ce93019c73c5e8f1721\lwjgl-opengl-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\deef3eb9b178ff2ff3ce893cc72ae741c3a17974\lwjgl-opengl-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\b119297cf8ed01f247abe8685857f8e7fcf5980f\lwjgl-stb-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\86315914ac119efdb02dc9e8e978ade84f1702af\lwjgl-stb-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\fde63cdd2605c00636721a6c8b961e41d1f6b247\lwjgl-stb-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\a8d41f419eecb430b7c91ea2ce2c5c451cae2091\lwjgl-stb-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\ff1914111ef2e3e0110ef2dabc8d8cdaad82347\lwjgl-tinyfd-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\a5d830475ec0958d9fdba1559efa99aef211e6ff\lwjgl-tinyfd-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\83a5e780df610829ff3a737822b4f931cffecd91\lwjgl-tinyfd-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\842eedd876fae354abc308c98a263f6bbc9e8a4d\lwjgl-tinyfd-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\ae58664f88e18a9bb2c77b063833ca7aaec484cb\lwjgl-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\36c37f16ab611b3aa11f3bcf80b1d509b4ce6b\lwjgl-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\f46cadcf95675908fd3a550d63d9d709cb68998\lwjgl-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\3b14f4beae9dd39791ec9e12190a9380cd8a3ce6\lwjgl-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\2.0.1\f48d81adce2abf5ad3cfe463df517952749e03bc\slf4j-api-2.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.machinezoo.noexception\noexception\1.7.1\b65330c98e38a1f915fa54a6e5eca496505e3f0a\noexception-1.7.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.antlr\antlr4\4.9.1\e92af8ab33e428461927b484e90bb155a4f3a052\antlr4-4.9.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.codehaus.plexus\plexus-utils\3.3.0\cf43b5391de623b36fe066a21127baef82c64022\plexus-utils-3.3.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\b421526c5f297295adef1c886e5246c39d4ac629\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.checkerframework\checker-qual\3.12.0\d5692f0526415fcc6de94bb5bfbd3afd9dd3b3e5\checker-qual-3.12.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.errorprone\error_prone_annotations\2.11.0\c5a0ace696d3f8b1c1d8cc036d8c03cc0cbe6b69\error_prone_annotations-2.11.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.j2objc\j2objc-annotations\1.3\ba035118bc8bac37d7eff77700720999acd9986d\j2objc-annotations-1.3.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.antlr\ST4\4.3\92f2c1ad8d84abcbeead6cf7f2c53a04166293c2\ST4-4.3.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.antlr\antlr-runtime\3.5.2\cd9cd41361c155f3af0f653009dcecb08d8b4afd\antlr-runtime-3.5.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.abego.treelayout\org.abego.treelayout.core\1.0.3\457216e8e6578099ae63667bb1e4439235892028\org.abego.treelayout.core-1.0.3.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.glassfish\javax.json\1.0.4\3178f73569fd7a1e5ffc464e680f7a8cc784b85a\javax.json-1.0.4.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\curse\maven\jeed-532286\4599236_mapped_parchment_2023.07.30-1.20.1\jeed-532286-4599236_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\curse\maven\museum-curator-859070\4629894_mapped_parchment_2023.07.30-1.20.1\museum-curator-859070-4629894_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\forge_gradle\deobf_dependencies\team-twilight\crossdimcommands\1.20-1.0_mapped_parchment_2023.07.30-1.20.1\crossdimcommands-1.20-1.0_mapped_parchment_2023.07.30-1.20.1.jar;
C:\Users\USERNAME\.gradle\caches\parchmentgradle\org\parchmentmc\data\parchment-1.20.1\2023.07.30\parchment-1.20.1-2023.07.30.zip;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\cpw.mods\modlauncher\10.0.10\669e5b6e61e84eee06bfd5822c91800a2c9f5c0f\modlauncher-10.0.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-simple\1.7.30\e606eac955f55ecf1d8edcccba04eb8ac98088dd\slf4j-simple-1.7.30.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecraftforge\srgutils\0.4.11\fbad1341ffdb47d276bbdc40ecb06da49e053e74\srgutils-0.4.11.jar cpw.mods.bootstraplauncher.BootstrapLauncher
--launchTarget forgeclientuserdev
--version MOD_DEV
--assetIndex 5
--assetsDir C:\Users\USERNAME\.gradle\caches\forge_gradle\assets
--gameDir .
--fml.forgeVersion 47.1.70
--fml.fmlVersion 47.1.47
--fml.mcVersion 1.20.1
--fml.mcpVersion 20230612.114412
```
</details>

<details>
<summary>Fabric example</summary>

```
C:\Users\USERNAME\.gradle\jdks\jdk-17.0.1+12\bin\java.exe
-Dfabric.dli.config=D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\launch.cfg
-Dfabric.dli.env=client
-Dfabric.dli.main=net.fabricmc.loader.impl.launch.knot.KnotClient
-javaagent:C:\Users\USERNAME\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\231.9011.34\lib\idea_rt.jar=51604:C:\Users\USERNAME\AppData\Local\JetBrains\Toolbox\apps\IDEA-U\ch-0\231.9011.34\bin
-Dfile.encoding=UTF-8
-classpath D:\IdeaProjects\OpenGLDebug\build\classes\java\main;
D:\IdeaProjects\OpenGLDebug\build\resources\main;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\tiny-mappings-parser\0.3.0+build.17\2f10540a290e382a7cd35c16ec3900046a4e252\tiny-mappings-parser-0.3.0+build.17.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\sponge-mixin\0.12.5+mixin.0.8.5\8d31fb97c3e0cd7c8dad3441851c523bcfae6d8e\sponge-mixin-0.12.5+mixin.0.8.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\tiny-remapper\0.8.2\2cc6565989469ec38893bfb7802b31c0d0d11ea0\tiny-remapper-0.8.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\access-widener\2.1.0\f62a27adbfd8ab4d4fa5681793039f2c0b177155\access-widener-2.1.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm\9.5\dc6ea1875f4d64fbc85e1691c95b96a3d8569c90\asm-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-analysis\9.5\490bacc77de7cbc0be1a30bb3471072d705be4a4\asm-analysis-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-commons\9.5\19ab5b5800a3910d30d3a3e64fdb00fd0cb42de0\asm-commons-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-tree\9.5\fd33c8b6373abaa675be407082fdfda35021254a\asm-tree-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.ow2.asm\asm-util\9.5\64b5a1fc8c1b15ed2efd6a063e976bc8d3dc5ffe\asm-util-9.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.github.oshi\oshi-core\6.2.2\54f5efc19bca95d709d9a37d19ffcbba3d21c1a6\oshi-core-6.2.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.code.gson\gson\2.10\dd9b193aef96e973d5a11ab13cd17430c2e4306b\gson-2.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.guava\failureaccess\1.0.1\1dcf1de382a0bf95a3d8b0849546c88bac1292c9\failureaccess-1.0.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.google.guava\guava\31.1-jre\60458f877d055d0c9114d9e1a2efb737b4bc282c\guava-31.1-jre.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.ibm.icu\icu4j\71.1\9e7d3304c23f9ba5cb71915f7cce23231a57a445\icu4j-71.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\authlib\4.0.43\2ff9d747a77570a07a60d32ac77eb6162ad2a2d9\authlib-4.0.43.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\blocklist\1.0.10\5c685c5ffa94c4cd39496c7184c1d122e515ecef\blocklist-1.0.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\brigadier\1.1.8\5244ce82c3337bba4a196a3ce858bfaecc74404a\brigadier-1.1.8.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\datafixerupper\6.0.8\3ba4a30557a9b057760af4011f909ba619fc5125\datafixerupper-6.0.8.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\logging\1.1.1\832b8e6674a9b325a5175a3a6267dfaf34c85139\logging-1.1.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\patchy\2.2.10\da05971b07cbb379d002cf7eaec6a2048211fefc\patchy-2.2.10.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\com.mojang\text2speech\1.17.9\3cad216e3a7f0c19b4b394388bc9ffc446f13b14\text2speech-1.17.9.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-codec\commons-codec\1.15\49d94806b6e3dc933dacbd8acb0fdbab8ebd1e5d\commons-codec-1.15.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-io\commons-io\2.11.0\a2503f302b11ebde7ebc3df41daebe0e4eea3689\commons-io-2.11.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\commons-logging\commons-logging\1.2\4bfc12adfe4842bf07b657f0369c4cb522955686\commons-logging-1.2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-buffer\4.1.82.Final\a544270cf1ae8b8077082f5036436a9a9971ea71\netty-buffer-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-codec\4.1.82.Final\b77200379acb345a9ffdece1c605e591ac3e4e0a\netty-codec-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-common\4.1.82.Final\22d148e85c3f5ebdacc0ce1f5aabb1d420f73f3\netty-common-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-handler\4.1.82.Final\644041d1fa96a5d3130a29e8978630d716d76e38\netty-handler-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-resolver\4.1.82.Final\38f665ae8dcd29032eea31245ba7806bed2e0fa8\netty-resolver-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-classes-epoll\4.1.82.Final\e7c7dd18deac93105797f30057c912651ea76521\netty-transport-classes-epoll-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-native-unix-common\4.1.82.Final\3e895b35ca1b8a0eca56cacff4c2dde5d2c6abce\netty-transport-native-unix-common-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport\4.1.82.Final\e431a218d91acb6476ccad5f5aafde50aa3945ca\netty-transport-4.1.82.Final.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\it.unimi.dsi\fastutil\8.5.9\bb7ea75ecdb216654237830b3a96d87ad91f8cc5\fastutil-8.5.9.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.java.dev.jna\jna-platform\5.12.1\97406a297c852f4a41e688a176ec675f72e8329\jna-platform-5.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.java.dev.jna\jna\5.12.1\b1e93a735caea94f503e95e6fe79bf9cdc1e985d\jna-5.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.sf.jopt-simple\jopt-simple\5.0.4\4fdac2fbe92dfad86aa6e9301736f6b4342a3f5c\jopt-simple-5.0.4.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-compress\1.21\4ec95b60d4e86b5c95a0e919cb172a0af98011ef\commons-compress-1.21.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.commons\commons-lang3\3.12.0\c6842c86792ff03b9f1d1fe2aab8dc23aa6c6f0e\commons-lang3-3.12.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.httpcomponents\httpclient\4.5.13\e5f6cae5ca7ecaac1ec2827a9e2d65ae2869cada\httpclient-4.5.13.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.httpcomponents\httpcore\4.4.15\7f2e0c573eaa7a74bac2e89b359e1f73d92a0a1d\httpcore-4.4.15.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-api\2.19.0\ea1b37f38c327596b216542bc636cfdc0b8036fa\log4j-api-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-core\2.19.0\3b6eeb4de4c49c0fe38a4ee27188ff5fee44d0bb\log4j-core-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.apache.logging.log4j\log4j-slf4j2-impl\2.19.0\5c04bfdd63ce9dceb2e284b81e96b6a70010ee10\log4j-slf4j2-impl-2.19.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.joml\joml\1.10.5\22566d58af70ad3d72308bab63b8339906deb649\joml-1.10.5.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\cbac1b8d30cb4795149c1ef540f912671a8616d0\lwjgl-glfw-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\a817bcf213db49f710603677457567c37d53e103\lwjgl-jemalloc-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\2623a6b8ae1dfcd880738656a9f0243d2e6840bd\lwjgl-openal-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\831a5533a21a5f4f81bbc51bb13e9899319b5411\lwjgl-opengl-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\b119297cf8ed01f247abe8685857f8e7fcf5980f\lwjgl-stb-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\ff1914111ef2e3e0110ef2dabc8d8cdaad82347\lwjgl-tinyfd-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\ae58664f88e18a9bb2c77b063833ca7aaec484cb\lwjgl-3.3.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.slf4j\slf4j-api\2.0.1\f48d81adce2abf5ad3cfe463df517952749e03bc\slf4j-api-2.0.1.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\minecraftMaven\net\minecraft\minecraft-merged-project-root\1.20.1-loom.mappings.1_20_1.layered+hash.2198-v2\minecraft-merged-project-root-1.20.1-loom.mappings.1_20_1.layered+hash.2198-v2.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-native-epoll\4.1.82.Final\476409d6255001ca53a55f65b01c13822f8dc93a\netty-transport-native-epoll-4.1.82.Final-linux-aarch_64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\io.netty\netty-transport-native-epoll\4.1.82.Final\c7350a71920f3ae9142945e25fed4846cce53374\netty-transport-native-epoll-4.1.82.Final-linux-x86_64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\fabric-loader\0.14.22\9dd26439963a78e6ff7be3614c2151a50f9254a3\fabric-loader-0.14.22.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-api\0.88.1+1.20.1\fabric-api-0.88.1+1.20.1.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-transfer-api-v1\3.3.1+195226a777\fabric-transfer-api-v1-3.3.1+195226a777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-api-lookup-api-v1\1.6.35+4d8536c977\fabric-api-lookup-api-v1-1.6.35+4d8536c977.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-blockrenderlayer-v1\1.1.40+b3afc78b77\fabric-blockrenderlayer-v1-1.1.40+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-client-tags-api-v1\1.1.1+97bb207577\fabric-client-tags-api-v1-1.1.1+97bb207577.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-command-api-v1\1.2.33+f71b366f77\fabric-command-api-v1-1.2.33+f71b366f77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-commands-v0\0.2.50+df3654b377\fabric-commands-v0-0.2.50+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-command-api-v2\2.2.12+b3afc78b77\fabric-command-api-v2-2.2.12+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-content-registries-v0\4.0.9+b3afc78b77\fabric-content-registries-v0-4.0.9+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-convention-tags-v1\1.5.4+a1a980da77\fabric-convention-tags-v1-1.5.4+a1a980da77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-data-generation-api-v1\12.2.2+1e61dba177\fabric-data-generation-api-v1-12.2.2+1e61dba177.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-dimensions-v1\2.1.53+8536527b77\fabric-dimensions-v1-2.1.53+8536527b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-entity-events-v1\1.5.22+b3afc78b77\fabric-entity-events-v1-1.5.22+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-events-interaction-v0\0.6.1+e91849a877\fabric-events-interaction-v0-0.6.1+e91849a877.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-gametest-api-v1\1.2.12+b3afc78b77\fabric-gametest-api-v1-1.2.12+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-events-lifecycle-v0\0.2.62+df3654b377\fabric-events-lifecycle-v0-0.2.62+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-item-api-v1\2.1.27+b3afc78b77\fabric-item-api-v1-2.1.27+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-item-group-api-v1\4.0.10+23d9108177\fabric-item-group-api-v1-4.0.10+23d9108177.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-mining-level-api-v1\2.1.49+b3afc78b77\fabric-mining-level-api-v1-2.1.49+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-lifecycle-events-v1\2.2.21+b3afc78b77\fabric-lifecycle-events-v1-2.2.21+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-loot-tables-v1\1.1.43+9e7660c677\fabric-loot-tables-v1-1.1.43+9e7660c677.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-loot-api-v2\1.1.39+b3afc78b77\fabric-loot-api-v2-1.1.39+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-message-api-v1\5.1.7+3265161977\fabric-message-api-v1-5.1.7+3265161977.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-models-v0\0.4.1+9386d8a777\fabric-models-v0-0.4.1+9386d8a777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-model-loading-api-v1\1.0.2+709a987177\fabric-model-loading-api-v1-1.0.2+709a987177.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-recipe-api-v1\1.0.20+b3afc78b77\fabric-recipe-api-v1-1.0.20+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-registry-sync-v0\2.3.2+4df89eb277\fabric-registry-sync-v0-2.3.2+4df89eb277.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-screen-handler-api-v1\1.3.29+b3afc78b77\fabric-screen-handler-api-v1-1.3.29+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-containers-v0\0.1.63+df3654b377\fabric-containers-v0-0.1.63+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-networking-v0\0.3.50+df3654b377\fabric-networking-v0-0.3.50+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-networking-api-v1\1.3.10+eeb8eb3677\fabric-networking-api-v1-1.3.10+eeb8eb3677.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-object-builder-api-v1\11.1.1+6beca84877\fabric-object-builder-api-v1-11.1.1+6beca84877.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-particles-v1\1.1.1+201a23a077\fabric-particles-v1-1.1.1+201a23a077.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-renderer-indigo\1.4.3+6bdb2ed077\fabric-renderer-indigo-1.4.3+6bdb2ed077.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-renderer-api-v1\3.1.3+92a0d36777\fabric-renderer-api-v1-3.1.3+92a0d36777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-rendering-fluids-v1\3.0.27+b3afc78b77\fabric-rendering-fluids-v1-3.0.27+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-renderer-registries-v1\3.2.45+df3654b377\fabric-renderer-registries-v1-3.2.45+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-rendering-v0\1.1.48+df3654b377\fabric-rendering-v0-1.1.48+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-rendering-v1\3.0.7+b3afc78b77\fabric-rendering-v1-3.0.7+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-screen-api-v1\2.0.7+b3afc78b77\fabric-screen-api-v1-2.0.7+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-api-base\0.4.30+7abfd51577\fabric-api-base-0.4.30+7abfd51577.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-biome-api-v1\13.0.10+b3afc78b77\fabric-biome-api-v1-13.0.10+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-block-api-v1\1.0.10+92a0d36777\fabric-block-api-v1-1.0.10+92a0d36777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-rendering-data-attachment-v1\0.3.36+92a0d36777\fabric-rendering-data-attachment-v1-0.3.36+92a0d36777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-block-view-api-v2\1.0.0+92a0d36777\fabric-block-view-api-v2-1.0.0+92a0d36777.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-crash-report-info-v1\0.2.18+aeb40ebe77\fabric-crash-report-info-v1-0.2.18+aeb40ebe77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-game-rule-api-v1\1.0.38+b04edc7a77\fabric-game-rule-api-v1-1.0.38+b04edc7a77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-keybindings-v0\0.2.34+df3654b377\fabric-keybindings-v0-0.2.34+df3654b377.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-key-binding-api-v1\1.0.36+fb8d95da77\fabric-key-binding-api-v1-1.0.36+fb8d95da77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-resource-conditions-api-v1\2.3.5+ea08f9d877\fabric-resource-conditions-api-v1-2.3.5+ea08f9d877.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-resource-loader-v0\0.11.9+132c48c177\fabric-resource-loader-v0-0.11.9+132c48c177.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-sound-api-v1\1.0.12+b3afc78b77\fabric-sound-api-v1-1.0.12+b3afc78b77.jar;
D:\IdeaProjects\OpenGLDebug\.gradle\loom-cache\remapped_mods\loom_mappings_1_20_1_layered_hash_2198_v2\net\fabricmc\fabric-api\fabric-transitive-access-wideners-v1\4.3.0+6c31357e77\fabric-transitive-access-wideners-v1-4.3.0+6c31357e77.jar;
C:\Users\USERNAME\.gradle\caches\fabric-loom\1.20.1\loom.mappings.1_20_1.layered+hash.2198-v2\mappings.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.fabricmc\dev-launch-injector\0.2.1+build.8\da8bef7e6e2f952da707f282bdb46882a0fce5e3\dev-launch-injector-0.2.1+build.8.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\net.minecrell\terminalconsoleappender\1.2.0\96d02cd3b384ff015a8fef4223bcb4ccf1717c95\terminalconsoleappender-1.2.0.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\ed892f945cf7e79c8756796f32d00fa4ceaf573b\lwjgl-glfw-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\beda65ee503443e60aa196d58ed31f8d001dc22a\lwjgl-glfw-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-glfw\3.3.1\b997e3391d6ce8f05487e7335d95c606043884a1\lwjgl-glfw-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\948a89b76a16aa324b046ae9308891216ffce5f9\lwjgl-jemalloc-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\cae85c4edb219c88b6a0c26a87955ad98dc9519d\lwjgl-jemalloc-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-jemalloc\3.3.1\fb476c8ec110e1c137ad3ce8a7f7bfe6b11c6324\lwjgl-jemalloc-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\30a474d0e57193d7bc128849a3ab66bc9316fdb1\lwjgl-openal-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\40d65f1a7368a2aa47336f9cb69f5a190cf9975a\lwjgl-openal-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-openal\3.3.1\888349f7b1be6fbae58bf8edfb9ef12def04c4e3\lwjgl-openal-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\c1807e9bd571402787d7e37e3029776ae2513bb8\lwjgl-opengl-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\527d78f1e9056aff3ed02ce93019c73c5e8f1721\lwjgl-opengl-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-opengl\3.3.1\deef3eb9b178ff2ff3ce893cc72ae741c3a17974\lwjgl-opengl-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\86315914ac119efdb02dc9e8e978ade84f1702af\lwjgl-stb-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\fde63cdd2605c00636721a6c8b961e41d1f6b247\lwjgl-stb-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-stb\3.3.1\a8d41f419eecb430b7c91ea2ce2c5c451cae2091\lwjgl-stb-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\a5d830475ec0958d9fdba1559efa99aef211e6ff\lwjgl-tinyfd-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\83a5e780df610829ff3a737822b4f931cffecd91\lwjgl-tinyfd-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl-tinyfd\3.3.1\842eedd876fae354abc308c98a263f6bbc9e8a4d\lwjgl-tinyfd-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\36c37f16ab611b3aa11f3bcf80b1d509b4ce6b\lwjgl-3.3.1-natives-windows.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\f46cadcf95675908fd3a550d63d9d709cb68998\lwjgl-3.3.1-natives-windows-arm64.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.lwjgl\lwjgl\3.3.1\3b14f4beae9dd39791ec9e12190a9380cd8a3ce6\lwjgl-3.3.1-natives-windows-x86.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.jline\jline-reader\3.12.1\4382ab1382c7b6f379377ed5f665dc2f6e1218bc\jline-reader-3.12.1.jar;
C:\Users\USERNAME\.gradle\caches\modules-2\files-2.1\org.jline\jline-terminal\3.12.1\c777448314e050d980a6b697c140f3bfe9eb7416\jline-terminal-3.12.1.jar net.fabricmc.devlaunchinjector.Main
```
</details>

However, you can count on your particular command-line launch configuration being different than mine, so don't copy the example above. These will always be generated by your Gradle toolchain and will reference libraries specific to your mod project.

----

2. RenderDoc:
   1. In the "Launch Application" tab, there are 4 fields required filling: Executable Path, Working Directory, Command-line Arguments, and Environment Variables.
   2. Executable Path: This is for the `java.exe` executable, which will be the very first term in your launch command.
      - From my examples above, this would be `C:\Users\USERNAME\.gradle\jdks\jdk-17.0.1+12\bin\java.exe`
   3. Working Directory: In IntelliJ, open your launch configuration settings and copy exactly from the "Working directory" field.
   4. Command-line Arguments: This is the massive block of text coming after the `java.exe` executable in the launch command. Copy over everything coming after the `java.exe` term.
      - Make sure you're not pasting directly from the examples here! It is an almost guarantee that will not work.
   5. Environment Variables: These are also copied from the IntelliJ client launch settings. For Fabric these will be empty, but for Forge there will be two you will need to copy; `MCP_MAPPINGS` and `MOD_CLASSES`.
      - These can be different depending on Parchment or if the project uses multi-modloader/Architectury.
   6. Save the launch settings in RenderDoc, so they can be re-used after re-opening RenderDoc.

----

3. Rebuild your project in the IDE (IntelliJ shortcut: `control` + `F9`) to re-compile the code after any changes to code or assets before launching, to ensure the changes take effect in your RenderDoc launch.
   - If there are any changes to the library versions or the launch configurations, you must re-copy the client launch configuration into RenderDoc. It will be all the same steps. Once you've repeated this process a few times, it'll feel quick and natural.

----

## Reference Links
### Renderdoc documentation:
- Getting started with RenderDoc https://renderdoc.org/docs/getting_started/quick_start.html
- Annotating RenderDoc captures https://renderdoc.org/docs/how/how_annotate_capture.html (mentions all graphics APIs including OpenGL)

### Further info on annotating captures:
- OpenGL-specific annotating https://www.khronos.org/opengl/wiki/Debug_Output

### Running Renderdoc:
- Another guide for launching Minecraft with RenderDoc: https://gist.github.com/T3sT3ro/e43b714ee6ca97ec4b0cb65fc606ffac
  - Linked by the guide: https://lwjglgamedev.gitbooks.io/3d-game-development-with-lwjgl/content/appendixa/appendixa.html
