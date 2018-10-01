package pluralsight1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class FirstApplication extends Application {
    public void start(Stage stage){
        //callback
        Label message1 = new Label("Hello world");
        message1.setFont(new Font(100));

        Label message2 = new Label("Hello world");
        message2.setFont(new Font(100));

        VBox vbox = new VBox(message1, message2);

        stage.setScene(new Scene(vbox));
        stage.setTitle("Hello");
        stage.show();
    }

    public static void  main(String... args){
        launch();
    }
}
