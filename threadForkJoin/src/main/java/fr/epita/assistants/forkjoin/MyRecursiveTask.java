package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {
	
	final private double[][] matrix;
	final private int xLowerBound;
	final private int xUpperBound;
	final private int yLowerBound;
	final private int yUpperBound;
	
	public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
		this.matrix = matrix;
		this.xLowerBound = xLowerBound;
		this.xUpperBound = xUpperBound;
		this.yLowerBound = yLowerBound;
		this.yUpperBound = yUpperBound;
	}
	
	@Override
	protected Double compute() {
		if (xLowerBound >= xUpperBound || yLowerBound >= yUpperBound) {
			return 0.0;
		} else
		if (xLowerBound + 5 >= xUpperBound && yLowerBound + 5 >= yUpperBound) {
			double sum = 0;
			int count = 0;
			for (int i = yLowerBound; i < yUpperBound; i++) {
				for (int j = xLowerBound; j < xUpperBound; j++) {
					sum += matrix[i][j];
					count++;
				}
			}
			return sum/count;
		} else {
			MyRecursiveTask topLeft = new MyRecursiveTask(matrix, xLowerBound, (xLowerBound+xUpperBound)/2, yLowerBound, (yLowerBound+yUpperBound)/2);
			MyRecursiveTask topRight = new MyRecursiveTask(matrix, (xLowerBound+xUpperBound)/2, xUpperBound, yLowerBound, (yLowerBound+yUpperBound)/2);
			MyRecursiveTask bottomLeft = new MyRecursiveTask(matrix, xLowerBound, (xLowerBound+xUpperBound)/2, (yLowerBound+yUpperBound)/2, yUpperBound);
			MyRecursiveTask bottomRight = new MyRecursiveTask(matrix, (xLowerBound+xUpperBound)/2, xUpperBound, (yLowerBound+yUpperBound)/2, yUpperBound);
			
			topLeft.fork();
			topRight.fork();
			bottomLeft.fork();
			double bottomRightResult = bottomRight.compute();
			double topLeftResult = topLeft.join();
			double topRightResult = topRight.join();
			double bottomLeftResult = bottomLeft.join();
			
			return (topLeftResult + topRightResult + bottomLeftResult + bottomRightResult)/4;
		}
	}
}