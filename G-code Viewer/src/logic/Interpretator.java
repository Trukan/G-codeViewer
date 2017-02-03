package logic;

import org.eclipse.swt.graphics.Point;

import gui.MainWindow;

public class Interpretator {
	String filePath;
	String code;
	String startLine;
	String endLine;
	String textCode;

	Point[] pathLeftTop;
	Point[] pathLeftDown;
	Point[] pathRightTop;
	Point[] pathRightDown;

	public Interpretator() {
		filePath = null;
		code = null;
		startLine = "";
		endLine = "";
		textCode = "";
		MainWindow.setTextTrace("\t x = 0...0 \t\t\t y = 0...0 \t\t\t z = 0...0");
		pathLeftTop = new Point[8];
		pathLeftDown = new Point[8];
		pathRightTop = new Point[8];
		pathRightDown = new Point[8];
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				pathLeftTop[i] = new Point(0, 0);
				pathLeftDown[i] = new Point(0, 0);
				pathRightTop[i] = new Point(0, 0);
				pathRightDown[i] = new Point(0, 0);
			} else {
				if (i == 1 | i == 3) {
					pathLeftTop[i] = new Point(0, (i - 2) * 5);
					pathLeftDown[i] = new Point(0, (i - 2) * 5);
					pathRightTop[i] = new Point(0, (i - 2) * 5);
					pathRightDown[i] = new Point(0, (i - 2) * 5);
				}
				if (i == 5 | i == 7) {
					pathLeftTop[i] = new Point((i - 6) * 5, 0);
					pathLeftDown[i] = new Point((i - 6) * 5, 0);
					pathRightTop[i] = new Point((i - 6) * 5, 0);
					pathRightDown[i] = new Point((i - 6) * 5, 0);
				}
			}
		}
		MainWindow.setPointsPath(pathLeftTop, pathLeftDown, pathRightTop, pathRightDown);

	}

	public Point[] getPathLT() {
		return pathLeftTop;

	}

	public Point[] getPathLD() {
		return pathLeftDown;

	}

	public Point[] getPathRT() {
		return pathRightTop;

	}

	public Point[] getPathRD() {
		return pathRightDown;

	}

	public void parseCode(String fPath) {
		filePath = fPath;

	}
}
