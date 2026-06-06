package com.villagerphone;

import com.villagerphone.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VillagerPhoneMod implements ModInitializer {
	public static final String MOD_ID = "villagerphone";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();

		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof Villager villager) {
				equipPhone(villager);
			}
		});

		LOGGER.info("Villagers have discovered smartphones. Productivity in villages is expected to drop 100%.");
	}

	public static void equipPhone(Villager villager) {
		ItemStack phone = new ItemStack(ModItems.PHONE);
		phone.setCount(1);
		villager.setItemSlot(EquipmentSlot.MAINHAND, phone);
	}
}
