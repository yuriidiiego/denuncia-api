package br.com.run2biz.denuncia.config.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ExceptionLoggingInterceptor implements HandlerInterceptor {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    ExceptionLoggingInterceptor.class
  );

  @Override
  public void afterCompletion(
    HttpServletRequest request,
    HttpServletResponse response,
    Object handler,
    @Nullable Exception ex
  ) throws Exception {
    if (ex != null) {
      LOGGER.error("Exception occurred: ", ex);
    }
  }
}
