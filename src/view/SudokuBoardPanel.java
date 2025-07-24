package view;
import model.SudokuBoard;
import javax.swing.JPanel;
import java.awt.*;

public class SudokuBoardPanel extends JPanel {
private SudokuCellPanel[][] cellPanels = new SudokuCellPanel[9][9];

  public SudokuBoardPanel(SudokuBoard board) {
    setLayout(new GridLayout(9, 9));
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        cellPanels[r][c] = new SudokuCellPanel(board.getCell(r, c));
        add(cellPanels[r][c]);
      }
    }
  }

  public void refresh() {
    for (var row : cellPanels) {
      for (var cell : row) {
        cell.refresh();
      }
    }
  }
}
