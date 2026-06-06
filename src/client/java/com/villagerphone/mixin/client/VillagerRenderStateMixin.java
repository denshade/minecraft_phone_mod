package com.villagerphone.mixin.client;

import com.villagerphone.client.PhoneHoldingState;
import net.minecraft.client.renderer.entity.state.VillagerRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(VillagerRenderState.class)
public class VillagerRenderStateMixin implements PhoneHoldingState {
	@Unique
	private boolean villagerphone$holdingPhone;

	@Override
	public boolean villagerphone$holdingPhone() {
		return this.villagerphone$holdingPhone;
	}

	@Override
	public void villagerphone$setHoldingPhone(boolean holdingPhone) {
		this.villagerphone$holdingPhone = holdingPhone;
	}
}
