package Projekat;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Uputstvo extends Application {

    private final String TEXT = "Судоку је логичка загонетка у облику квадратне решетке.\n"
            + "Решетка је обично формата 9×9, начињена од подрешетки 3×3 поља.\n"
            + "На почетку је уписано неколико бројева у неколико поља.\n"
            + "Циљ је да се решетка испуни бројевима\n"
            + "од 1 до 9 у свим пољима. Свака колона,\n"
            + "сваки ред и сваки потквадрат (регион) мора\n"
            + "садржати све бројеве од 1 до 9 који се не смеју понављати.\n"
            + "Решавање судокуа (испуњавање решетке) захтева\n"
            + "само стрпљење и скромне логичке способности,\n"
            + "мада неке загонетке могу бити прилично тешке.\n";

    @Override
    public void start(Stage primaryStage) {
        BorderPane border = new BorderPane();

        VBox box = new VBox();
        Pane pane1 = new Pane();
        box.setStyle("-fx-background-color: black");
        Label label = new Label(TEXT);
        label.setFont(Font.font("Vedrana", FontWeight.BOLD, 15));
        label.setTextFill(Color.WHITE);

        Line line = new Line();
        line.setStartX(450);
        line.setStartY(670);
        line.setEndX(450);
        line.setEndY(-210);

        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(12000));
        path.setNode(label);
        path.setPath(line);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(false);
        path.play();

        Button b = new Button("Back");
        b.setMinWidth(110);
        b.setStyle("-fx-background-color: #b8ee36; -fx-font: 13 arial");

        b.setTranslateX(400);
        b.setTranslateY(-40);

        box.getChildren().add(label);
        pane1.getChildren().add(b);
        box.getTransforms().add(new Rotate(-50, 0, 100, 0, Rotate.X_AXIS));
        border.setCenter(box);
        border.setBottom(pane1);

        b.setOnMouseClicked(e -> {
            PocetniPanel p = new PocetniPanel();
            p.start(primaryStage);
        });

        Scene scene = new Scene(border, 900, 600);
        scene.setCamera(new PerspectiveCamera());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
