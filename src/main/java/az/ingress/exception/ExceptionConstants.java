package az.ingress.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionConstants {
    EMPLOYEE_NOT_FOUND("EMPLOYEE_NOT_FOUND","Employee not found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "Unexpected exception occured");

    private final String code;
    private final String message;
}
