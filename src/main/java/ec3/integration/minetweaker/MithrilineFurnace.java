package ec3.integration.minetweaker;

import java.util.ArrayList;
import java.util.List;

import ec3.api.MithrilineFurnaceRecipe;
import ec3.api.MithrilineFurnaceRecipes;
import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.minecraft.MineTweakerMC;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.essentialcraft.MithrilineFurnace")
public class MithrilineFurnace {

	@ZenMethod
	public static void addRecipe(IIngredient input, IItemStack output, float enderpower) {
		if(input == null || output == null) {
			MineTweakerAPI.logError("Cannot turn "+input+" into a Mithriline Furnace Recipe");
			return;
		}

		boolean flag = true;
		for(MithrilineFurnaceRecipe rec : MithrilineFurnaceRecipes.allRegisteredRecipes) {
			if(input.matches(MineTweakerUtils.getIItemStack(rec.smelted)))
				flag = false;
		}

		if(flag)
			MineTweakerAPI.apply(new AddRecipeAction(new MithrilineFurnaceRecipe(MineTweakerUtils.toUnformedIS(input), MineTweakerMC.getItemStack(output), enderpower, input.getAmount())));
		else
			MineTweakerAPI.logWarning("Recipe already exists!");
	}

	@ZenMethod
	public static void removeRecipe(IIngredient input, @Optional IItemStack output) {
		if(input == null) {
			MineTweakerAPI.logError("Cannot remove "+input+" from Mithriline Furnace Recipes");
			return;
		}

		final ArrayList<MithrilineFurnaceRecipe> toRemove = new ArrayList<MithrilineFurnaceRecipe>();
		MithrilineFurnaceRecipes.allRegisteredRecipes.stream().filter((entry) -> {
			return (input.matches(MineTweakerUtils.getIItemStack(entry.smelted)) && (output == null || output.matches(MineTweakerMC.getIItemStack(entry.result))));
		}).forEach((entry) -> {
			toRemove.add(entry);
		});

		if(toRemove.isEmpty())
			MineTweakerAPI.logWarning("No recipe for "+input.toString());
		else
			MineTweakerAPI.apply(new RemoveRecipeAction(toRemove));
	}

	private static class AddRecipeAction implements IUndoableAction {
		MithrilineFurnaceRecipe rec;

		public AddRecipeAction(MithrilineFurnaceRecipe rec) {
			this.rec = rec;
		}

		@Override
		public void apply() {
			MithrilineFurnaceRecipes.addRecipe(rec);
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			MithrilineFurnaceRecipes.removeRecipe(rec);
		}

		@Override
		public String describe() {
			return "Adding Mithriline Furnace Recipe for "+rec.result.getDisplayName();
		}

		@Override
		public String describeUndo() {
			return "Removing Mithriline Furnace Recipe for "+rec.result.getDisplayName();
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}

	private static class RemoveRecipeAction implements IUndoableAction {
		List<MithrilineFurnaceRecipe> rec;

		public RemoveRecipeAction(List<MithrilineFurnaceRecipe> rec) {
			this.rec = rec;
		}

		@Override
		public void apply() {
			for(MithrilineFurnaceRecipe entry : rec) {
				MithrilineFurnaceRecipes.removeRecipe(entry);
			}
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void undo() {
			for(MithrilineFurnaceRecipe entry : rec) {
				MithrilineFurnaceRecipes.addRecipe(entry);
			}
		}

		@Override
		public String describe() {
			return "Removing "+rec.size()+" Mithriline Furnace Recipes";
		}

		@Override
		public String describeUndo() {
			return "Restoring "+rec.size()+" Mithriline Furnace Recipes";
		}

		@Override
		public Object getOverrideKey() {
			return null;
		}
	}
}
