package com.villagerphone.mixin;

import com.villagerphone.VillagerPhoneMod;
import com.villagerphone.item.ModItems;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
public abstract class VillagerMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void villagerphone$keepPhoneEquipped(CallbackInfo ci) {
		Villager villager = (Villager) (Object) this;
		ItemStack mainHand = villager.getMainHandItem();

		if (!mainHand.is(ModItems.PHONE)) {
			VillagerPhoneMod.equipPhone(villager);
		}
	}
}
