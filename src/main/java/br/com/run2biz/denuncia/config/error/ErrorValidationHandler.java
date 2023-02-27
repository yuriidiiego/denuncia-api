package br.com.run2biz.denuncia.config.error;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorValidationHandler extends ResponseEntityExceptionHandler {

  private final MessageSource messageSource;

  public ErrorValidationHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    org.springframework.http.HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
    List<ErrorResponse> errors = new ArrayList<>();
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    fieldErrors.forEach(e -> {
      String message = messageSource.getMessage(
        e,
        LocaleContextHolder.getLocale()
      );
      int statusCode = HttpStatus.BAD_REQUEST.value();
      ErrorResponse error = new ErrorResponse(statusCode, message);
      errors.add(error);
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityViolationException(
    DataIntegrityViolationException ex,
    WebRequest request
  ) {
    String message = ex.getMostSpecificCause().getMessage();
    if (message.contains("PUBLIC.UK_6ONVI3H2TS412UFROA6Y28LGH_INDEX_9")) {
      ErrorResponse error = new ErrorResponse(
        HttpStatus.CONFLICT.value(),
        "Já existe algum registro de denúncia para o endereço em questão."
      );
      return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    } else {
      ErrorResponse error = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        message
      );
      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
  }
}
