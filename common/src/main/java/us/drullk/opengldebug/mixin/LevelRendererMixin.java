package us.drullk.opengldebug.mixin;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import us.drullk.opengldebug.GLDebugHelper;

import java.util.function.Supplier;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V"))
    private void debugAmongPopPush(ProfilerFiller instance, String s) {
        GLDebugHelper.popMessageGroup();
        instance.popPush(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "renderChunkLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V"))
    private void renderChunkLayerPush(ProfilerFiller instance, String s) {
        instance.push(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "renderChunkLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/util/function/Supplier;)V"))
    private void renderChunkLayerDebugPopPush(ProfilerFiller instance, Supplier<String> stringSupplier) {
        GLDebugHelper.popMessageGroup();
        instance.popPush(stringSupplier);
        GLDebugHelper.pushMessageGroupFromProfiler(stringSupplier.get());
    }

    @Redirect(method = "renderChunkLayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V"))
    private void renderChunkLayerPop(ProfilerFiller instance) {
        GLDebugHelper.popMessageGroup();
        instance.pop();
    }
}
