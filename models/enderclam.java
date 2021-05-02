// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer bottom;
	private final ModelRenderer head;
	private final ModelRenderer top;

	public custom_model() {
		textureWidth = 64;
		textureHeight = 64;

		bottom = new ModelRenderer(this);
		bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
		bottom.setTextureOffset(0, 20).addBox(-7.0F, -5.0F, -7.0F, 14.0F, 5.0F, 14.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -5.0F, 3.0F);
		bottom.addChild(head);
		setRotationAngle(head, -0.2182F, 0.0F, 0.0F);
		head.setTextureOffset(0, 52).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, -3.0F, 7.0F);
		bottom.addChild(top);
		setRotationAngle(top, -0.4363F, 0.0F, 0.0F);
		top.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -14.0F, 14.0F, 6.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bottom.render(matrixStack, buffer, packedLight, packedOverlay);
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
	}
}