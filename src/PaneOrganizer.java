import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class PaneOrganizer {
    private BorderPane root = new BorderPane();
    private MyRectangle movingRect;

    public PaneOrganizer() {
        this.root.setStyle("-fx-background-color: #e4cbff");
        this.createButtonPane();
        this.createLabelPane();
        this.createRectsPane();
    }

    public BorderPane getRoot() {
        return this.root;
    }

    public void createButtonPane() {
        HBox pane = new HBox();
        pane.setMinHeight(40);
        Button quitButton = new Button();
        quitButton.setOnAction((ActionEvent e) -> System.exit(0));
        quitButton.setText("Quit");
        quitButton.setAlignment(Pos.CENTER);
        pane.getChildren().add(quitButton);
        pane.setAlignment(Pos.CENTER);
        this.root.setBottom(pane);
    }

    public void createLabelPane() {
        HBox pane = new HBox();
        pane.setMinHeight(40);
        Label label = new Label("Cartoon");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        pane.getChildren().add(label);
        pane.setAlignment(Pos.CENTER);
        this.root.setTop(pane);
    }

    private void createRectsPane() {
        Pane rectsPane = new Pane();
        rectsPane.setPrefSize(Constants.RECTS_PANE_WIDTH, Constants.RECTS_PANE_HEIGHT);
        rectsPane.setStyle(Constants.RECTS_PANE_COLOR);
        this.root.setCenter(rectsPane);
        new MyRectangle(Constants.STATIONARY_RECT_XLOC, Constants.STATIONARY_RECT_YLOC,
                Constants.STATIONARY_RECT_COLOR, rectsPane);
        this.movingRect = new MyRectangle(Constants.MOVING_RECT_XLOC, Constants.MOVING_RECT_YLOC,
                Constants.MOVING_RECT_COLOR, rectsPane);
        rectsPane.setOnKeyPressed(KeyEvent -> handleKeyPress(KeyEvent));
        rectsPane.setFocusTraversable(true);
    }

    private void handleKeyPress(KeyEvent e) {
        KeyCode keyPressed = e.getCode();
        if (keyPressed == KeyCode.SPACE) {
            System.out.println("Spacebar!");
        }
        if (keyPressed == KeyCode.A) {
            movingRect.moveLeft();
        } else if (keyPressed == KeyCode.D) {
            movingRect.moveRight();
        }
        e.consume();
    }
}
