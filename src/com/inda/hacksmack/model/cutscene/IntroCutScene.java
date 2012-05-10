package com.inda.hacksmack.model.cutscene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.HackSmackConstants;
import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.factory.AnimationFactory;
import com.inda.hacksmack.factory.ImageEntityFactory;
import com.inda.hacksmack.factory.ItemFactory;
import com.inda.hacksmack.input.InputEvent;
import com.inda.hacksmack.input.InputHandler;
import com.inda.hacksmack.model.Entity;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Item.ItemType;
import com.inda.hacksmack.util.RandomUtil;

public class IntroCutScene implements CutScene, InputEvent {

	long totalTime = 14000;
	List<Entity> ret = new ArrayList<Entity>();
	private long startTime;
	Entity bg;

	Entity playerWalking;
	int characterStartX = HackSmackConstants.SCREEN_WIDTH + 100, characterStartY = HackSmackConstants.SCREEN_HEIGHT - 550;
	Entity text1, text2, spaceArtifact;

	List<Item> explosions = new ArrayList<Item>();
	List<Item> smallGems = new ArrayList<Item>();
	Vector2f gemPosition = new Vector2f(250, HackSmackConstants.SCREEN_HEIGHT - 590);
	Vector2f gemMid = new Vector2f(250+50, HackSmackConstants.SCREEN_HEIGHT - 520);

	public IntroCutScene() {
		if (HackSmackConstants.skipIntro) {
			totalTime = 0;
		}

		InputHandler.getInstance().addEvent(this);
		startTime = System.currentTimeMillis();
		playerWalking = ImageEntityFactory.newImageEntity(new String[] { "intro_walk_1", "intro_walk_2", "intro_walk_3", "intro_walk_2" }, new Vector2f(100, 100), 250);
		playerWalking.setDirection(new Vector2f(90));

		text1 = ImageEntityFactory.newImageEntity(new String[] { "conversation_1" }, new Vector2f(0, HackSmackConstants.SCREEN_HEIGHT - 340), 1);
		text1.setDirection(new Vector2f(90));

		text2 = ImageEntityFactory.newImageEntity(new String[] { "conversation_2" }, new Vector2f(0, HackSmackConstants.SCREEN_HEIGHT - 340), 1);
		text2.setDirection(new Vector2f(90));

		for (int i = 0; i < 30; i++) {

			Item animation = AnimationFactory.newAnimation("explosion", new Vector2f(gemPosition));
			animation.getAnimation().setCurrentFrame(RandomUtil.getInstance().getRandom().nextInt(animation.getAnimation().getFrameCount()));
			animation.getPosition().x += RandomUtil.getInstance().getRandom().nextInt(100);
			animation.getPosition().y += RandomUtil.getInstance().getRandom().nextInt(100);

			explosions.add(animation);
		}

		spaceArtifact = ImageEntityFactory.newImageEntity(new String[] { "space_artifact" }, gemPosition, 1);
		spaceArtifact.setDirection(new Vector2f(90));
		ret.add(playerWalking);
		
		bg = ImageEntityFactory.newImageEntity(new String[] { "space_bg" }, new Vector2f(0, 0), 1);
		bg.setDirection(new Vector2f(90));
	}

	@Override
	public boolean done() {
		return getPassedTime() >= this.totalTime;
	}

	private boolean addedSmall = false;

	@Override
	public List<Entity> getEnteties() {

		long time = getPassedTime();
		ret.clear();
		ret.add(bg);
		if (time < 4000) {
			playerWalking.setPosition(new Vector2f((float) (characterStartX - time * 0.15), characterStartY));
			ret.add(playerWalking);
		} else {
			playerWalking.setAnimation(new Animation(new Image[] { ResourceManager.getInstance().getImage("intro_walk_2") }, 1));
			ret.add(playerWalking);
		}

		if (time > 4000 && time <= 9000) {
			ret.add(text1);
		}

		if (time > 9000 && time <= 14000) {
			ret.add(text2);
		}

		int exptime = 9000;
		if (time < exptime+50) {
			ret.add(spaceArtifact);
		}

		if (time > exptime) {
			if (!addedSmall) {
				for (int i = 0; i < 44; i++) {
					Item item = ItemFactory.newItemEntity("gem", new Vector2f(gemMid), ItemType.GEM, true);
					float theta = (float) (RandomUtil.getInstance().getRandom().nextInt());
					item.setDirection(new Vector2f(theta));
					item.setSpeed((RandomUtil.getInstance().getRandom().nextFloat()+0.1) /2.0 );
					smallGems.add(item);
				}
				addedSmall = true;
			}

			for (Iterator<Item> iterator = smallGems.iterator(); iterator.hasNext();) {
				Item gem = iterator.next();
				
				float x = gem.getPosition().x;
				float y = gem.getPosition().y;
				if(x < -100 || x > HackSmackConstants.SCREEN_WIDTH || y < -100 || y > HackSmackConstants.SCREEN_HEIGHT){
					iterator.remove();
					continue;
				}
				
				gem.getPosition().x = (float) (gemMid.x + gem.getDirection().x* gem.getSpeed() * (getPassedTime()-exptime));
				gem.getPosition().y = (float) (gemMid.y + gem.getDirection().y* gem.getSpeed() * (getPassedTime()-exptime));
				
				
				ret.add(gem);
			}

			for (Iterator<Item> iterator = explosions.iterator(); iterator.hasNext();) {
				Item exp = iterator.next();

				int frameId = exp.getAnimation().getFrame();
				if (time >= 1100 && frameId >= exp.getAnimation().getFrameCount() - 1) { // will not play last animation frame but thats ok
					iterator.remove();
					continue;
				}

				ret.add(exp);

			}
		}

		return ret;
	}

	private long getPassedTime() {
		return System.currentTimeMillis() - startTime;
	}

	@Override
	public void keyPressed(int key, char c) {
		if(c == ' ' && getPassedTime() > 1000 ){
			totalTime = 0;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingEvents() {
		return !done();
	}
}
