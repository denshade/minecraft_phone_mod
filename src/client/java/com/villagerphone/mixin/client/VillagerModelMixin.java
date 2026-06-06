package com.villagerphone.mixin.client;

import net.minecraft.client.model.npc.VillagerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerModel.class)
public abstract class VillagerModelMixin {
	@Shadow
	@Final
	private ModelPart head;

	@Shadow
	@Final
	private ModelPart arms;

	@Inject(method = "setupAnim", at = @At("TAIL"))
	private void villagerphone$phoneWatchingPose(VillagerRenderState state, CallbackInfo ci) {
		if (state.heldItem.isEmpty()) {
			return;
		}

		this.arms.xRot = -1.15F;
		this.arms.yRot = 0.0F;
		this.arms.zRot = 0.0F;

		this.head.xRot = Mth.clamp(this.head.xRot + 0.6F, -1.2F, 1.2F);
		this.head.yRot *= 0.2F;
	}
}
