package model;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
  private SudokuBoard board;

  public SudokuValidator(SudokuBoard board) {
    this.board = board;
  }

  public boolean isComplete() {
    for (int row = 0; row < 9; row++){
      for (int col = 0; col < 9; col++) {
        if (board.getCell(row, col).getFixedValue() == null && board.getCell(row, col).getPlayerValue() == null) {
          return false;
        }
      }
    }
    return true;
  }

  private Integer getValue(int row, int col) {
    SudokuCell cell = board.getCell(row, col);
    if (cell.getFixedValue() != null) {
      return cell.getFixedValue();
    } 
    return cell.getPlayerValue();
  }

  public boolean hasConflicts() {
    for (int row = 0; row < 9; row++) {
      Set<Integer> seen = new HashSet<>();
      for (int col = 0; col < 9; col++) {
        Integer value = getValue(row, col);
        if (value != null) {
          if (seen.contains(value)) {
            return true;
          }
          seen.add(value);
        }
      }
    }

    for (int col = 0; col < 9; col++) {
      Set<Integer> seen = new HashSet<>();
      for (int row = 0; row < 9; row++) {
        Integer value = getValue(row, col);
        if (value != null) {
          if (seen.contains(value)) {
            return true;
          }
          seen.add(value);
        }
      }
    }

    for (int blockRow = 0; blockRow < 3; blockRow++) {
      for (int blockCol = 0; blockCol < 3; blockCol++) {
        Set<Integer> seen = new HashSet<>();
        for (int r = blockRow * 3; r < blockRow * 3 + 3; r++) {
          for (int c = blockCol * 3; c < blockCol * 3 + 3; c++) {
            Integer val = getValue(r, c);
            if (val != null) {
              if (seen.contains(val)) {
                return true;
              } 
              seen.add(val);
            }
          }
        }
      }
    }

    return false;
    }

    public String getStatus() {
      if (!isComplete()) {
        return "Incompleto";
      } else if (hasConflicts()) {
        return "O jogo tem erros";
      } else {
        return "O jogo está completo";
      }
    }
}
