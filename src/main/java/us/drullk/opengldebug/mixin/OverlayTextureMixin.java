package us.drullk.opengldebug.mixin;

import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin {
    @Shadow
    @Final
    private DynamicTexture texture;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void addDebugName(CallbackInfo ci) {
        // This texture is never given a name while the lightmap is, kinda funky
        GLDebugHelper.setTextureDebugName("Overlay texture", this.texture);
    }
}
