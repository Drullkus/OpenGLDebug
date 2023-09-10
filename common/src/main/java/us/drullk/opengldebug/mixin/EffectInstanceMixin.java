package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.shaders.EffectProgram;
import com.mojang.blaze3d.shaders.Program;
import net.minecraft.client.renderer.EffectInstance;
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

@Mixin(EffectInstance.class)
public abstract class EffectInstanceMixin {
    @Shadow
    public abstract int getId();

    @Shadow public abstract String getName();

    @Inject(method = "updateLocations", at = @At(value = "TAIL"))
    private void addDebugNames(CallbackInfo ci) {
        var location = new ResourceLocation(this.getName());
        var label = "minecraft".equals(location.getNamespace())
                ? ("shaders/program/" + location.getPath() + ".json")
                : (location.getNamespace() + ":shaders/program/" + location.getPath() + ".json");
        GLDebugHelper.label(label, KHRDebug.GL_PROGRAM, this.getId());
    }

    @Redirect(method = "getOrCreate", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/shaders/EffectProgram;compileShader(Lcom/mojang/blaze3d/shaders/Program$Type;Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Lcom/mojang/blaze3d/shaders/EffectProgram;"))
    private static EffectProgram addDebugProgramName(Program.Type type, String string, InputStream inputStream, String sourcePackId) throws IOException {
        var prog = EffectProgram.compileShader(type, string, inputStream, sourcePackId);

        if ("vanilla".equals(sourcePackId)) {
            GLDebugHelper.label("shaders/program/" + string + type.getExtension(), KHRDebug.GL_SHADER, ((ProgramAccessor) prog).id());
        } else {
            GLDebugHelper.label(sourcePackId + ":shaders/program/" + string + type.getExtension(), KHRDebug.GL_SHADER, ((ProgramAccessor) prog).id());
        }

        return prog;
    }
}
