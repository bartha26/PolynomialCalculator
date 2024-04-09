package com.assgn.pt_2024_30425_bartha_tudor_assignment.models;

import com.assgn3.polynomial.model.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    //here I tested all the mathematical operations implemented in the polynomial class
    @Test
    void addition() {
        assertEquals("+2+3*x-4*x^2+1*x^4", new Polynomial("x^2+3*x+1").addition(new Polynomial("x^4-5*x^2+1")));
        assertEquals("+1*x^4", new Polynomial("x^2+3*x+1").addition(new Polynomial("x^4-x^2-3*x-1")));
        assertEquals("+1+3*x+3*x^2-3*x^3+4*x^4", new Polynomial("x^2+3*x+1").addition(new Polynomial("4*x^4-3*x^3+2*x^2")));
        assertEquals("+1-5*x+3*x^2-4*x^3+5*x^4", new Polynomial("x^2-5*x+1").addition(new Polynomial("5*x^4-4*x^3+2*x^2")));
        assertEquals("+7-2*x+3*x^2+5*x^3-2*x^4", new Polynomial("3*x^2-2*x+1").addition(new Polynomial("5*x^3-2*x^4+6")));
        assertEquals("+3*x-3*x^2-4*x^3+5*x^4", new Polynomial("-x^2+3*x").addition(new Polynomial("5*x^4-4*x^3-2*x^2")));
        assertEquals("+1-4*x+6*x^2+6*x^3+7*x^4", new Polynomial("x^2-4*x+1").addition(new Polynomial("7*x^4+6*x^3+5*x^2")));
        assertEquals("+1+8*x+8*x^2+6*x^3+5*x^4", new Polynomial("x^2+8*x+1").addition(new Polynomial("5*x^4+6*x^3+7*x^2")));
        assertEquals("+9-4*x+8*x^2+6*x^3+5*x^4", new Polynomial("x^2-4*x+9").addition(new Polynomial("5*x^4+6*x^3+7*x^2")));
        assertEquals("-6-5*x+5*x^2+3*x^3+2*x^4", new Polynomial("x^2-5*x-6").addition(new Polynomial("2*x^4+3*x^3+4*x^2")));
        assertEquals("+2+4*x-6*x^2+8*x^3", new Polynomial("2*x^3-6*x^2+4*x+1").addition(new Polynomial("6*x^3+1")));
        assertEquals("+10+4*x-5*x^2+7*x^3-2*x^4", new Polynomial("-4*x^2+7*x+10").addition(new Polynomial("7*x^3-2*x^4-3*x-x^2")));
    }
    @Test
    void subtraction() {
        assertEquals("+3*x+6*x^2-1*x^4", new Polynomial("x^2+3*x+1").subtraction(new Polynomial("x^4-5*x^2+1")));
        assertEquals("+2+6*x+2*x^2-1*x^4", new Polynomial("x^2+3*x+1").subtraction(new Polynomial("x^4-x^2-3*x-1")));
        assertEquals("+1+3*x-1*x^2+3*x^3-4*x^4", new Polynomial("x^2+3*x+1").subtraction(new Polynomial("4*x^4-3*x^3+2*x^2")));
        assertEquals("+1-5*x-1*x^2+4*x^3-5*x^4", new Polynomial("x^2-5*x+1").subtraction(new Polynomial("5*x^4-4*x^3+2*x^2")));
        assertEquals("-5-2*x+3*x^2-5*x^3+2*x^4", new Polynomial("3*x^2-2*x+1").subtraction(new Polynomial("5*x^3-2*x^4+6")));
        assertEquals("+3*x+1*x^2+4*x^3-5*x^4", new Polynomial("-x^2+3*x").subtraction(new Polynomial("5*x^4-4*x^3-2*x^2")));
        assertEquals("+1-4*x-4*x^2-6*x^3-7*x^4", new Polynomial("x^2-4*x+1").subtraction(new Polynomial("7*x^4+6*x^3+5*x^2")));
        assertEquals("+1+8*x-6*x^2-6*x^3-5*x^4", new Polynomial("x^2+8*x+1").subtraction(new Polynomial("5*x^4+6*x^3+7*x^2")));
        assertEquals("+9-4*x-6*x^2-6*x^3-5*x^4", new Polynomial("x^2-4*x+9").subtraction(new Polynomial("5*x^4+6*x^3+7*x^2")));
        assertEquals("-6-5*x-3*x^2-3*x^3-2*x^4", new Polynomial("x^2-5*x-6").subtraction(new Polynomial("2*x^4+3*x^3+4*x^2")));
        assertEquals("+4*x-6*x^2-4*x^3", new Polynomial("2*x^3-6*x^2+4*x+1").subtraction(new Polynomial("6*x^3+1")));
        assertEquals("+10+10*x-3*x^2-7*x^3+2*x^4", new Polynomial("-4*x^2+7*x+10").subtraction(new Polynomial("7*x^3-2*x^4-3*x-x^2")));
    }
    @Test
    void multiply(){
        assertEquals("-1+1*x^2",new Polynomial("x-1").multiplication(new Polynomial("x+1")));
        assertEquals("0",new Polynomial("x^3+1").multiplication(new Polynomial("0")));
        assertEquals("+26-16*x+3*x^2+11*x^3-6*x^4+3*x^5",new Polynomial("3*x^3+5*x+1+12").multiplication(new Polynomial("x^2-2*x+2")));
    }
    @Test
    void division(){
        ArrayList<String> result = new ArrayList<>();
        result.add("+1");
        result.add("0");
        assertEquals(result,new Polynomial("x+1").division(new Polynomial("x+1")));
        ArrayList<String> result2 = new ArrayList<>();
        result2.add("+2+1*x");
        result2.add("0");
        assertEquals(result2,new Polynomial("x^2+5*x+6").division(new Polynomial("x+3")));
        ArrayList<String> result3 = new ArrayList<>();
        result3.add("error");
        result3.add("error");
        assertEquals(result3,new Polynomial("x^2+5*x+6").division(new Polynomial("0")));
    }
    @Test
    void derivate(){
        assertEquals("+1+27*x^2-48*x^3",new Polynomial("9*x^3-12*x^4+x+5").derivate());
        assertEquals("+2+3*x^2+12*x^3",new Polynomial("3*x^4+x^3+2*x").derivate());
        assertEquals("0",new Polynomial("17").derivate());
    }
    @Test
    void integrate(){
        assertEquals("+1*x+9*x^3-12*x^4",new Polynomial("+1+27*x^2-48*x^3").integrate());
        assertEquals("+2*x+1*x^3+3*x^4",new Polynomial("+2+3*x^2+12*x^3").integrate());
        assertEquals("0",new Polynomial("0").integrate());
    }
}