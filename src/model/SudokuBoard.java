package model;

public class SudokuBoard {
  private SudokuCell[][] cells = new SudokuCell[9][9];

  public SudokuBoard() {
    for(int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        cells[row][col] = new SudokuCell();
      }
    } 
  }

  public SudokuCell getCell(int row, int col) {
    return cells[row][col];
  }

  public void setFixed(int row, int col, int value) {
    cells[row][col].setFixedValue(value);
  }

  public boolean placeNumber(int row, int col, int value) {
    return cells[row][col].setPlayerValue(value);
  }

  public boolean removeNumber(int row, int col) {
    return cells[row][col].removePlayerValue();
  }

  public void clearBoard() {
    for(var row : cells) {
      for (var cell : row) {
        cell.removePlayerValue();
      }
    }
  }
}
