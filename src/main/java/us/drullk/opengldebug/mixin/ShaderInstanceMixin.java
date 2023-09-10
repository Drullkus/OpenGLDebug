package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.preprocessor.GlslPreprocessor;
import com.mojang.blaze3d.shaders.Program;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.opengl.KHRDebug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.drullk.opengldebug.GLDebugHelper;

import java.io.IOException;
import java.io.InputStream;

@Mixin(ShaderInstance.class)
public abstract class ShaderInstanceMixin {
    @Shadow
    public abstract int getId();

    @Shadow public abstract String getName();

    @Inject(method = "updateLocations", at = @At(value = "TAIL"))
    private void addDebugNames(CallbackInfo ci) {
        var location = new ResourceLocation(this.getName());
        var label = "minecraft".equals(location.getNamespace())
                ? ("shaders/core/" + location.getPath() + ".json")
                : (location.getNamespace() + ":shaders/core/" + location.getPath() + ".json");
        GLDebugHelper.label(label, KHRDebug.GL_PROGRAM, this.getId());
    }

    @Redirect(method = "getOrCreate", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/shaders/Program;compileShader(Lcom/mojang/blaze3d/shaders/Program$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;Lcom/mojang/blaze3d/preprocessor/GlslPreprocessor;)Lcom/mojang/blaze3d/shaders/Program;"))
    private static Program addDebugProgramName(Program.Type type, String string, InputStream inputStream, String sourcePackId, GlslPreprocessor glslPreprocessor) throws IOException {
        var prog = Program.compileShader(type, string, inputStream, sourcePackId, glslPreprocessor);

        if ("vanilla".equals(sourcePackId)) {
            GLDebugHelper.label("shaders/core/" + string + type.getExtension(), KHRDebug.GL_SHADER, ((ProgramAccessor) prog).id());
        } else {
            GLDebugHelper.label(sourcePackId + ":shaders/core/" + string + type.getExtension(), KHRDebug.GL_SHADER, ((ProgramAccessor) prog).id());
        }

        return prog;
    }
}
