package control;

import java.util.Arrays;
//import java.util.Scanner;

import robot.Robot;

//Robot Assignment for Programming 1 s1 2017
//Adapted by Caspar from original Robot code in RobotImpl.jar written by Dr Charles Thevathayan
//Zitao Zheng S3637675
public class RobotControl implements Control
{
	private Robot robot;

	// note use of constants from Control interface
	private int height = Control.INITIAL_HEIGHT; 
	private int width = Control.INITIAL_WIDTH;
	private int depth = Control.INITIAL_DEPTH;

	private int[] barHeights;
	private int[] blockHeights;
	
	// called by RobotImpl
	// the unused arrays are based on cmd line params to RobotImpl but not used in this assignment
	@Override
	public void control(Robot robot, int barHeightsUnused[],
			int blockHeightsUnused[])
	{
		// save robot so we can access it from other methods
		this.robot = robot;

		// ------ASSIGNMENT PART A-------
		// replace this code with a console based menu to create and populate the arrays (in separate method(s))
		this.barHeights = new int[]
				{7, 3, 1, 7, 5, 3, 2 };
		this.blockHeights = new int[]
				{3, 2, 2, 3, 1, 1 };
		
//		Scanner sc = new Scanner (System.in);
//		
//		this.barHeights = getBarHeights(sc);
// 		this.blockHeights = getBlockHeights(sc);
						
		// initialise the robot
		robot.init(barHeights, blockHeights, height, width, depth);

		// a simple private method to demonstrate how to control (assignment PART B)
		// note use of constant from Control interface
		//moveToWidth(Control.MAX_WIDTH);

		// assignment part B implemented here
		
		/*My solution is to from a ordered array based on the number of each block
		 in array blockHeights, and move the block according the array.*/
		
		// set a new array for the number of each size of blocks
		int[] numBlock = new int[Control.MAX_BLOCK_HEIGHT];
		for(int i = 0; i < blockHeights.length; i++)
		{
			//numBlock[0] is for bar height 1, numBlock[1] is for bar height 2 
			//and numBlock[2] is for bar height 3
			numBlock[blockHeights[i] - 1]++;
		}
		int[] blockHeightsOrdered = arrayOrdered(blockHeights, numBlock);
		
		//set the reachable depth of destination column
		int destDepth = Control.MAX_DEPTH;
		int[] temp = Arrays.copyOf(numBlock, numBlock.length);
		for(int i = 0; i < blockHeightsOrdered.length; i++)
		{
			int theBlockHeight = blockHeightsOrdered[i];
			//calculate the destination depth before moving the block
			destDepth=destDepth - theBlockHeight;
			moveBlock(theBlockHeight, temp[theBlockHeight - 1], destDepth);
			temp[theBlockHeight - 1]--;	
		}
	}

	private void moveToWidth(int width)
	{
		while (this.width != width)
		{
			if(this.width < width)
			{
				robot.extend();
				this.width++;
			}
			else
			{
				robot.contract();
				this.width--;
			}
		}
	}

	// assignment part A methods implemented here
	
//	private int[] getBarHeights(Scanner sc)
//	{
//		int barsNumber=getNumber("Enter number of bars(min 1/max 7):",Control.MIN_BARS, Control.MAX_BARS, sc);
//		int bar[]=new int [barsNumber];
//		for(int i=0; i<bar.length; i++)
//		{
//			String insBars=String.format("Enter height of bar %d of %d (min 1/max 7): ", i+1, bar.length);
//			bar[i]=getNumber(insBars, Control.MIN_BAR_HEIGHT, Control.MAX_BAR_HEIGHT, sc);
//		}
//		return bar;
//	}
//	
//	private int[] getBlockHeights(Scanner sc)
//	{
//		final int MIN_BLOCKS=1;
//		final int MAX_BLOCKS=12;
//		int blocksNumber=getNumber("Enter number of blocks(min 1/max 12):", MIN_BLOCKS, MAX_BLOCKS, sc);
//		int block[]=new int [blocksNumber];
//		int sum=0;
//		for(int i=0;i<block.length;i++)
//		{
//			String insBlocks=String.format("Enter height of block %d of %d (min 1/max 3): ", i+1, block.length);
//			block[i]=getNumber(insBlocks, Control.MIN_BLOCK_HEIGHT, Control.MAX_BLOCK_HEIGHT, sc);
//			
//			sum+=block[i]; //calculate the total height
//			if(sum>Control.MAX_TOTAL_BLOCK_HEIGHT)
//			{
//				System.out.printf("running total %d exceeds max height total 12(EXITING)\n",sum);
//				//If sum exceeds the max height, the loop starts from the beginning, 
//				//sum should be zero, i should be 0 after increment
//				i=-1;
//				sum=0;
//			}	
//		}
//		return block;
//	}
//	
//	//output a valid number between the given minimum value and maximum value
//	private int getNumber(String prompt, int min, int max, Scanner sc)
//	{
//		int num=0;
//		boolean flag=true;
//		while(flag)
//		{
//			System.out.print(prompt);
//			if (sc.hasNextInt())
//			{
//				num=sc.nextInt();
//				if(num>=min && num<=max)
//					flag=false;
//				else
//				{
//					sc.nextLine();
//					System.out.println("Please input a valid number!");
//				}
//			}
//			else
//			{
//				sc.nextLine();
//				System.out.println("Please input a valid number!");
//			}
//		}
//		return num;
//	}
	
	// assignment part B methods implemented here
	
	//get an ordered array
	private int[] arrayOrdered(int[] array, int[] num)
	{
		int[] arrOrdered = new int[array.length];
		int j = 0;
		int[] temp = Arrays.copyOf(num, num.length);
		for(int i = 0; i<array.length; i++)
		{
			boolean flag = false;
			while(!flag)
			{
				//forming the ordered array according to the number of each bar height
				if(temp[j] != 0)
				{
					arrOrdered[i] = j+1;
					temp[j]--;
					flag = true;
				}
				j++;
				/*if j is bigger than the length of array num,
				 j turns back to 0 and do the check again*/
				if(j >= num.length)
					j = 0;
			}
		}
		return arrOrdered;
	}
	
	private void moveToDepth(int depth)
	{
		while (this.depth != depth)
		{
			if(this.depth < depth)
			{
				robot.lower();
				this.depth++;
			}
			else
			{
				robot.raise();
				this.depth--;
			}
		}
	}
	
	
	private void moveBlock(int blockHeight, int numBlock, int destDepth)
	{
		if(blockHeight != Control.MAX_BLOCK_HEIGHT)
		{
			//bar height is 1 or 2
			int column = blockHeight;
			moveToWidth(column);
			//depth should subtract the height of blocks
			moveToDepth(Control.MAX_DEPTH - blockHeight*numBlock);
		}
		else
		{
			//bar height is 3
			moveToWidth(Control.FIRST_BAR_COLUMN + numBlock-1);
			//depth should subtract the height of the block and the bar
			moveToDepth(Control.MAX_DEPTH - Control.MAX_BLOCK_HEIGHT - barHeights[numBlock-1]);
		}
		robot.pick();
		moveToDepth(Control.INITIAL_DEPTH);
		moveToWidth(Control.DEST_COLUMN);
		moveToDepth(destDepth);
		robot.drop();
		moveToDepth(Control.INITIAL_DEPTH);
		moveToWidth(Control.INITIAL_WIDTH);
	}
	
}