package net.digitalpear.pearfection.item;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.bus.api.IEventBus;
import net.digitalpear.pearfection.Pearfection;
import net.digitalpear.pearfection.item.ModItems;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Pearfection.MOD_ID);

    public static final DeferredItem<Item> PEAR_TART = ITEMS.register("pear_tart",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
