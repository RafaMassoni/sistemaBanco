package br.com.rafa.sistemabanco.exceptions;

public class SaldoInsuficiente extends RuntimeException{


    public SaldoInsuficiente(String message) {
        super(message);
    }
}
