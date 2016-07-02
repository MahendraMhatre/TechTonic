import javax.swing.JFrame;

public class PieChart {
  public static void main(String[] argv) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MyComponent());
    frame.setSize(800, 800);
    frame.setVisible(true);

  }
}