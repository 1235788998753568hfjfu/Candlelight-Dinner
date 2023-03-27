package net.satisfy.candlelight.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.satisfy.candlelight.client.gui.CookingPanGui;
import net.satisfy.candlelight.client.gui.LetterGui;
import net.satisfy.candlelight.client.gui.WineStationGui;
import net.satisfy.candlelight.client.model.CookingHatModel;
import net.satisfy.candlelight.networking.CandlelightMessages;
import net.satisfy.candlelight.registry.ModBlockEntityTypes;
import net.satisfy.candlelight.registry.ObjectRegistry;
import net.satisfy.candlelight.registry.ScreenHandlerTypes;
import net.satisfy.candlelight.render.WineStationBlockEntityRenderer;


public class CandlelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ObjectRegistry.CAKE_STAND, ObjectRegistry.CHAIR,
                ObjectRegistry.TABLE, ObjectRegistry.ROSE, ObjectRegistry.POTTED_ROSE, ObjectRegistry.STRAWBERRY_WILD_JUNGLE,
                ObjectRegistry.STRAWBERRY_WILD_TAIGA, ObjectRegistry.TOMATOES_WILD, ObjectRegistry.APPLE_TREE_SAPLING,
                ObjectRegistry.OAK_CHAIR, ObjectRegistry.DARK_OAK_CHAIR, ObjectRegistry.SPRUCE_CHAIR, ObjectRegistry.WARPED_CHAIR,
                ObjectRegistry.BIRCH_CHAIR, ObjectRegistry.MANGROVE_CHAIR, ObjectRegistry.ACACIA_CHAIR, ObjectRegistry.CRIMSON_CHAIR,
                ObjectRegistry.JUNGLE_CHAIR, ObjectRegistry.OAK_TABLE, ObjectRegistry.ACACIA_TABLE, ObjectRegistry.DARK_OAK_TABLE,
                ObjectRegistry.BIRCH_TABLE, ObjectRegistry.SPRUCE_TABLE, ObjectRegistry.JUNGLE_TABLE, ObjectRegistry.MANGROVE_TABLE,
                ObjectRegistry.WARPED_TABLE, ObjectRegistry.CRIMSON_TABLE, ObjectRegistry.TOMATO_CROP, ObjectRegistry.BROCCOLI_CROP,
                ObjectRegistry.STRAWBERRY_CROP, ObjectRegistry.WILD_BROCCOLI

        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), ObjectRegistry.TABLE_SET);

        registerModels();
        CandlelightMessages.registerS2CPackets();

        HandledScreens.register(ScreenHandlerTypes.COOKING_PAN_SCREEN_HANDLER, CookingPanGui::new);
        HandledScreens.register(ScreenHandlerTypes.LETTER_SCREEN_HANDLER, LetterGui::new);
        HandledScreens.register(ScreenHandlerTypes.WINE_STATION_SCREEN_HANDLER, WineStationGui::new);


        BlockEntityRendererRegistry.register(ModBlockEntityTypes.WINE_STATION_BLOCK_ENTITY, WineStationBlockEntityRenderer::new);
    }



    private static void registerModels(){
        EntityModelLayerRegistry.registerModelLayer(CookingHatModel.LAYER_LOCATION, CookingHatModel::getTexturedModelData);
    }
}
