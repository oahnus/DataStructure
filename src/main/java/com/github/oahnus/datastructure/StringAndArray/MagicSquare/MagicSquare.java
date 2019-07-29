package com.github.oahnus.datastructure.StringAndArray.MagicSquare;

/**
 * Created by oahnus on 2016/8/2.
 */
public class MagicSquare {
    private int rank = 5;

    public MagicSquare(){

    }

    public MagicSquare(int n){
        rank = n;
    }

    public int[][] getMagicSquare(){
        int[][] square = new int[rank][rank];

        int i = 0;
        int j = rank/2;
        for(int k=0;k<rank*rank;k++){
            if(square[i][j] != 0){
                i = (i+rank+2)%rank;
                j = (j+rank-1)%rank;
            }
            square[i][j] = k+1;
            i = (i+rank-1)%rank;
            j = (j+rank+1)%rank;
        }
        return square;
    }

    public static void main(String[] args){
        MagicSquare magicSquare = new MagicSquare(3);
        int[][] retArr = magicSquare.getMagicSquare();

        for(int i=0;i<retArr.length;i++){
            for(int j=0;j<retArr.length;j++){
                System.out.print(retArr[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
