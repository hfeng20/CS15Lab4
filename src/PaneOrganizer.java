import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class PaneOrganizer {
    private BorderPane root;

    public PaneOrganizer() {
        this.root = new BorderPane();
        this.root.setBottom(createButtonPane());
        this.root.setTop(createLabelPane());
        this.root.setStyle("-fx-background-color: #e4cbff");
    }

    public BorderPane getRoot() {
        return this.root;
    }

    public Pane createButtonPane() {
        HBox pane = new HBox();
        pane.setMinHeight(40);
        Button quitButton = new Button();
        quitButton.setOnAction((ActionEvent e) -> System.exit(0));
        quitButton.setText("Quit");
        quitButton.setAlignment(Pos.CENTER);
        pane.getChildren().add(quitButton);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }

    public HBox createLabelPane() {
        HBox pane = new HBox();
        pane.setMinHeight(40);
        Label label = new Label("Cartoon");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        pane.getChildren().add(label);
        pane.setAlignment(Pos.CENTER);
        return pane;
    }
}
