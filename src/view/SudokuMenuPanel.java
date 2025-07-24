package view;

import javax.swing.*;

import controller.SudokuController;

import java.awt.*;

public class SudokuMenuPanel extends JPanel {
  public SudokuMenuPanel(SudokuController controller) {
    setLayout(new FlowLayout());

    JTextField rowField = new JTextField(2);
    JTextField colField = new JTextField(2);
    JTextField valueField = new JTextField(2);

    JButton placeBtn = new JButton("Colocar Número");
    placeBtn.addActionListener(e -> {
      int row = Integer.parseInt(rowField.getText());
      int col = Integer.parseInt(colField.getText());
      int value = Integer.parseInt(valueField.getText());
      controller.placeNumber(row, col, value);
    });

    JButton removeBtn = new JButton("Remover Número");
    removeBtn.addActionListener(e -> {
      int row = Integer.parseInt(rowField.getText());
      int col = Integer.parseInt(colField.getText());
      controller.removeNumber(row, col);
    });

    JButton clearBtn = new JButton("Limpar");
    clearBtn.addActionListener(e -> controller.clearBoard());

    add(new JLabel("Linha:"));
    add(rowField);
    add(new JLabel("Coluna:"));
    add(colField);
    add(new JLabel("Valor:"));
    add(valueField);
    add(placeBtn);
    add(removeBtn);
    add(clearBtn);
  }
}
