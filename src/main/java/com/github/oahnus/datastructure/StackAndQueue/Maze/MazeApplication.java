package com.github.oahnus.datastructure.StackAndQueue.Maze;

import java.util.Stack;

/**
 * Created by jackstrom on 2016/4/25.
 */
public class MazeApplication {
    public static void main(String[] args){
        Maze maze = new Maze();
        int[][] mazeMatrix = maze.getMaze();
        Stack<Position> stack;

        for(int i = 0;i<mazeMatrix.length;i++){
            for(int j=0;j<mazeMatrix[i].length;j++){
                System.out.print(mazeMatrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
        stack = maze.getPath(new Position(1,1,0),new Position(6,6,0));
        while(stack.size()>0){
            Position top = stack.pop();
            System.out.print(top.x+","+top.y+"-->");
        }
    }
}
