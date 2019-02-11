package robot.ascii;

import com.googlecode.lanterna.terminal.Terminal;

//Zitao Zheng S3637675
public class Bar extends AbstractItem
{
	public Bar(int bar_height, int column)
	{
		// for Bar, bottomPosition is always 0
		super(bar_height, column, 0, '*');
	}

	@Override
	public void draw(Terminal terminal)
	{
		terminal.applyForegroundColor(Terminal.Color.GREEN);
		
		// draw a bar of height "bar_height" in the specific column
		super.draw(terminal);	
	}
}
