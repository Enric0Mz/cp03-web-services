package br.com.fiap3esr.spring_boot_project.infra.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
