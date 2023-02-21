package br.com.run2biz.denuncia.config.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@Schema(name = "ErrorResponse", description = "Payload para retorno de erro")
public class ErrorResponse {

  @Schema(name = "statusCode", description = "Status code", example = "400")
  private int statusCode;

  @Schema(
    name = "timestamp",
    description = "Timestamp",
    example = "01/01/2000 00:00:00"
  )
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  @Schema(
    name = "message",
    description = "Mensagem de erro",
    example = "Bad Request"
  )
  private String message;

  public ErrorResponse(int statusCode, String message) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = message;
  }

  public ErrorResponse(int statusCode, List<String> messages) {
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now();
    this.message = messages.toString();
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
