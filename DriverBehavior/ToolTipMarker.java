

import processing.core.PGraphics;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;

public class ToolTipMarker extends SimplePointMarker {

	private int MARKER_SIZE = 12;
	private String name;
	private boolean showToolTip = false;

	public ToolTipMarker(Location location, String name) {
		super(location);
		this.name = name;
	}

	public void draw(PGraphics pGraphics, float x, float y) {
		drawAttribution(pGraphics);
		drawMarker(pGraphics, x, y);
		if (showToolTip) {
			drawToolTip(pGraphics, x, y);
		}
	}
	
	public void setShowToolTip(boolean value) {
		showToolTip = value;
	}
	
	private void drawAttribution(PGraphics pGraphics) {
		String name = "(C) OpenStreetMap contributors - www.openstreetmap.org/copyright";
		float x = 580;
		float y = 680;
		float spaceWidth = pGraphics.textWidth(" ");
		float textHeight = pGraphics.textAscent() + pGraphics.textDescent();
		float toolTipWidth = pGraphics.textWidth(" " + name + " ");
		float toolTipHeight = textHeight;
		pGraphics.pushStyle();
			pGraphics.noStroke();
			pGraphics.fill(255, 255, 255, 30);
			pGraphics.rect(x, y, toolTipWidth, toolTipHeight);
			pGraphics.fill(0, 0, 0);
			pGraphics.text(name, x + spaceWidth, y + pGraphics.textAscent());
		pGraphics.popStyle();		
	}
	
	private void drawMarker(PGraphics pGraphics, float x, float y) {
		pGraphics.pushStyle();		
			pGraphics.noStroke();
			pGraphics.fill(128, 255, 128, 200);
			pGraphics.ellipse(x, y, MARKER_SIZE, MARKER_SIZE);
		pGraphics.popStyle();
	}
	
	private void drawToolTip(PGraphics pGraphics, float x, float y) {
		x = 20;
		y = 20;
		float spaceWidth = pGraphics.textWidth(" ");
		float textHeight = pGraphics.textAscent() + pGraphics.textDescent();
		float toolTipWidth = pGraphics.textWidth(name) * 11 / 10;
		int toolTipLines = name.length() - name.replace("\n", "").length() + 1;
		float toolTipHeight = textHeight * toolTipLines;
		pGraphics.pushStyle();
			pGraphics.noStroke();
			pGraphics.fill(255, 255, 255);
			pGraphics.rect(x, y, toolTipWidth, toolTipHeight);
			pGraphics.fill(0, 0, 0);
			pGraphics.text(name, x + spaceWidth, y + textHeight);
		pGraphics.popStyle();		
	}

}
