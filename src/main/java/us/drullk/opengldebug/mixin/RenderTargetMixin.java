package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.pipeline.RenderTarget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import us.drullk.opengldebug.GLDebugHelper;
import us.drullk.opengldebug.NameableRenderTarget;

@Mixin(RenderTarget.class)
public class RenderTargetMixin implements NameableRenderTarget {
    @Unique
    private String name = "";

    @Override
    public String getDebugName() {
        return this.name;
    }

    @Override
    public void setDebugName(String name) {
        this.name = name;
    }

    @Inject(method = "createBuffers", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/pipeline/RenderTarget;clear(Z)V", shift = At.Shift.BEFORE))
    private void onResize(int w, int h, boolean onOsx, CallbackInfo ci) {
        GLDebugHelper.onFBOResize((RenderTarget) (Object) this);
    }
}
