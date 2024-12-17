package org.example;

public class VeicExistException extends Exception {

        public VeicExistException() {
            super("Veículo já cadastrado!");
        }
}
