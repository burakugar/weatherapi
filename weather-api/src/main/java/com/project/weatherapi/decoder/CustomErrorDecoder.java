package com.project.weatherapi.decoder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.weatherapi.exception.FeignClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import com.project.weatherapi.common.Error;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();
    private final ObjectMapper objectMapper;

    public CustomErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try (Reader reader = response.body().asReader(Charset.defaultCharset())) {
            String body = IOUtils.toString(reader);
            Error error = objectMapper.readValue(body, Error.class);
            throw new FeignClientException(error.getCode(), error.getError());
        } catch (IOException e) {
            log.error("Failed to read the response body with error:", e);
        }

        return errorDecoder.decode(methodKey, response);
    }

}
