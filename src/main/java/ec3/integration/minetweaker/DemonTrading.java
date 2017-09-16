package ec3.integration.minetweaker;

import java.util.ArrayList;
import java.util.List;

import ec3.api.DemonTrade;
import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.essentialcraft.DemonTrade")
public class DemonTrading {

	@ZenMethod
	public static void addRecipe(IItemStack input) {
		if(input == null) {
			MineTweakerAPI.logError("Cannot turn "+input+" into a Demon Trade");
			return;
		}

		MineTweakerAPI.apply(new AddRecipeAction(MineTweakerMC.getItemStack(input)));
	}

	@ZenMethod
	public static void addRecipe(String input) {
		if(input == null) {
			MineTweakerAPI.logError("Cannot turn "+input+" into a Demon Trade");
			return;
		}

		boolean flag = true;
		for(Class<? extends Entity> e : DemonTrade.allMobs) {
			if(EntityList.NAME_TO_CLASS.get(input).equals(e)) {
				flag = false;
				break;
			}
		}
		if(flag)
			MineTweakerAPI.apply(new AddEntityRecipeAction(input));
		else
			MineTweakerAPI.logWarning("Recipe already exists!");
	}

	@ZenMethod
	public static void removeRecipe(IItemStack input) {
		if(input == null) {
			MineTweakerAPI.logError("Input cannot be null");
			return;
		}
		ArrayList<DemonTrade> toRemove = new ArrayList<DemonTrade>();
		DemonTrade.trades.stream().filter((entry) -> {
			return input.matches(MineTweakerMC.getIItemStack(entry.desiredItem));
		}).forEach((entry) -> {
			toRemove.add(entry);
		});

		if(toRemove.isEmpty())
			MineTweakerAPI.logWarning("No recipe for "+input.toString());
		else
			MineTweakerAPI.apply(new RemoveRecipeAction(toRemove));
	}

	@ZenMethod
	public static void removeRecipe(String input) {
		if(input == null) {
			MineTweakerAPI.logError("Input cannot be null");
			return;
		}

		DemonTrade toRemove = null;
		toRemove = DemonTrade.trades.stream().filter((entry) -> {
			return entry.entityType != null && EntityList.CLASS_TO_NAME.get(entry.entityType).equals(input);
		}).findFirst().get();

		if(toRemove == null)
			MineTweakerAPI.logWarning("No recipe for "+input);
		else
			MineTweakerAPI.apply(new RemoveEntityRecipeAction(input));
	}

	private static class AddRecipeAction implements IUndoableAction {
		DemonTrade rec;
		ItemStack input;

		public AddRecipeAction(ItemStack input) {
			this.input = input;
		}

		@Override
		public void apply() {
			rec = new DemonTrade(input);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			DemonTrade.removeTrade(rec);
		}

		@Override
		public String describe() {
			return "Adding Demon Trade for "+input.getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Removing Demon Trade for "+input.getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}

	private static class AddEntityRecipeAction implements IUndoableAction {
		DemonTrade rec;
		String input;

		public AddEntityRecipeAction(String input) {
			this.input = input;
		}

		@Override
		public void apply() {
			rec = new DemonTrade(input);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			DemonTrade.removeTrade(rec);
		}

		@Override
		public String describe() {
			return "Adding Demon Trade for "+input;
		}

		@Override
		public String describeUndo() {
			return "Removing Demon Trade for "+input;
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}

	private static class RemoveRecipeAction implements IUndoableAction {
		List<DemonTrade> rec;

		public RemoveRecipeAction(List<DemonTrade> rec) {
			this.rec = rec;
		}

		@Override
		public void apply() {
			for(DemonTrade entry : rec) {
				DemonTrade.removeTrade(entry);
			}
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			for(DemonTrade entry : rec) {
				new DemonTrade(entry.desiredItem);
			}
		}

		@Override
		public String describe() {
			return "Removing "+rec.size()+" Demon Trade(s)";
		}

		@Override
		public String describeUndo() {
			return "Restoring "+rec.size()+" Demon Trade(s)";
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}

	private static class RemoveEntityRecipeAction implements IUndoableAction {
		String input;

		public RemoveEntityRecipeAction(String input) {
			this.input = input;
		}

		@Override
		public void apply() {
			DemonTrade.removeTrade(input);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			new DemonTrade(input);
		}

		@Override
		public String describe() {
			return "Removing Demon Trade for "+input;
		}

		@Override
		public String describeUndo() {
			return "Restoring Demon Trade for "+input;
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}
}
