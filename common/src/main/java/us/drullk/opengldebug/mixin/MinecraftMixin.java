package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow
    public abstract RenderTarget getMainRenderTarget();

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void nameMain(GameConfig gameConfig, CallbackInfo ci) {
        GLDebugHelper.setFBODebugNames(this.getMainRenderTarget(), "Minecraft main");
    }

    @Inject(method = "runTick", at = @At(value = "HEAD"))
    private void resetCounter(boolean b, CallbackInfo ci) {
        GLDebugHelper.resetCounter();
    }
}
