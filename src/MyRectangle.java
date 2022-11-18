import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class MyRectangle {

    private Rectangle rect;

    public MyRectangle(double xLoc, double yLoc, Color color, Pane myPane) {
        this.rect = new Rectangle(xLoc, yLoc, Constants.RECT_WIDTH, Constants.RECT_HEIGHT);
        this.rect.setFill(color);
        myPane.getChildren().add(this.rect);
    }

    public void moveLeft() {
        this.rect.setX(this.rect.getX() - Constants.OFFSET);
    }

    public void moveRight() {
        this.rect.setX(this.rect.getX() + Constants.OFFSET);
    }
}