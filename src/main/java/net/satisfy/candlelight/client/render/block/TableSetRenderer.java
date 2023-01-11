package net.satisfy.candlelight.client.render.block;

import daniking.vinery.block.entity.StorageBlockEntity;
import daniking.vinery.client.render.block.StorageTypeRenderer;
import daniking.vinery.util.ClientUtil;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3f;

public class TableSetRenderer implements StorageTypeRenderer {
    @Override
    public void render(StorageBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, DefaultedList<ItemStack> itemStacks) {
        ItemStack stack = itemStacks.get(0);
        if(stack.isEmpty()) return;
        float oP = (float) 1 / 16;
        matrices.translate(oP, oP, -oP);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90f));
        ClientUtil.renderItem(stack, matrices, vertexConsumers, entity);
    }
}
