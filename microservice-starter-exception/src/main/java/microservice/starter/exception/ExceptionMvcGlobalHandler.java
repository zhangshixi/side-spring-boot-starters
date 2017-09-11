package microservice.starter.exception;

import microservice.starter.exception.business.BusinessException;
import microservice.starter.exception.business.NotFoundException;
import microservice.starter.exception.business.ParameterException;
import microservice.starter.exception.system.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * Created: 2016-11-20 10:08:35
 *
 * @author Michael.Zhang
 */
@ControllerAdvice
public class ExceptionMvcGlobalHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionMvcGlobalHandler.class);

    public ExceptionMvcGlobalHandler() {
        LOGGER.info("Constructor initialize: {}", getClass());
    }

    /**
     * 400 - Bad Request.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(value = {
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            BindException.class,
            ValidationException.class,
            ConstraintViolationException.class
    })
    public Object badRequestException(HttpServletRequest request, ParameterException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    /**
     * 405 - Method Not Allowed.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Object methodNotAllowException(HttpServletRequest request, NotFoundException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_METHOD_NOT_ALLOWED, ex.getMessage());
    }

    /**
     * 415 - Unsupported Media Type.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public Object unsupportedMediaTypeException(HttpServletRequest request, NotFoundException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, ex.getMessage());
    }

    /**
     * -1 - Server Error And Other Unknown Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object unknownException(HttpServletRequest request, Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new BaseResponse(SystemException.RESPONSE_CODE, ex.getMessage());
    }

    /**
     * User Define - Server Error And Other Unknown Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(SystemException.class)
    public Object systemException(HttpServletRequest request, SystemException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getResponseCode(), ex.getMessage());
    }

    /**
     * User Define - Business Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Object businessException(HttpServletRequest request, BusinessException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(ex.getResponseCode(), ex.getMessage());
    }

}
