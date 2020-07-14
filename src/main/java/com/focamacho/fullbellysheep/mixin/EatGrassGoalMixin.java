package com.focamacho.fullbellysheep.mixin;

import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EatGrassGoal.class)
public class EatGrassGoalMixin {

	@Shadow @Final private MobEntity mob;

	@Inject(method = "canStart", at = @At("HEAD"), cancellable = true)
	private void canStart(CallbackInfoReturnable<Boolean> info) {
		if(this.mob instanceof SheepEntity) {
			if(!((SheepEntity)this.mob).isSheared()) {
				info.setReturnValue(false);
			}
		}
	}
}
