package us.drullk.opengldebug;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.renderer.texture.AbstractTexture;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.KHRDebug;

public final class GLDebugHelper {
    //public static final Logger LOGGER = LogUtils.getLogger();

    public static void setTextureDebugName(String name, AbstractTexture texture) {
        setTextureDebugName(name, texture.getId());
    }

    public static void setTextureDebugName(String texture, int id) {
        String name = texture.replace(".png", "");
        label(name, GL30.GL_TEXTURE, id);
    }

    public static void setFBODebugNames(RenderTarget renderTarget, String name) {
        if (renderTarget instanceof NameableRenderTarget namedRenderTarget)
            namedRenderTarget.setDebugName(name);

        labelFBO(renderTarget, name.replace("minecraft:", ""));
    }

    public static void onFBOResize(RenderTarget renderTarget) {
        if (!(renderTarget instanceof NameableRenderTarget namedRenderTarget)) return;

        String name = namedRenderTarget.getDebugName();

        if (name.isBlank()) return;

        labelFBO(renderTarget, name.replace("minecraft:", ""));
    }

    private static void labelFBO(RenderTarget renderTarget, String name) {
        label(name + " FBO", GL30.GL_FRAMEBUFFER, renderTarget.frameBufferId);
        label(name + " Color", GL30.GL_TEXTURE, renderTarget.getColorTextureId());
        label(name + " Depth", GL30.GL_TEXTURE, renderTarget.getDepthTextureId());
    }

    public static void label(String name, int glEnum, int idName) {
        if (idName > -1)
            KHRDebug.glObjectLabel(glEnum, idName, name);

        //LOGGER.info(name + ": " + idName);
    }
}
