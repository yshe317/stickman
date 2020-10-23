package stickman;

import javafx.application.Application;
import javafx.stage.Stage;
import stickman.model.GameEngine;
import stickman.model.GameEngineImpl;
import stickman.view.GameWindow;

import java.util.Map;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Map<String, String> params = getParameters().getNamed();

        String s = "Java 11 sanity check";
        if (s.isBlank()) {
            throw new IllegalStateException("You must be running Java 11+. You won't ever see this exception though" +
                    " as your code will fail to compile on Java 10 and below.");
        }

        GameEngine model = new GameEngineImpl("src/main/resources/configuration.json");
        GameWindow window = new GameWindow(model, 640, 400);
        window.run();

        primaryStage.setTitle("Stickman");
        primaryStage.setScene(window.getScene());
        primaryStage.show();

        window.run();
    }
}
