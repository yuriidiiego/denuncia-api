package br.com.run2biz.denuncia.config.log;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(
    LoggingInterceptor.class
  );
  private static final String REQUEST_ID_HEADER = "X-Request-Id";

  @Override
  public boolean preHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler
  ) throws Exception {
    String requestId = request.getHeader(REQUEST_ID_HEADER);
    if (requestId == null) {
      requestId = UUID.randomUUID().toString();
      request.setAttribute(REQUEST_ID_HEADER, requestId);
    }

    request.setAttribute("startTime", System.currentTimeMillis());

    logger.info(
      "[{}] from=denuncia-api method={} endpoint={}",
      requestId,
      request.getMethod(),
      request.getRequestURI()
    );
    return true;
  }

  @Override
  public void postHandle(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    @Nullable ModelAndView modelAndView
  ) throws Exception {
    long startTime = (Long) request.getAttribute("startTime");
    long duration = System.currentTimeMillis() - startTime;

    logger.info(
      "[{}] status={} duration={}ms",
      request.getAttribute(REQUEST_ID_HEADER),
      response.getStatus(),
      duration
    );
  }
}

// Como analista de sistemas, eu desenvolvia APIs, fazia documentação de APis e ajudava a documentar o sistema.
// Criava testes de unidade e de integração.
// Criava scripts SQL para fazer buscas no banco de dados. Fazia manutenção como backup, restauração e migração desses dados.

// Como desenvolvedor backend na Vertigo,