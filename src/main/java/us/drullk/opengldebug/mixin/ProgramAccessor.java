package us.drullk.opengldebug.mixin;

import com.mojang.blaze3d.shaders.Program;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Program.class)
public interface ProgramAccessor {
    @Accessor("id")
    public int id();
}
