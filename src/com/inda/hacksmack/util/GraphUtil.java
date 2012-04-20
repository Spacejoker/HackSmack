package com.inda.hacksmack.util;

import org.newdawn.slick.Color;
import org.newdawn.slick.fills.GradientFill;
import org.newdawn.slick.geom.Vector2f;

public class GraphUtil {

	public static GradientFill getColorAsGradient(Color color){
		return new GradientFill(new Vector2f(0,0), color, new Vector2f(1024,800), color, false);
	}
}
