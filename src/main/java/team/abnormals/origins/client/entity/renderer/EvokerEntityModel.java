package team.abnormals.origins.client.entity.renderer;

import net.minecraft.client.model.Box;
import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.mob.EvokerEntity;

public class EvokerEntityModel extends EntityModel<EvokerEntity> {
	private final Cuboid head;
	private final Cuboid nose;
	private final Cuboid body;
	private final Cuboid arms;
	private final Cuboid leg0;
	private final Cuboid leg1;
	private final Cuboid rightarm;
	private final Cuboid leftarm;

	public EvokerEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		head = new Cuboid(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.boxes.add(new Box(head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, true));
		head.boxes.add(new Box(head, 32, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.5F, true));

		nose = new Cuboid(this);
		nose.setRotationPoint(0.0F, -2.0F, 0.0F);
		nose.boxes.add(new Box(nose, 24, 0, -1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F, true));

		body = new Cuboid(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.boxes.add(new Box(body, 16, 20, -4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F, true));
		body.boxes.add(new Box(body, 0, 38, -4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F, true));

		arms = new Cuboid(this);
		arms.setRotationPoint(0.0F, 2.0F, 0.0F);
		arms.boxes.add(new Box(arms, 40, 38, -4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F, true));
		arms.boxes.add(new Box(arms, 44, 22, 4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, true));
		arms.boxes.add(new Box(arms, 44, 22, -8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, true));

		leg0 = new Cuboid(this);
		leg0.setRotationPoint(2.0F, 12.0F, 0.0F);
		leg0.boxes.add(new Box(leg0, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leg1 = new Cuboid(this);
		leg1.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leg1.boxes.add(new Box(leg1, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		rightarm = new Cuboid(this);
		rightarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightarm.boxes.add(new Box(rightarm, 40, 46, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leftarm = new Cuboid(this);
		leftarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftarm.boxes.add(new Box(leftarm, 40, 46, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(EvokerEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		nose.render(f5);
		body.render(f5);
		arms.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
	}
	
	public void setRotationAngle(Cuboid modelRenderer, float x, float y, float z) {
		modelRenderer.rotationPointX = x;
		modelRenderer.rotationPointY = y;
		modelRenderer.rotationPointZ = z;
	}
	
}