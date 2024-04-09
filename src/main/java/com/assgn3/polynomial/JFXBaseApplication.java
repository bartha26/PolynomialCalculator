package com.assgn3.polynomial;


import com.assgn3.polynomial.model.Polynomial;
import com.assgn3.polynomial.res.ApplicationHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class JFXBaseApplication extends Application {
    public JFXBaseApplication() {
    }

    public void start(Stage stage) {
        Polynomial polynomial = new Polynomial("x^5-2*x^4+6*x^2+7*x+2");
        Polynomial polynomial1 = new Polynomial("4*x^6+x^4+5*x^2+3*x+2");
        Polynomial polynomial2 = new Polynomial("2*x^3+9*x^2+14*x+5");
        Polynomial polynomial3 = new Polynomial("2*x+1");
        System.out.println(polynomial1.addition(polynomial));
        System.out.println(polynomial1.subtraction(polynomial));
        System.out.println(polynomial1.multiplication(polynomial));
        System.out.println();
        System.out.println(polynomial2.addition(polynomial3));
        System.out.println(polynomial2.subtraction(polynomial3));
        System.out.println(polynomial2.multiplication(polynomial3));
        System.out.println();
        System.out.println(polynomial3.derivate());
        System.out.println();
        System.out.println(polynomial3.integrate());
        System.out.println();
        System.out.println(polynomial2.division(polynomial3));
        ApplicationHandler.getInstance().startApplication(stage);
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}