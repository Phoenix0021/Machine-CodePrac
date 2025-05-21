package com.lld;

public class GameValidator {
    public static boolean checkWin(Board board, char symbol){
        int size  = board.getSize();
        Cell[][] grid = board.getBoardState();
        
        for(int i=0;i<size;i++){
            if(checkRow(grid,i,symbol) || checkColumn(grid,i,symbol)){
                return true;
            }
        }

        return checkMainDiagonal(grid,symbol) || checkAntiDiagonal(grid,symbol);
    }



    public static boolean checkRow(Cell[][] grid, int row, char symbol){
        for(int j=0;j<grid.length;j++){
            if(grid[row][j].getSymbol() != symbol){
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumn(Cell[][] grid, int column, char symbol){
        for(int j=0;j<grid.length;j++){
            if(grid[j][column].getSymbol() != symbol){
                return false;
            }
        }
        return true;
    }

    public static boolean checkMainDiagonal(Cell[][] grid,char symbol){
        int j=0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][j].getSymbol() != symbol){
                return false;
            }
            j++;
        }
        return true;
    }

    public static boolean checkAntiDiagonal(Cell[][] grid,char symbol){
        int j=grid.length-1;
        for(int i=0;i<grid.length;i++){
            if(grid[i][j].getSymbol() != symbol){
                return false;
            }
            j--;
        }
        return true;
    }

    public static boolean isDraw(Board board){

        for(int i=0;i<board.getSize();i++){
            for(int j=0;j<board.getSize();j++){
                if(board.getBoardState()[i][j].isEmpty()){
                    return false;
                }
            }
        }
        return true;

    }

}
