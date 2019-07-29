package com.github.oahnus.datastructure.StackAndQueue.Maze;

import java.util.Stack;

/**
 * Created by jackstrom on 2016/4/25.
 */
public class Maze {
    private int[][] maze = {
            {1,1,1,1,1,1,1,1},
            {1,0,1,0,0,0,0,1},
            {1,0,0,0,1,1,0,1},
            {1,1,1,0,1,0,0,1},
            {1,0,0,0,1,1,1,1},
            {1,0,1,0,0,0,1,1},
            {1,0,0,0,1,0,0,1},
            {1,1,1,1,1,1,1,1}
    };

    private Stack<Position> pathStack;

    public Maze() {
        this.pathStack = new Stack<>();
    }

    public int[][] getMaze() {
        return maze;
    }

    public Stack<Position> getPath(Position start,Position end) {
        findPath(start,end);
        return pathStack;
    }

    private void findPath(Position start,Position end){
        pathStack.push(start);

        while(!(pathStack.peek().x == end.x&&pathStack.peek().y == end.y)){
            Position top = pathStack.peek();
            int dir = top.direction;
            label:
            {
                while (dir < 4) {
                    Position next;
                    switch (dir) {
                        //right
                        case 0:
                            next = new Position(top.x, top.y + 1, 0);
                            if (maze[next.x][next.y] == 0) {
                                pathStack.push(next);
                                break label;
                            } else {
                                dir++;
                            }
                            break;
                        //down
                        case 1:
                            next = new Position(top.x + 1, top.y, 0);
                            if (maze[next.x][next.y] == 0) {
                                pathStack.push(next);
                                break label;
                            } else {
                                dir++;
                            }
                            break;
                        //left
                        case 2:
                            next = new Position(top.x, top.y - 1, 0);
                            if (maze[next.x][next.y] == 0) {
                                pathStack.push(next);
                                break label;
                            } else {
                                dir++;
                            }
                            break;
                        //up
                        case 3:
                            next = new Position(top.x - 1, top.y, 0);
                            if (maze[next.x][next.y] == 0) {
                                pathStack.push(next);
                                break label;
                            } else {
                                dir++;
                            }
                            break;
                    }
                }
            }
            if(dir ==4){
                pathStack.pop();
            }
        }
    }
}

