/*// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class HuonGenerator extends EntityModel<Entity> {
	private final ModelRenderer base;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer casing;
	private final ModelRenderer liquid;

	public HuonGenerator() {
		texWidth = 256;
		texHeight = 256;

		base = new ModelRenderer(this);
		base.setPos(-8.5F, -42.0F, 0.0F);
		base.texOffs(65, 0).addBox(-3.5F, 64.0F, -12.0F, 24.0F, 2.0F, 24.0F, 0.0F, false);
		base.texOffs(57, 96).addBox(-2.5F, 60.0F, -11.0F, 22.0F, 4.0F, 22.0F, 0.0F, false);
		base.texOffs(37, 123).addBox(-1.5F, 56.0F, -10.0F, 20.0F, 4.0F, 20.0F, 0.0F, false);
		base.texOffs(114, 52).addBox(6.5F, 60.5F, -21.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);
		base.texOffs(135, 66).addBox(7.0F, 52.5F, -20.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		base.texOffs(18, 133).addBox(7.5F, 7.5F, -20.0F, 2.0F, 45.0F, 2.0F, 0.0F, false);
		base.texOffs(57, 96).addBox(7.0F, -8.5F, -20.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);
		base.texOffs(41, 42).addBox(-3.5F, -3.0F, -12.0F, 24.0F, 2.0F, 24.0F, 0.0F, false);
		base.texOffs(57, 69).addBox(-2.5F, -1.0F, -11.0F, 22.0F, 4.0F, 22.0F, 0.0F, false);
		base.texOffs(114, 27).addBox(-1.5F, 3.0F, -10.0F, 20.0F, 4.0F, 20.0F, 0.0F, false);
		base.texOffs(43, 69).addBox(6.5F, -0.5F, -21.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);
		base.texOffs(95, 127).addBox(6.5F, -5.5F, -21.0F, 4.0F, 3.0F, 23.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 2.3998F, 0.0F);
		cube_r1.texOffs(120, 97).addBox(-7.75F, -5.5F, -18.0F, 4.0F, 3.0F, 26.0F, 0.0F, false);
		cube_r1.texOffs(49, 0).addBox(-7.75F, -0.5F, -18.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r1.texOffs(124, 96).addBox(-7.25F, -8.5F, -17.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(0, 133).addBox(-6.75F, 7.5F, -17.0F, 2.0F, 45.0F, 2.0F, 0.0F, false);
		cube_r1.texOffs(0, 66).addBox(-7.25F, 52.5F, -17.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		cube_r1.texOffs(127, 127).addBox(-7.75F, 60.5F, -18.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(17.0F, 0.0F, 0.0F);
		base.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -2.3998F, 0.0F);
		cube_r2.texOffs(124, 52).addBox(3.75F, -5.5F, -18.0F, 4.0F, 3.0F, 26.0F, 0.0F, false);
		cube_r2.texOffs(65, 27).addBox(3.75F, -0.5F, -18.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);
		cube_r2.texOffs(98, 123).addBox(4.25F, -8.5F, -17.5F, 3.0F, 16.0F, 3.0F, 0.0F, false);
		cube_r2.texOffs(9, 133).addBox(4.75F, 7.5F, -17.0F, 2.0F, 45.0F, 2.0F, 0.0F, false);
		cube_r2.texOffs(0, 0).addBox(4.25F, 52.5F, -17.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		cube_r2.texOffs(96, 27).addBox(3.75F, 60.5F, -18.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);

		casing = new ModelRenderer(this);
		casing.setPos(0.0F, 24.0F, 0.0F);
		casing.texOffs(0, 0).addBox(-8.0F, -59.0F, -8.0F, 16.0F, 49.0F, 16.0F, 0.0F, false);

		liquid = new ModelRenderer(this);
		liquid.setPos(0.0F, 24.0F, 0.0F);
		liquid.texOffs(0, 69).addBox(-7.0F, -59.0F, -7.0F, 14.0F, 49.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		casing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		liquid.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}*/