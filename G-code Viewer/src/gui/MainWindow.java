package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainWindow {

	private static int groupWidthLeftText = 250;
	private static int widthText = 20;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("G-code Viewer");
		shell.setImage(new Image(display, "main.png"));
		shell.setMinimumSize(850, 450);

		Group forText = new Group(shell, SWT.BORDER);
		forText.setLayout(new RowLayout());
		forText.setBounds(0, 0, groupWidthLeftText + 10, shell.getSize().y - 10);
		Group forTrace = new Group(shell, SWT.BORDER);

		forTrace.setBounds(forText.getBounds().width, 0, shell.getSize().x - forText.getBounds().width - 10,
				shell.getSize().y - 10);
		Composite leftTop = new Composite(forTrace, SWT.BORDER);
		leftTop.setBounds(3, 30, (forTrace.getClientArea().width - 6) / 2, (forTrace.getClientArea().height - 30) / 2);

		Composite leftDown = new Composite(forTrace, SWT.BORDER);
		leftDown.setBounds(3, 30 + (forTrace.getClientArea().height - 30) / 2, (forTrace.getClientArea().width - 6) / 2,
				(forTrace.getClientArea().height - 30) / 2);

		Composite rightTop = new Composite(forTrace, SWT.BORDER);
		rightTop.setBounds(3 + (forTrace.getClientArea().width - 6) / 2, 30, (forTrace.getClientArea().width - 6) / 2,
				(forTrace.getClientArea().height - 30) / 2);

		Composite rightDown = new Composite(forTrace, SWT.BORDER);
		rightDown.setBounds(3 + (forTrace.getClientArea().width - 6) / 2,
				30 + (forTrace.getClientArea().height - 30) / 2, (forTrace.getClientArea().width - 6) / 2,
				(forTrace.getClientArea().height - 30) / 2);

		Label labBeginMargin = new Label(forText, SWT.SIMPLE);
		labBeginMargin.setBounds(2, 1, groupWidthLeftText, widthText);
		labBeginMargin.setText("Стартовая строка отображаемого блока:");

		Text textBeginMargin = new Text(forText, SWT.LEFT | SWT.BORDER | SWT.SIMPLE);
		textBeginMargin.setBounds(10, 1 + widthText, groupWidthLeftText - 150, widthText);

		Label labEndMargin = new Label(forText, SWT.SIMPLE);
		labEndMargin.setBounds(2, 1 + 2 * widthText, groupWidthLeftText, widthText);
		labEndMargin.setText("Конечная строка отображаемого блока:");

		Text textEndMargin = new Text(forText, SWT.LEFT | SWT.BORDER | SWT.SIMPLE);
		textEndMargin.setBounds(10, 1 + 3 * widthText, groupWidthLeftText - 150, widthText);

		Label labCode = new Label(forText, SWT.NONE);
		labCode.setBounds(2, 10 + 4 * widthText, groupWidthLeftText, widthText);
		labCode.setText("Исследуемый G-code:");

		Text textCode = new Text(forText, SWT.LEFT | SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		textCode.setBounds(10, 10 + 5 * widthText, groupWidthLeftText - 50, shell.getSize().y - 9 * widthText);

		Menu bar = new Menu(shell, SWT.BAR);
		shell.setMenuBar(bar);
		MenuItem loadBut = new MenuItem(bar, SWT.PUSH);
		Image image = new Image(display, "load.ICO");
		loadBut.setImage(image);
		loadBut.setAccelerator(SWT.MOD1 + 'S');

		shell.addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				forText.setBounds(0, 0, groupWidthLeftText, shell.getSize().y - 50);
				forTrace.setBounds(forText.getBounds().width, 0, shell.getSize().x - forText.getBounds().width - 10,
						shell.getSize().y - 50);
				textCode.setBounds(10, 10 + 5 * widthText, groupWidthLeftText - 7, shell.getSize().y - 9 * widthText);
				leftTop.setBounds(3, 30, (forTrace.getClientArea().width - 6) / 2,
						(forTrace.getClientArea().height - 30) / 2);

				leftDown.setBounds(3, 30 + (forTrace.getClientArea().height - 30) / 2,
						(forTrace.getClientArea().width - 6) / 2, (forTrace.getClientArea().height - 30) / 2);

				rightTop.setBounds(3 + (forTrace.getClientArea().width - 6) / 2, 30,
						(forTrace.getClientArea().width - 6) / 2, (forTrace.getClientArea().height - 30) / 2);

				rightDown.setBounds(3 + (forTrace.getClientArea().width - 6) / 2,
						30 + (forTrace.getClientArea().height - 30) / 2, (forTrace.getClientArea().width - 6) / 2,
						(forTrace.getClientArea().height - 30) / 2);

			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
