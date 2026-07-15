package net.mcreator.cobblestone.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.cobblestone.world.inventory.HammerMachineGUIMenu;
import net.mcreator.cobblestone.procedures.SetHammerSpriteProcedure;
import net.mcreator.cobblestone.init.CobblestoneModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class HammerMachineGUIScreen extends AbstractContainerScreen<HammerMachineGUIMenu> implements CobblestoneModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("cobblestone:textures/screens/hammer_machine_gui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("cobblestone:textures/screens/guihammer.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("cobblestone:textures/screens/gh.png");

	public HammerMachineGUIScreen(HammerMachineGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 80, this.topPos + 55, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(SPRITE_0, this.leftPos + 80, this.topPos + 33, Mth.clamp((int) SetHammerSpriteProcedure.execute(world, x, y, z) * 16, 0, 32), 0, 16, 16, 48, 16);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}