import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.SudokuController;
import model.SudokuBoard;
import view.SudokuBoardPanel;
import view.SudokuMenuPanel;

import java.awt.BorderLayout;


public class App {
    public static void main(String[] args) throws Exception {
        String config = "2,0;9,true 4,0;8,true 5,0;6,true 1,1;3,true 4,1;7,true 2,2;6,true 5,2;1,true 8,2;5,true 0,3;5,true 2,3;3,true 8,3;2,true 1,4;9,true 3,4;1,true 4,4;2,true 5,4;5,true 6,4;6,true 1,5;4,true 8,5;7,true 0,6;7,true 4,6;3,true 8,6;1,true 0,7;9,true 1,7;8,true 4,7;4,true 2,8;6,true 3,8;8,true 4,8;5,true 7,8;4,true";

        SwingUtilities.invokeLater(() -> {
            SudokuBoard board = new SudokuBoard();
            board.loadFromString(config);

            SudokuBoardPanel boardPanel = new SudokuBoardPanel(board);
            SudokuController controller = new SudokuController(board, boardPanel);
            SudokuMenuPanel menuPanel = new SudokuMenuPanel(controller);

            JFrame frame = new JFrame("Sudoku");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.add(boardPanel);
            frame.add(menuPanel);
            frame.pack();
            frame.setVisible(true);

            boardPanel.refresh();
        });
    }
}
