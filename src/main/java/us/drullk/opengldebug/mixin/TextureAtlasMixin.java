package us.drullk.opengldebug.mixin;

import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.SpriteLoader;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(TextureAtlas.class)
public abstract class TextureAtlasMixin extends AbstractTexture {
    @Shadow
    public abstract ResourceLocation location();

    @Inject(method = "upload", at = @At(value = "TAIL"))
    private void addDebugName(SpriteLoader.Preparations preparations, CallbackInfo ci) {
        GLDebugHelper.setTextureDebugName(this.location().toString(), this);
    }
}
