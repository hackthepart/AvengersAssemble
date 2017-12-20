//  # LANGUAGE: JAVA 1.8
//  # AUTHOR: Surbhit Awasthi
//  # GITHUB: https://github.com/surbhitawasthi
//  # A Graphical representation

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;


import static javafx.scene.paint.Color.WHITE;

public class hello_world extends Application
{

    public static void main(String args[])
    {
        launch(args);
    }

    StackPane sp;
    Label lb;
    Stage window;
    Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        window.setTitle("Hello MNNIT");

        sp=new StackPane();

        //sp.setOpacity(0);
        sp.setEffect(new Glow(0.5));
        sp.setStyle("-fx-background-color: green; -fx-background-radius: 5;");

        lb=new Label("Hello MNNIT");
        lb.setPadding(new Insets(75,0,0,0));
        lb.setTextAlignment(TextAlignment.CENTER);
        lb.setFont(Font.font(70.0));
        lb.setEffect(new Reflection());
        lb.setTextFill(WHITE);

        Image image=new Image("logo_hack36_front.png");
        ImageView imageView=new ImageView(image);

        imageView.setFitHeight(150);
        imageView.setFitWidth(200);
        imageView.setNodeOrientation(NodeOrientation.INHERIT);
        imageView.setPickOnBounds(true);
        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(10.41);
        innerShadow.setWidth(8.86);
        innerShadow.setWidth(34.78);
        imageView.setEffect(innerShadow);

        sp.setMargin(imageView,new Insets(10,0,0,0));
        sp.setAlignment(imageView, Pos.TOP_CENTER);
        sp.getChildren().addAll(imageView,lb);

        scene=new Scene(sp,600,400);
        window.setScene(scene);
        window.show();
        fadeInScene();
        moveLabel();
    }

    private void fadeInScene()
    {
        FadeTransition fadeIn=new FadeTransition(Duration.seconds(2),sp);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    private void moveLabel()
    {
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(2),lb);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.setFromX(-75);
        translateTransition.setToX(75);

        translateTransition.play();
    }
}
