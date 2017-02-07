package gui;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Composite;

public class Pane extends Composite {
	protected int[] path={getClientArea().width / 2, getClientArea().height / 2};

	public Pane(Composite parent, int style) {
		super(parent, style);
		

		
		
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent ar) {
				GC gc = ar.gc;
				gc.setLineWidth(1);
				crosshair(gc,path[0],path[1],9);
				gc.drawPolyline(path);
			}
		});
	}
	
	void paint(){
		
	}
	
	//@param preferably 0<color<17
	void crosshair(GC gc, int x, int y, int color){
		if(gc!=null)
		gc.setForeground(getColor(color));
		gc.drawLine(x-5, y, x+5, y);
		gc.drawLine(x, y-5, x, y+5);
	}
	
	Color getColor(int color){
			Color c = getDisplay().getSystemColor(color);
		return c;
	}

}
