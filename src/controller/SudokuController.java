package controller;

import model.SudokuBoard;
import view.SudokuBoardPanel;

public class SudokuController {
  private SudokuBoard model;
  private SudokuBoardPanel view;

  public SudokuController(SudokuBoard model, SudokuBoardPanel view) {
    this.model = model;
    this.view = view;
  }

  public boolean placeNumber(int row, int col, int value) {
    boolean success = model.placeNumber(row, col, value);
    view.refresh();
    return success;
  }

  public boolean removeNumber(int row, int col) {
    boolean success = model.removeNumber(row, col);
    view.refresh();
    return success;
  }

  public void clearBoard() {
    model.clearBoard();
    view.refresh();
  }
}
