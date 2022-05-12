
package net.hukuta.itempack.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.hukuta.itempack.world.inventory.LohotronGUIMenu;
import net.hukuta.itempack.network.LohotronGUIButtonMessage;
import net.hukuta.itempack.HukutaItemPackMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LohotronGUIScreen extends AbstractContainerScreen<LohotronGUIMenu> {
	private final static HashMap<String, Object> guistate = LohotronGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox loh;

	public LohotronGUIScreen(LohotronGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("hukuta_item_pack:textures/lohotron_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		loh.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (loh.isFocused())
			return loh.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		loh.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "\u041B\u043E\u0445\u043E\u0442\u0440\u043E\u043D 3000", 53, 8, -12829636);
		this.font.draw(poseStack, "\u0412\u0445\u043E\u0434", 22, 48, -12829636);
		this.font.draw(poseStack, "\u0412\u044B\u0445\u043E\u0434", 128, 48, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 59, this.topPos + 58, 56, 20, new TextComponent("Выйграть!"), e -> {
			if (true) {
				HukutaItemPackMod.PACKET_HANDLER.sendToServer(new LohotronGUIButtonMessage(0, x, y, z));
				LohotronGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		loh = new EditBox(this.font, this.leftPos + 27, this.topPos + -26, 120, 20, new TextComponent(""));
		guistate.put("text:loh", loh);
		loh.setMaxLength(32767);
		this.addWidget(this.loh);
	}
}
