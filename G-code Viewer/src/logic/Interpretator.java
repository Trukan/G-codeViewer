package logic;

import org.eclipse.swt.graphics.Point;

import gui.MainWindow;

public class Interpretator {
	String filePath;
	String code;
	String startLine;
	String endLine;
	String textCode;
	int length;
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
		MainWindow.setTextTrace("\t x >> 0...0 \t\t\t y >> 0...0 \t\t\t z >> 0...0");
		
		length = 1;
		pathLeftTop = new Point[length];
		pathLeftDown = new Point[length];
		pathRightTop = new Point[length];
		pathRightDown = new Point[length];
		pathLeftTop[0] = new Point(0, 0);
		pathLeftDown[0] = new Point(0, 0);
		pathRightTop[0] = new Point(0, 0);
		pathRightDown[0] = new Point(0, 0);
		
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
