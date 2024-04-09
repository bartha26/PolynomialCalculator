package com.assgn3.polynomial.controllers;

import com.assgn3.polynomial.model.Polynomial;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class HelloController extends SceneController {
    @FXML
    private TextField polynomial1Text;
    @FXML
    private TextField polynomial2Text;
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    @FXML
    private TextField result;
    @FXML
    private TextField remainder;
    @FXML
    private Button exit;
    @FXML
    private AnchorPane anchorPane;
    private final String pattern = "(-?\\d*\\*?x\\^?\\d+|-?\\d*\\*?x|\\d+)(?:[+-](-?\\d*\\*?x\\^?\\d+|-?\\d*\\*?x|\\d+))*";
    private Image backgroundImage = new Image("C:\\Users\\TudorB\\Desktop\\polynomial.jpeg");

    // Create a background image
    BackgroundImage background = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)

    );
    public void onAddButtonClick() {
        clear();
        if(testInputs()==3) {
            result.setText(polynomial1.addition(polynomial2));
        } else result.setText("please input a polynomial1 and polynomial2 as in the description below");
    }

    public void onSubtractButtonClick() {
        clear();
        if(testInputs()==3) {
            result.setText(polynomial1.subtraction(polynomial2));
        } else result.setText("please input a polynomial1 and polynomial2 as in the description below");
    }

    public void onMultiplyButtonClick() {
        clear();
        if(testInputs()==3) {
            result.setText(polynomial1.multiplication(polynomial2));
        } else result.setText("please input a polynomial1 and polynomial2 as in the description below");
    }

    public void onDivideButtonClick() {
        clear();
        if(testInputs()==3) {
            ArrayList<String> divisionResult = polynomial1.division(polynomial2);
            result.setText(divisionResult.get(0));
            remainder.setText(divisionResult.get(1));
        } else result.setText("please input a polynomial1 and polynomial2 as in the description below");
    }

    public void onDifferentiateButtonClick() {
        clear();
        if(testInputs()>=1 && testInputs()!=2) {
            result.setText(polynomial1.derivate());
        } else result.setText("please input a polynomial1 as in the description below");
    }

    public void onIntegrateButtonClick() {
        clear();
        if(testInputs()>=1 && testInputs()!=2) {
            result.setText(polynomial1.integrate());
        } else result.setText("please input a polynomial1 as in the description below");
    }
    public void onExitButtonClick(){
        this.closeApplication();
    }
    @FXML
    public void initialize() {
        // Set the background for the VBox
        anchorPane.setBackground(new Background(background));
    }
    private int testInputs(){
        int ok = 0;
        polynomial1 = new Polynomial(polynomial1Text.getText());
        polynomial2 = new Polynomial(polynomial2Text.getText());
        if(polynomial1Text.getText().matches(pattern)){
            ok=1;
        }
        if(polynomial2Text.getText().matches(pattern)){
            ok=ok+2;
        }
        System.out.println("ok = " + ok);
        return ok;
    }
    private void clear(){
        this.result.clear();
        this.remainder.clear();
    }
}