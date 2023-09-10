package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.renderer.PostChain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(PostChain.class)
public abstract class PostChainMixin {
    @Shadow
    public abstract String getName();

    @Inject(method = "addTempTarget", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void addDebugNames(String string, int i, int j, CallbackInfo ci, RenderTarget renderTarget) {
        GLDebugHelper.setFBODebugNames(renderTarget, this.getName().replace(".json", "") + " [Target: " + string + "]");
    }
}
