// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class HudolinExterior extends EntityModel<Entity> {
	private final ModelRenderer box;
	private final ModelRenderer base;
	private final ModelRenderer posts;
	private final ModelRenderer small_front_left_r1;
	private final ModelRenderer small_front_right_r1;
	private final ModelRenderer small_front_left_r2;
	private final ModelRenderer walls_and_pillars;
	private final ModelRenderer left_door;
	private final ModelRenderer right_door;
	private final ModelRenderer ppcb;
	private final ModelRenderer ppcb_back_r1;
	private final ModelRenderer ppcb_right_r1;
	private final ModelRenderer roof_tiers;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer lamp;
	private final ModelRenderer lamp_struts_two_r1;

	public HudolinExterior() {
		texWidth = 512;
		texHeight = 512;

		box = new ModelRenderer(this);
		box.setPos(0.0F, -11.0F, 0.25F);
		

		base = new ModelRenderer(this);
		base.setPos(-19.0F, 35.0F, 19.0F);
		box.addChild(base);
		base.texOffs(149, 0).addBox(0.0F, -3.0F, -38.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);

		posts = new ModelRenderer(this);
		posts.setPos(19.0F, 35.0F, 19.0F);
		box.addChild(posts);
		posts.texOffs(0, 281).addBox(-37.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		posts.texOffs(62, 212).addBox(-5.0F, -67.0F, -37.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		posts.texOffs(119, 215).addBox(-4.5F, -68.5F, -36.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		posts.texOffs(96, 212).addBox(-37.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);
		posts.texOffs(79, 212).addBox(-5.0F, -67.0F, -5.0F, 4.0F, 64.0F, 4.0F, 0.0F, false);

		small_front_left_r1 = new ModelRenderer(this);
		small_front_left_r1.setPos(-35.0F, -66.5F, -3.0F);
		posts.addChild(small_front_left_r1);
		setRotationAngle(small_front_left_r1, 0.0F, 3.1416F, 0.0F);
		small_front_left_r1.texOffs(119, 215).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		small_front_right_r1 = new ModelRenderer(this);
		small_front_right_r1.setPos(-3.0F, -66.5F, -3.0F);
		posts.addChild(small_front_right_r1);
		setRotationAngle(small_front_right_r1, 0.0F, -1.5708F, 0.0F);
		small_front_right_r1.texOffs(119, 215).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		small_front_left_r2 = new ModelRenderer(this);
		small_front_left_r2.setPos(-35.0F, -66.5F, -35.0F);
		posts.addChild(small_front_left_r2);
		setRotationAngle(small_front_left_r2, 0.0F, 1.5708F, 0.0F);
		small_front_left_r2.texOffs(119, 215).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		walls_and_pillars = new ModelRenderer(this);
		walls_and_pillars.setPos(-19.0F, 35.0F, 19.0F);
		box.addChild(walls_and_pillars);
		walls_and_pillars.texOffs(59, 127).addBox(2.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		walls_and_pillars.texOffs(32, 281).addBox(1.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		walls_and_pillars.texOffs(118, 127).addBox(5.0F, -59.0F, -3.0F, 28.0F, 56.0F, 1.0F, 0.0F, false);
		walls_and_pillars.texOffs(27, 281).addBox(18.5F, -59.0F, -2.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);
		walls_and_pillars.texOffs(0, 127).addBox(35.0F, -59.0F, -33.0F, 1.0F, 56.0F, 28.0F, 0.0F, false);
		walls_and_pillars.texOffs(22, 281).addBox(35.5F, -59.0F, -19.5F, 1.0F, 56.0F, 1.0F, 0.0F, false);

		left_door = new ModelRenderer(this);
		left_door.setPos(-14.0F, 6.0F, -16.25F);
		box.addChild(left_door);
		left_door.texOffs(0, 212).addBox(0.0F, -30.0F, -0.75F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		left_door.texOffs(39, 350).addBox(2.0F, -10.5F, -1.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		left_door.texOffs(17, 281).addBox(13.5F, -30.0F, -1.25F, 1.0F, 56.0F, 1.0F, 0.0F, false);

		right_door = new ModelRenderer(this);
		right_door.setPos(14.0F, 4.0F, -16.0F);
		box.addChild(right_door);
		right_door.texOffs(31, 212).addBox(-14.0F, -28.0F, -1.0F, 14.0F, 56.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -8.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		right_door.texOffs(34, 350).addBox(-13.0F, -10.0F, -1.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ppcb = new ModelRenderer(this);
		ppcb.setPos(-19.0F, 35.0F, -19.0F);
		box.addChild(ppcb);
		ppcb.texOffs(37, 37).addBox(2.0F, -66.0F, -1.0F, 34.0F, 5.0F, 3.0F, 0.0F, false);
		ppcb.texOffs(0, 46).addBox(-1.0F, -66.0F, 2.0F, 3.0F, 5.0F, 34.0F, 0.0F, false);

		ppcb_back_r1 = new ModelRenderer(this);
		ppcb_back_r1.setPos(38.0F, 0.0F, 0.0F);
		ppcb.addChild(ppcb_back_r1);
		setRotationAngle(ppcb_back_r1, 0.0F, 3.1416F, 0.0F);
		ppcb_back_r1.texOffs(37, 37).addBox(2.0F, -66.0F, -39.0F, 34.0F, 5.0F, 3.0F, 0.0F, false);

		ppcb_right_r1 = new ModelRenderer(this);
		ppcb_right_r1.setPos(0.0F, 0.0F, 0.0F);
		ppcb.addChild(ppcb_right_r1);
		setRotationAngle(ppcb_right_r1, 0.0F, 3.1416F, 0.0F);
		ppcb_right_r1.texOffs(0, 46).addBox(-39.0F, -66.0F, -36.0F, 3.0F, 5.0F, 34.0F, 0.0F, false);

		roof_tiers = new ModelRenderer(this);
		roof_tiers.setPos(0.0F, -33.5F, 0.0F);
		box.addChild(roof_tiers);
		roof_tiers.texOffs(149, 46).addBox(-17.0F, -1.25F, -17.0F, 34.0F, 5.0F, 34.0F, 0.0F, false);
		roof_tiers.texOffs(0, 86).addBox(-14.0F, 4.5F, -17.5F, 28.0F, 5.0F, 35.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		roof_tiers.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.texOffs(286, 53).addBox(-10.0F, -4.25F, -10.0F, 20.0F, 5.0F, 20.0F, 0.0F, false);
		cube_r1.texOffs(254, 86).addBox(-16.0F, -3.25F, -16.0F, 32.0F, 5.0F, 32.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(2.0F, 6.5F, -38.0F);
		roof_tiers.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.texOffs(127, 86).addBox(24.0F, -2.0F, -15.5F, 28.0F, 5.0F, 35.0F, 0.0F, false);

		lamp = new ModelRenderer(this);
		lamp.setPos(1.0F, 33.5F, -1.25F);
		box.addChild(lamp);
		lamp.texOffs(97, 360).addBox(1.75F, -78.0F, -1.75F, 0.0F, 6.0F, 1.0F, 0.001F, false);
		lamp.texOffs(114, 292).addBox(-2.5F, -73.0F, -0.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		lamp.texOffs(114, 292).addBox(-2.5F, -78.0F, -0.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		lamp.texOffs(0, 0).addBox(-1.0F, -78.0F, -3.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
		lamp.texOffs(69, 333).addBox(-4.0F, -79.0F, -2.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		lamp.texOffs(75, 307).addBox(-5.0F, -72.0F, -3.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		lamp.texOffs(60, 360).addBox(-3.0F, -77.0F, -1.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		lamp.texOffs(112, 326).addBox(-3.75F, -78.0F, -1.75F, 1.0F, 6.0F, 0.0F, 0.001F, false);
		lamp.texOffs(129, 353).addBox(-3.75F, -78.0F, 2.75F, 0.0F, 6.0F, 1.0F, 0.001F, false);
		lamp.texOffs(116, 320).addBox(-3.75F, -78.0F, -1.75F, 0.0F, 6.0F, 1.0F, 0.001F, false);
		lamp.texOffs(86, 322).addBox(-3.75F, -78.0F, 3.75F, 1.0F, 6.0F, 0.0F, 0.001F, false);
		lamp.texOffs(94, 349).addBox(1.75F, -78.0F, 2.75F, 0.0F, 6.0F, 1.0F, 0.001F, false);
		lamp.texOffs(140, 348).addBox(0.75F, -78.0F, -1.75F, 1.0F, 6.0F, 0.0F, 0.001F, false);
		lamp.texOffs(98, 335).addBox(0.75F, -78.0F, 3.75F, 1.0F, 6.0F, 0.0F, 0.001F, false);

		lamp_struts_two_r1 = new ModelRenderer(this);
		lamp_struts_two_r1.setPos(-1.0F, 0.5F, 1.0F);
		lamp.addChild(lamp_struts_two_r1);
		setRotationAngle(lamp_struts_two_r1, 0.0F, -1.5708F, 0.0F);
		lamp_struts_two_r1.texOffs(0, 0).addBox(0.0F, -78.5F, -4.0F, 0.0F, 6.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		box.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}