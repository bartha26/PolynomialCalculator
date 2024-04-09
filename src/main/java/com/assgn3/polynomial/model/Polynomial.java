package com.assgn3.polynomial.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Number> polynomial = new HashMap<>();

    public Polynomial(String polynomial) {
        this.parsePolynomial(polynomial);
        this.printPolynomial();
    }

    public void parsePolynomial(String polynomialString) {
        Pattern termPattern = Pattern.compile("(-?\\d*)\\*?x\\^?(\\d*)|(-?\\d+)(?!\\*x)");

        int coefficient;
        int exponent;
        for (Matcher matcher = termPattern.matcher(polynomialString); matcher.find(); this.polynomial.put(exponent, this.polynomial.getOrDefault(exponent, 0).intValue() + coefficient)) {
            if (matcher.group(1) != null) {
                if (matcher.group(1).isEmpty()) {
                    coefficient = 1;
                } else if (matcher.group(1).equals("-")) {
                    coefficient = -1;
                } else {
                    coefficient = Integer.parseInt(matcher.group(1));
                }

                exponent = matcher.group(2).isEmpty() ? 1 : Integer.parseInt(matcher.group(2));
            } else {
                coefficient = Integer.parseInt(matcher.group(3));
                exponent = 0;
            }
        }
    }

    private void printPolynomial() {
        System.out.println(this.polynomial);
    }

    public String addition(Polynomial polynomial) {
        Set<Map.Entry<Integer, Number>> pol1 = this.polynomial.entrySet();
        Set<Map.Entry<Integer, Number>> pol2 = polynomial.getPolynomial().entrySet();
        HashMap<Integer, Number> resultMap = new HashMap<>();
        Iterator var = pol1.iterator();
        Map.Entry entry;
        while (var.hasNext()) {
            entry = (Map.Entry) var.next();
            resultMap.put((Integer) entry.getKey(), (Number) entry.getValue());
        }
        var = pol2.iterator();
        int exponent;
        Number coefficient;
        while (var.hasNext()) {
            entry = (Map.Entry) var.next();
            exponent = (Integer) entry.getKey();
            coefficient = (Number) entry.getValue();
            resultMap.put(exponent, resultMap.getOrDefault(exponent, 0).doubleValue() + coefficient.doubleValue());
        }
        return toString(resultMap);
    }

    private String toString(HashMap<Integer, Number> resultMap) {
        Iterator var = resultMap.entrySet().iterator();
        Map.Entry entry;
        int exponent;
        Number coefficient;
        StringBuilder resultBuilder = new StringBuilder();
        while (var.hasNext()) {
            entry = (Map.Entry) var.next();
            exponent = (Integer) entry.getKey();
            coefficient = (Number) entry.getValue();
            if (coefficient.doubleValue() != 0) {
                if (coefficient.doubleValue() > 0) {
                    resultBuilder.append("+");
                } else {
                    resultBuilder.append("-");
                }
                if(coefficient.doubleValue() - coefficient.intValue() < 1e-6)
                    resultBuilder.append(Math.abs(coefficient.intValue()));
                else
                    resultBuilder.append(Math.abs(coefficient.doubleValue()));
                if (exponent > 0) {
                    resultBuilder.append("*x");
                    if (exponent > 1) {
                        resultBuilder.append("^").append(exponent);
                    }
                }
            }
        }
        if(resultBuilder.isEmpty()) resultBuilder.append("0");
        return resultBuilder.toString();
    }

    public String subtraction(Polynomial polynomial) {
        Set<Map.Entry<Integer, Number>> pol1 = this.polynomial.entrySet();
        Set<Map.Entry<Integer, Number>> pol2 = polynomial.getPolynomial().entrySet();
        HashMap<Integer, Number> resultMap = new HashMap<>();
        Iterator var = pol1.iterator();
        Map.Entry entry;
        while (var.hasNext()) {
            entry = (Map.Entry) var.next();
            resultMap.put((Integer) entry.getKey(), (Number) entry.getValue());
        }
        var = pol2.iterator();
        int exponent;
        Number coefficient;
        while (var.hasNext()) {
            entry = (Map.Entry) var.next();
            exponent = (Integer) entry.getKey();
            coefficient = (Number) entry.getValue();
            resultMap.put(exponent, resultMap.getOrDefault(exponent, 0).doubleValue() - coefficient.doubleValue());
        }
        return toString(resultMap);
    }

    public String multiplication(Polynomial polynomial){
        Set<Map.Entry<Integer, Number>> pol1 = this.polynomial.entrySet();
        Set<Map.Entry<Integer, Number>> pol2 = polynomial.getPolynomial().entrySet();
        HashMap<Integer, Number> resultMap = new HashMap<>();
        Iterator iterator = pol1.iterator();
        while(iterator.hasNext()){
            Map.Entry pol1Entry = (Map.Entry) iterator.next();
            int exponent1 = (int) pol1Entry.getKey();
            Number coefficient1 = (Number) pol1Entry.getValue();
            for(Map.Entry<Integer , Number> pol2Entry : pol2){
                int exponent2 = pol2Entry.getKey();
                Number coefficient2 = pol2Entry.getValue();
                int resultExp = exponent1 + exponent2;
                double resultCoeff = coefficient1.doubleValue() * coefficient2.doubleValue();
                resultMap.put(resultExp, resultMap.getOrDefault(resultExp, 0).doubleValue() + resultCoeff);
            }
        }
        return toString(resultMap);
    }

    public String derivate(){
        Set<Map.Entry<Integer, Number>> pol = this.polynomial.entrySet();
        HashMap<Integer, Number> resultMap = new HashMap<>();
        for(Map.Entry polEntry : pol) {
            int exponent = (int) polEntry.getKey();
            Number coefficient = (int) polEntry.getValue();
            if (exponent != 0) {
                int newExponent = exponent - 1;
                int newCoefficient = exponent * coefficient.intValue();
                resultMap.put(newExponent, resultMap.getOrDefault(newExponent, 0).intValue() + newCoefficient);
            }
        }
        return toString(resultMap);
    }

    public String integrate(){
        Set<Map.Entry<Integer, Number>> pol = this.polynomial.entrySet();
        HashMap<Integer, Number> resultMap = new HashMap<>();
        for(Map.Entry polEntry : pol) {
            int exponent = (int) polEntry.getKey();
            Number coefficient = (int) polEntry.getValue();
            if (exponent != 0) {
                int newExponent = exponent + 1;
                Number newCoefficient = Math.floor(coefficient.doubleValue() / (double) newExponent);
                resultMap.put(newExponent, resultMap.getOrDefault(newExponent, 0).doubleValue() + newCoefficient.doubleValue());
            } else {
                int newExponent = 1;
                resultMap.put(newExponent, resultMap.getOrDefault(newExponent, 0).doubleValue() + coefficient.doubleValue());
            }
        }
        return toString(resultMap);
    }

    public ArrayList<String> division(Polynomial polynomial){
        ArrayList<String> result = new ArrayList<>();
        if(testInput(polynomial,result) == 0) return result;
        HashMap<Integer , Number> quotient = new HashMap<>();
        HashMap<Integer , Number> remainder = new HashMap<>(this.polynomial);
        remainder.entrySet().removeIf(entry -> entry.getValue().doubleValue() == 0.0);
        int dividentExponent = remainder.keySet().stream().max(Integer::compare).orElse(0);
        int divisorExponent = polynomial.polynomial.keySet().stream().max(Integer::compare).orElse(0);
        while(dividentExponent >= divisorExponent && (dividentExponent != 0 && divisorExponent != 0)){
            int exponentDifference = dividentExponent - divisorExponent;
            if(polynomial.polynomial.get(divisorExponent).doubleValue() == 0.0) {
                errorMessage(result);
                return result;
            }
            Number coefficietDiv = remainder.get(dividentExponent).doubleValue() / polynomial.polynomial.get(divisorExponent).doubleValue();
            quotient.put(exponentDifference,coefficietDiv);
            HashMap<Integer ,Number> termToSubstract = new HashMap<>();
            for(Map.Entry<Integer , Number> term : polynomial.polynomial.entrySet()){
                termToSubstract.put(term.getKey() + exponentDifference, term.getValue().doubleValue() * coefficietDiv.doubleValue());
            }
            for(Map.Entry<Integer ,Number> term : termToSubstract.entrySet()){
                remainder.put(term.getKey() , remainder.getOrDefault(term.getKey(), 0).doubleValue() -  term.getValue().doubleValue());
            }
            remainder.entrySet().removeIf(entry -> entry.getValue().doubleValue() == 0.0);
            dividentExponent = remainder.keySet().stream().max(Integer::compare).orElse(0);
            divisorExponent = polynomial.polynomial.keySet().stream().max(Integer::compare).orElse(0);
        }
        result.add(toString(quotient));
        result.add(toString(remainder));
        return result;
    }

    public HashMap<Integer, Number> getPolynomial() {
        return this.polynomial;
    }

    private int testInput(Polynomial polynomial,ArrayList<String> result){
        if(polynomial.polynomial.isEmpty() || toString(polynomial.polynomial).equals("0")) {
            result.add("error");
            result.add("error");
            return 0;
        }
        return 1;
    }
    private void errorMessage(ArrayList<String> result){
        result.add("error division by 0,check input");
        result.add("error division by 0 check input");
    }
}
