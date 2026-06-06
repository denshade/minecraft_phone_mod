package com.villagerphone.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.villagerphone.client.PhoneHoldingState;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.state.HoldingEntityRenderState;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrossedArmsItemLayer.class)
public abstract class CrossedArmsItemLayerMixin {
	@Inject(method = "applyTranslation", at = @At("RETURN"))
	private void villagerphone$adjustPhonePose(HoldingEntityRenderState state, PoseStack poseStack, CallbackInfo ci) {
		if (!(state instanceof VillagerRenderState villagerState) || state.heldItem.isEmpty()) {
			return;
		}

		if (!((PhoneHoldingState) villagerState).villagerphone$holdingPhone()) {
			return;
		}

		// Nudge the phone flat toward the villager's face after vanilla arm positioning.
		poseStack.scale(0.55F, 0.55F, 0.55F);
		poseStack.mulPose(Axis.YP.rotation((float) Math.PI));
		poseStack.mulPose(Axis.XP.rotation(-0.55F));
		poseStack.translate(0.0F, 0.12F, 0.06F);
	}
}
