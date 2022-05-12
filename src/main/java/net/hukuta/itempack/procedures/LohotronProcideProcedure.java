package net.hukuta.itempack.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.gui.components.EditBox;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class LohotronProcideProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getItem() == Items.DIAMOND) {
			if (Mth.nextInt(new Random(), 1, 10) >= 6) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(Items.DIAMOND);
					_setstack.setCount(2);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (guistate.get("text:loh") instanceof EditBox _tf)
					_tf.setValue("\u041F\u043E\u0432\u0435\u0437\u043B\u043E!");
			} else {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (guistate.get("text:loh") instanceof EditBox _tf)
					_tf.setValue("\u041D\u0435\u043F\u043E\u0432\u0435\u0437\u043B\u043E");
			}
		} else {
			if (guistate.get("text:loh") instanceof EditBox _tf)
				_tf.setValue("\u041D\u0443\u0436\u0435\u043D \u0410\u043B\u043C\u0430\u0437");
		}
	}
}
