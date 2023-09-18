package us.drullk.opengldebug.mixin;

import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import us.drullk.opengldebug.GLDebugHelper;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V"))
    private void renderDebugPush(ProfilerFiller instance, String s) {
        instance.push(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V"))
    private void renderDebugPopPush(ProfilerFiller instance, String s) {
        GLDebugHelper.popMessageGroup();
        instance.popPush(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V"))
    private void renderDebugPop(ProfilerFiller instance) {
        GLDebugHelper.popMessageGroup();
        instance.pop();
    }

    @Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;push(Ljava/lang/String;)V"))
    private void renderLevelDebugPush(ProfilerFiller instance, String s) {
        instance.push(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V"))
    private void renderLevelDebugPopPush(ProfilerFiller instance, String s) {
        GLDebugHelper.popMessageGroup();
        instance.popPush(s);
        GLDebugHelper.pushMessageGroupFromProfiler(s);
    }

    @Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V"))
    private void renderLevelDebugPop(ProfilerFiller instance) {
        GLDebugHelper.popMessageGroup();
        instance.pop();
    }
}
