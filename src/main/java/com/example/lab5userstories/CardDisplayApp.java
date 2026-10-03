package com.example.lab5Userstories;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.InputStream;

public class CardDisplayApp extends Application {

    Deck deck = new Deck();
    GridPane cardGrid = new GridPane();

    @Override
    public void start(Stage stage) {

        cardGrid.setHgap(8);
        cardGrid.setVgap(10);
        cardGrid.setPadding(new Insets(15));
        cardGrid.setAlignment(Pos.CENTER);

        cardGrid.setStyle(
                "-fx-background-color: darkgreen;"
        );

        Button shuffleButton = new Button("Shuffle");

        shuffleButton.setPrefWidth(200);

        shuffleButton.setOnAction(event -> {
            deck.shuffle();
            displayCards();
        });

        BorderPane root = new BorderPane();

        root.setCenter(cardGrid);
        root.setBottom(shuffleButton);

        BorderPane.setAlignment(
                shuffleButton,
                Pos.CENTER
        );

        BorderPane.setMargin(
                shuffleButton,
                new Insets(10)
        );

        displayCards();

        Scene scene = new Scene(
                root,
                1000,
                520
        );

        stage.setTitle("Card Randomizer");
        stage.setScene(scene);
        stage.show();
    }

    public void displayCards() {

        cardGrid.getChildren().clear();

        int columns = 13;

        for (int i = 0; i < deck.getCards().size(); i++) {

            Card card = deck.getCards().get(i);

            InputStream input =
                    getClass().getResourceAsStream(
                            card.getImagePath()
                    );

            if (input == null) {

                System.out.println(
                        "IMAGE NOT FOUND: "
                                + card.getImagePath()
                );

                continue;
            }

            Image image = new Image(input);

            ImageView imageView =
                    new ImageView(image);

            imageView.setFitWidth(55);
            imageView.setFitHeight(80);

            imageView.setPreserveRatio(true);

            int row = i / columns;
            int column = i % columns;

            cardGrid.add(
                    imageView,
                    column,
                    row
            );
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}