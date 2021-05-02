// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer legs;
	private final ModelRenderer left_front;
	private final ModelRenderer left_back;
	private final ModelRenderer right_front;
	private final ModelRenderer right_back;
	private final ModelRenderer tail;
	private final ModelRenderer necc;
	private final ModelRenderer necc_r1;
	private final ModelRenderer head;

	public custom_model() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 9).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(18, 13).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 12).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, -2.0F, 3.0F);
		body.addChild(legs);

		left_front = new ModelRenderer(this);
		left_front.setRotationPoint(-2.5F, 0.0F, -4.5F);
		legs.addChild(left_front);
		left_front.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		left_back = new ModelRenderer(this);
		left_back.setRotationPoint(-2.5F, 0.0F, -1.5F);
		legs.addChild(left_back);
		left_back.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		right_front = new ModelRenderer(this);
		right_front.setRotationPoint(2.5F, 0.0F, -4.5F);
		legs.addChild(right_front);
		right_front.setTextureOffset(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		right_back = new ModelRenderer(this);
		right_back.setRotationPoint(2.5F, 0.0F, -1.5F);
		legs.addChild(right_back);
		right_back.setTextureOffset(24, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -2.0F, 3.0F);
		body.addChild(tail);
		tail.setTextureOffset(0, 9).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		necc = new ModelRenderer(this);
		necc.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(necc);

		necc_r1 = new ModelRenderer(this);
		necc_r1.setRotationPoint(0.0F, -1.0F, -4.0F);
		necc.addChild(necc_r1);
		setRotationAngle(necc_r1, -0.2182F, 0.0F, 0.0F);
		necc_r1.setTextureOffset(0, 5).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -1.5F, -4.0F);
		necc.addChild(head);
		head.setTextureOffset(0, 19).addBox(-1.5F, -2.75F, -3.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.left_back.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_front.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_back.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_front.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}