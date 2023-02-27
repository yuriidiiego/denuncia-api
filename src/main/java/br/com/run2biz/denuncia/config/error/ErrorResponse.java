package br.com.run2biz.denuncia.config.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class ErrorResponse {

  private int statusCode;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  private String message;

  public ErrorResponse() {}

  public ErrorResponse(int statusCode, String message) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
