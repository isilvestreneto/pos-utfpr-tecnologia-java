package org.example;

public class VeicExistException extends Exception {

        public VeicExistException() {
            super("Veículo já cadastrado!");
        }

        public VeicExistException(String msg) {
            super(msg);
        }

        public VeicExistException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public VeicExistException(Throwable cause) {
            super(cause);
        }

        public VeicExistException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(msg, cause, enableSuppression, writableStackTrace);
        }
}
