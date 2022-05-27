package com.company;

import java.util.Scanner;

class FirstClass {
    double a, b, c;

    public FirstClass(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void Example (double a, double b, double c){
        double result = a * Math.pow(b, c);
    }
}

class SecondClass {
    double a, b, c;

    public SecondClass(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double Example (double a, double b, double c){
        double result = a * Math.pow(b, c);
        return result;
    }
}

@FunctionalInterface
interface Converter<First, Second>{
    Second convert(First o);

    static <First> boolean isNotNull(First o){
        return o != null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Выражение: a * b ^ c");
        System.out.print("Введите значение a = ");
        double a = in.nextDouble();
        System.out.print("Введите значение b = ");
        double b = in.nextDouble();
        System.out.print("Введите значение c = ");
        double c = in.nextDouble();
        FirstClass fc = new FirstClass(a, b, c);
        Converter<FirstClass, SecondClass> converter = x -> new SecondClass(x.a, x.b, x.c);
        SecondClass sc = converter.convert(fc);

        System.out.println("Ответ: " + sc.Example(a, b, c));
    }
}