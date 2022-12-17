package com.mdt.ait.common.items;

import com.mdt.ait.core.init.AITDimensions;
import com.qouteall.immersive_portals.api.PortalAPI;
import com.qouteall.immersive_portals.portal.Portal;
import com.qouteall.immersive_portals.portal.PortalManipulation;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Objects;

public class SlingRingItem extends Item {

    public Portal portal2;


    public SlingRingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext pContext) {
        Block block = pContext.getLevel().getBlockState(pContext.getClickedPos()).getBlock();
        Portal portal = Portal.entityType.create(pContext.getLevel());
        if(!pContext.getLevel().isClientSide()) {
            if (portal != null) {
                this.portal2 = PortalManipulation.completeBiWayPortal(portal, Portal.entityType);
                if (!(block instanceof AirBlock)) {
                    float yRotation = Objects.requireNonNull(pContext.getPlayer()).getDirection().toYRot();
                    portal.setOrientationAndSize(new Vector3d(1.0D, 0.0D, 0.0D), new Vector3d(0.0D, 1.0D, 0.0D),
                            2, 2);
                    PortalManipulation.rotatePortalBody(portal, new Quaternion(Vector3f.YP, yRotation, true));
                    portal.setOriginPos(new Vector3d(pContext.getClickedPos().getX() + 0.5D,
                            pContext.getClickedPos().getY(),
                            pContext.getClickedPos().getZ() + 1));
                    PortalManipulation.setPortalTransformation(portal, pContext.getLevel().dimension(), new Vector3d(
                            pContext.getClickedPos().getX() + 8D,
                            pContext.getClickedPos().getY(),
                            pContext.getClickedPos().getZ() + 8D), new Quaternion(Vector3f.YP, -yRotation, true), 1d);
                    this.portal2.setDestination(new Vector3d( pContext.getClickedPos().getX() + 0.5D, pContext.getClickedPos().getY(), pContext.getClickedPos().getZ() + 1D));
                    pContext.getLevel().addFreshEntity(portal);
                    PortalAPI.spawnServerEntity(this.portal2);
                    this.portal2.reloadAndSyncToClient();
                }
            }
        }
        return super.useOn(pContext);
    }
}
