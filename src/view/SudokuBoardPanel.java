package view;
import model.SudokuBoard;
import javax.swing.JPanel;
import java.awt.*;

public class SudokuBoardPanel extends JPanel {
private SudokuCellPanel[][] cellPanels = new SudokuCellPanel[9][9];
private SudokuBoard board;
private javax.swing.JLabel statusLabel = new javax.swing.JLabel("", javax.swing.SwingConstants.CENTER);

  public SudokuBoardPanel(SudokuBoard board) {
    this.board = board;
    setLayout(new java.awt.BorderLayout());
    JPanel gridPanel = new JPanel(new GridLayout(9, 9));
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        cellPanels[r][c] = new SudokuCellPanel(board.getCell(r, c));
        gridPanel.add(cellPanels[r][c]);
      }
    }
    add(statusLabel, java.awt.BorderLayout.NORTH);
    add(gridPanel, java.awt.BorderLayout.CENTER);
  }

  public void refresh() {
    // Destacar células com erro
    model.SudokuValidator validator = new model.SudokuValidator(board);
    boolean[][] errorCells = new boolean[9][9];
    // Verificar linhas
    for (int r = 0; r < 9; r++) {
      java.util.Map<Integer, java.util.List<Integer>> seen = new java.util.HashMap<>();
      for (int c = 0; c < 9; c++) {
        Integer v = board.getCell(r, c).getFixedValue();
        if (v == null) v = board.getCell(r, c).getPlayerValue();
        if (v != null) {
          seen.putIfAbsent(v, new java.util.ArrayList<>());
          seen.get(v).add(c);
        }
      }
      for (var entry : seen.entrySet()) {
        if (entry.getValue().size() > 1) {
          for (int c : entry.getValue()) errorCells[r][c] = true;
        }
      }
    }
    // Verificar colunas
    for (int c = 0; c < 9; c++) {
      java.util.Map<Integer, java.util.List<Integer>> seen = new java.util.HashMap<>();
      for (int r = 0; r < 9; r++) {
        Integer v = board.getCell(r, c).getFixedValue();
        if (v == null) v = board.getCell(r, c).getPlayerValue();
        if (v != null) {
          seen.putIfAbsent(v, new java.util.ArrayList<>());
          seen.get(v).add(r);
        }
      }
      for (var entry : seen.entrySet()) {
        if (entry.getValue().size() > 1) {
          for (int r : entry.getValue()) errorCells[r][c] = true;
        }
      }
    }
    // Verificar blocos
    for (int blockRow = 0; blockRow < 3; blockRow++) {
      for (int blockCol = 0; blockCol < 3; blockCol++) {
        java.util.Map<Integer, java.util.List<int[]>> seen = new java.util.HashMap<>();
        for (int r = blockRow * 3; r < blockRow * 3 + 3; r++) {
          for (int c = blockCol * 3; c < blockCol * 3 + 3; c++) {
            Integer v = board.getCell(r, c).getFixedValue();
            if (v == null) v = board.getCell(r, c).getPlayerValue();
            if (v != null) {
              seen.putIfAbsent(v, new java.util.ArrayList<>());
              seen.get(v).add(new int[]{r, c});
            }
          }
        }
        for (var entry : seen.entrySet()) {
          if (entry.getValue().size() > 1) {
            for (int[] pos : entry.getValue()) errorCells[pos[0]][pos[1]] = true;
          }
        }
      }
    }
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        cellPanels[r][c].setError(errorCells[r][c]);
        cellPanels[r][c].refresh();
      }
    }
    // Atualizar status
    statusLabel.setText(validator.getStatus());
  }
}
