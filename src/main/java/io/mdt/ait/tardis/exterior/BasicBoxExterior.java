package io.mdt.ait.tardis.exterior;

import io.mdt.ait.tardis.PortalInfo;
import io.mdt.ait.tardis.exterior.model.BasicBoxModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;

public class BasicBoxExterior extends TARDISExterior {

    public BasicBoxExterior() {
        super("basic", "exterior.ait.basic");
    }

    @Override
    public <T extends Entity> EntityModel<T> model() {
        return new BasicBoxModel<>();
    }

    @Override
    public PortalInfo portal() {
        return new PortalInfo(1.275D, 2.5D, 0.5D, 1.269D, 0.22595D);
    }
}
