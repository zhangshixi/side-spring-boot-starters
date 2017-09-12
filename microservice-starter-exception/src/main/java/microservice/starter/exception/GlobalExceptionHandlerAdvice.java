package microservice.starter.exception;

import microservice.starter.exception.business.BusinessException;
import microservice.starter.exception.system.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * Global exception handler resolver.
 * <p>
 * Created: 2016-11-20 10:08:35
 *
 * @author Michael.Zhang
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    /**
     * 400 - Bad Request.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = {
            BindException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestParameterException.class,
            MissingServletRequestPartException.class,
            TypeMismatchException.class,
            ValidationException.class,
            ConstraintViolationException.class
    })
    public Object badRequestException(HttpServletRequest request, Exception ex) {
        String message = doGetErrorMessage(ex);
        LOGGER.warn(message, ex);
        return new BaseResponse(HttpServletResponse.SC_BAD_REQUEST, message);
    }

    /**
     * 404 - Not Found.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = {
            NoHandlerFoundException.class,
            NoSuchRequestHandlingMethodException.class
    })
    public Object notFoundException(HttpServletRequest request, Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
    }

    /**
     * 405 - Method Not Allowed.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Object methodNotAllowException(HttpServletRequest request, Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_METHOD_NOT_ALLOWED, ex.getMessage());
    }

    /**
     * 406 - Not Acceptable.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
    public Object notAcceptableException(HttpServletRequest request, Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_NOT_ACCEPTABLE, ex.getMessage());
    }

    /**
     * 415 - Unsupported Media Type.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public Object unsupportedMediaTypeException(HttpServletRequest request, Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, ex.getMessage());
    }

    /**
     * 500 - Internal Server Error.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(value = {
            ConversionNotSupportedException.class,
            HttpMessageNotWritableException.class,
            MissingPathVariableException.class
    })
    public Object serverErrorException(HttpServletRequest request, Exception ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    /**
     * -1 - Server Error And Other Unknown Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(Exception.class)
    public Object unknownException(HttpServletRequest request, Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new BaseResponse(SystemException.RESPONSE_CODE, ex.getMessage());
    }

    /**
     * User Define - Business Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(BusinessException.class)
    public Object businessException(HttpServletRequest request, BusinessException ex) {
        LOGGER.warn(ex.getMessage(), ex);
        return new BaseResponse(ex.getResponseCode(), ex.getMessage());
    }

    /**
     * User Define - Server Error And Other Unknown Exception.
     *
     * @param request http request.
     * @param ex      target exception.
     * @return response.
     */
    @ExceptionHandler(SystemException.class)
    public Object systemException(HttpServletRequest request, SystemException ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new BaseResponse(ex.getResponseCode(), ex.getMessage());
    }

    private String doGetErrorMessage(Exception ex) {
        String message = ex.getMessage();

        if (ex instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            StringBuilder messageBuilder = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                messageBuilder.append("[").append(error.getField()).append(":").append(error.getDefaultMessage()).append("]");
            }
            message = messageBuilder.toString();
        }

        return message;
    }

}
