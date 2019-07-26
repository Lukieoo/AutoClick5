package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public JFXTextField ilosc_clickow;
    public JFXTextField opuznienie_clickow;
    public TextArea Send;
    public TextField ilosc;

    Robot robot;
    public int i = 3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public void exit(MouseEvent mouseEvent) {
        System.exit(0);

    }

    public void turn_on(ActionEvent actionEvent) throws InterruptedException {

//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
//            label.setText(String.valueOf(--i));
//        }));
//        timeline.setCycleCount(Animation.INDEFINITE);
//
//        if (i==0){
//
//
//        }else{
//            timeline.play();
//        }


        robot.delay(4000);


        i = 3;
        for (int i = 0; i < Integer.parseInt(ilosc_clickow.getText()); i++) {

            Thread.sleep(Integer.parseInt(opuznienie_clickow.getText()));
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        }


        //  label.setText(String.valueOf(0));
    }


    public void turn_on2(ActionEvent actionEvent) throws InterruptedException, IOException, UnsupportedFlavorException {
        robot.delay(4000);
        String myString = Send.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        String copied = (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);

        for (int i = 0; i < Integer.parseInt(ilosc.getText()); i++) {
            Thread.sleep(1000);
//        robot.keyPress(KeyEvent.VK_A);
//        robot.keyRelease(KeyEvent.VK_A);
//  SCHOWEK SYSTEMOWY

            //Send.setText(copied);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }
    }

//    class Helper extends TimerTask {
//
//        public void run() {
//
//            System.out.println("Timer ran " + i--);
//
//          //  label.setText(String.valueOf(i--));
//
//        }
//    }
}

