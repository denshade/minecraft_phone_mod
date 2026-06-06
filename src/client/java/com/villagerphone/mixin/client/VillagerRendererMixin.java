package com.villagerphone.mixin.client;

import com.villagerphone.client.PhoneHoldingState;
import com.villagerphone.item.ModItems;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.state.HoldingEntityRenderState;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.item.ItemDisplayContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VillagerRenderer.class)
public abstract class VillagerRendererMixin {
	@Redirect(
			method = "extractRenderState",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/renderer/entity/state/HoldingEntityRenderState;extractHoldingEntityRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/HoldingEntityRenderState;Lnet/minecraft/client/renderer/item/ItemModelResolver;)V"
			)
	)
	private void villagerphone$phoneDisplayContext(
			LivingEntity entity,
			HoldingEntityRenderState state,
			ItemModelResolver resolver
	) {
		if (!(entity instanceof Villager villager) || !(state instanceof VillagerRenderState villagerState)) {
			HoldingEntityRenderState.extractHoldingEntityRenderState(entity, state, resolver);
			return;
		}

		boolean holdingPhone = villager.getMainHandItem().is(ModItems.PHONE);
		((PhoneHoldingState) villagerState).villagerphone$setHoldingPhone(holdingPhone);

		if (holdingPhone) {
			villagerState.heldItem.clear();
			resolver.updateForLiving(villagerState.heldItem, villager.getMainHandItem(), ItemDisplayContext.FIXED, villager);
		} else {
			HoldingEntityRenderState.extractHoldingEntityRenderState(entity, state, resolver);
		}
	}
}
