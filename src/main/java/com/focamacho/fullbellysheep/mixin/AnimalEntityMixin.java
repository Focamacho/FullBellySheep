package com.focamacho.fullbellysheep.mixin;

import com.focamacho.fullbellysheep.config.ConfigHolder;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimalEntity.class)
public class AnimalEntityMixin {

    @Inject(method = "isBreedingItem", at = @At("HEAD"), cancellable = true)
    private void isBreedingItem(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if((Object)this instanceof SheepEntity) {
            Item item = stack.getItem();
            if(item.equals(Items.GRASS) || item.equals(Items.TALL_GRASS)) info.setReturnValue(true);
        }
    }

    @Inject(method = "eat", at = @At("HEAD"))
    private void eat(PlayerEntity player, ItemStack stack, CallbackInfo info) {
        if((Object)this instanceof SheepEntity) {
            Item item = stack.getItem();
            SheepEntity sheep = (SheepEntity) (Object) this;
            if(ConfigHolder.restoreWool && (item.equals(Items.GRASS) || item.equals(Items.TALL_GRASS)) && sheep.isSheared() && !sheep.isInLove()) sheep.setSheared(false);
        }
    }

}
