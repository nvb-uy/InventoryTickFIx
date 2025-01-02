package elocindev.offhandtickfix.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import elocindev.offhandtickfix.config.Configs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    public void offhandtickfix$offHandInventoryTick(CallbackInfo ci) {
        LivingEntity ths = (LivingEntity) (Object) this;

        var stack = ths.getOffHandStack();
        
        if (!stack.isEmpty()) {
            for (String regex : Configs.MAIN.tick_regex) {
                if (Registries.ITEM.getId(stack.getItem()).toString().matches(regex)) {
                    // https://minecraft.fandom.com/wiki/Slot 99 seems to be off hand slot
                    stack.inventoryTick(ths.getWorld(), ths, 99, false);
                    return;
                }
            }
        }
    }
}
