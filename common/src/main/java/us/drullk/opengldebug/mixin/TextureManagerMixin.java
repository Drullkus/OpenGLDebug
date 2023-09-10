package us.drullk.opengldebug.mixin;

import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(TextureManager.class)
public class TextureManagerMixin {
    @Inject(method = "loadTexture", at = @At(value = "RETURN", shift = At.Shift.BEFORE))
    private void addDebugName(ResourceLocation resourceLocation, AbstractTexture abstractTexture, CallbackInfoReturnable<AbstractTexture> cir) {
        GLDebugHelper.setTextureDebugName(resourceLocation.toString().replace("minecraft:", ""), abstractTexture);
    }
}
