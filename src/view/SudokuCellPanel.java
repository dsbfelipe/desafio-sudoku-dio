package view;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import model.SudokuCell;

public class SudokuCellPanel extends JPanel {
  private SudokuCell cell;
  private JTextField textField = new JTextField(1);
  private boolean hasError = false;

  public SudokuCellPanel(SudokuCell cell) {
    this.cell = cell;
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setPreferredSize(new Dimension(50, 50));
    setLayout(new BorderLayout());
    textField.setHorizontalAlignment(JTextField.CENTER);
    textField.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
    add(textField, BorderLayout.CENTER);
    textField.setEditable(cell.isEditable());
    textField.setText(cell.getFixedValue() != null ? String.valueOf(cell.getFixedValue()) : (cell.getPlayerValue() != null ? String.valueOf(cell.getPlayerValue()) : ""));
    textField.setBackground(cell.getFixedValue() != null ? Color.LIGHT_GRAY : Color.WHITE);
    textField.addActionListener(e -> {
      if (cell.isEditable()) {
        String txt = textField.getText();
        try {
          int val = Integer.parseInt(txt);
          if (val >= 1 && val <= 9) {
            cell.setPlayerValue(val);
          } else {
            cell.removePlayerValue();
          }
        } catch (Exception ex) {
          cell.removePlayerValue();
        }
        refresh();
      }
    });
  }

  public void refresh() {
    if (cell.getFixedValue() != null) {
      textField.setText(String.valueOf(cell.getFixedValue()));
      textField.setEditable(false);
      textField.setBackground(Color.LIGHT_GRAY);
    } else if (cell.getPlayerValue() != null) {
      textField.setText(String.valueOf(cell.getPlayerValue()));
      textField.setEditable(true);
      textField.setBackground(hasError ? Color.PINK : Color.WHITE);
    } else {
      textField.setText("");
      textField.setEditable(true);
      textField.setBackground(hasError ? Color.PINK : Color.WHITE);
    }
  }

  public void setError(boolean error) {
    this.hasError = error;
    refresh();
  }
}
