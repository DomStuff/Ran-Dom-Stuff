// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer shell;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r1;
	private final ModelRenderer neck;
	private final ModelRenderer cube_r2;
	private final ModelRenderer head;
	private final ModelRenderer frount_l;
	private final ModelRenderer frount_r;
	private final ModelRenderer back_l;
	private final ModelRenderer back_r;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		shell = new ModelRenderer(this);
		shell.setRotationPoint(0.0F, 24.0F, 0.0F);
		shell.setTextureOffset(0, 0).addBox(-4.0F, -4.5F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		shell.setTextureOffset(0, 9).addBox(-3.0F, -7.5F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		shell.setTextureOffset(18, 13).addBox(-3.0F, -3.5F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		shell.setTextureOffset(0, 12).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.5F, 21.0F, 3.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -0.5F, 0.0F);
		tail.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 9).addBox(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 21.0F, -4.0F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -1.0F, -0.5F);
		neck.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.2182F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 5).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 21.0F, -4.0F);
		head.setTextureOffset(0, 19).addBox(-1.5F, -3.25F, -4.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		frount_l = new ModelRenderer(this);
		frount_l.setRotationPoint(2.0F, 22.0F, -2.5F);
		frount_l.setTextureOffset(24, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		frount_r = new ModelRenderer(this);
		frount_r.setRotationPoint(-2.0F, 24.0F, -2.5F);
		frount_r.setTextureOffset(20, 20).addBox(-2.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		back_l = new ModelRenderer(this);
		back_l.setRotationPoint(6.0F, 24.0F, 4.0F);
		back_l.setTextureOffset(12, 19).addBox(-4.0F, -3.0F, -2.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		back_r = new ModelRenderer(this);
		back_r.setRotationPoint(0.0F, 24.0F, 4.0F);
		back_r.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -2.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		shell.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		frount_l.render(matrixStack, buffer, packedLight, packedOverlay);
		frount_r.render(matrixStack, buffer, packedLight, packedOverlay);
		back_l.render(matrixStack, buffer, packedLight, packedOverlay);
		back_r.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_l.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.frount_r.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.frount_l.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.back_r.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.neck.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.neck.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}