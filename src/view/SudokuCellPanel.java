package view;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import model.SudokuCell;

public class SudokuCellPanel extends JPanel {
  private SudokuCell cell;
  private JLabel label = new JLabel("", SwingConstants.CENTER);

  public SudokuCellPanel(SudokuCell cell) {
    this.cell = cell;
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setPreferredSize(new Dimension(50, 50));
    setLayout(new BorderLayout());
    add(label, BorderLayout.CENTER);
  }

  public void refresh() {
    if (cell.getFixedValue() != null) {
      label.setText(String.valueOf(cell.getFixedValue()));
      setBackground(Color.LIGHT_GRAY);
    } else if (cell.getPlayerValue() != null) {
      label.setText(String.valueOf(cell.getPlayerValue()));
      setBackground(Color.WHITE);
    } else {
      label.setText("");
      setBackground(Color.WHITE);
    }
  }
}
