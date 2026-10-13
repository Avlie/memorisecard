import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            memorycard card = new memorycard();
            card.setVisible(true);
        });
    }
}
 