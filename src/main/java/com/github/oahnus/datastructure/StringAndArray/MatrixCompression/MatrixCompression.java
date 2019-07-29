package com.github.oahnus.datastructure.StringAndArray.MatrixCompression;

/**
 * Created by jackstrom on 2016/4/27.
 */
public class MatrixCompression {
    public MatrixCompression(){}

    //lower triangular matrix
    public int[] compressionOne(int[][] matrix){
        int length = matrix.length;
        int[] retMatrix = new int[length*(length+1)/2+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i>=j){
                    retMatrix[i*(i+1)/2+j] = matrix[i][j];
                }
            }
        }
        retMatrix[retMatrix.length-1] = 0;
        return retMatrix;
    }

    //upper triangular matrix
    public int[] compressionTwo(int[][] matrix){
        int length = matrix.length;
        int[] retMatrix = new int[length*(length+1)/2+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i<=j){
                    retMatrix[i*(length*2-i+1)/2+j-i] = matrix[i][j];
                }
            }
        }
        retMatrix[retMatrix.length-1] = 0;
        return retMatrix;
    }

    public static void main(String[] args){
        MatrixCompression compression = new MatrixCompression();
        int[][] matrixOne = {
                {1,0,0,0},
                {2,3,0,0},
                {4,5,6,0},
                {7,8,9,10}
        };

        int[][] matrixTwo = {
                {1,2,3,4},
                {0,5,6,7},
                {0,0,8,9},
                {0,0,0,10}
        };

        int[] compOne = compression.compressionOne(matrixOne);
        int[] compTwo = compression.compressionTwo(matrixTwo);
        for(int i=0;i<compOne.length;i++){
            System.out.print(compOne[i]+" ");
        }
        System.out.println();
        for(int i=0;i<compTwo.length;i++){
            System.out.print(compTwo[i]+" ");
        }
    }
}
