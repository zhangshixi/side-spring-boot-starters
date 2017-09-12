package microservice.starter.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Global response body advice.
 * <p>
 * Created: 2017-09-12 13:16:12
 *
 * @author Michael.Zhang
 */
@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public final Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType contentType, Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest request, ServerHttpResponse response) {
        return this.getOrCreateContainer(body);
    }

    private MappingJacksonValue getOrCreateContainer(Object body) {
        if (body instanceof MappingJacksonValue) {
            return (MappingJacksonValue) body;
        }

        BaseResponse innerBody;
        if (body instanceof BaseResponse) {
            innerBody = (BaseResponse) body;
        } else {
            innerBody = new BaseResponse(body);
        }

        if (innerBody.getResponseMessage() == null) {
            innerBody.setResponseMessage("success");
        }

        return new MappingJacksonValue(innerBody);
    }

}
