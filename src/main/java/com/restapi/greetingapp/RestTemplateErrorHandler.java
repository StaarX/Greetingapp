package com.restapi.greetingapp;

import com.restapi.greetingapp.exceptions.InternalException;
import com.restapi.greetingapp.exceptions.InvalidFieldException;
import com.restapi.greetingapp.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        HttpStatus status = clientHttpResponse.getStatusCode();
        return status.is4xxClientError() || status.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
            if (httpResponse.getStatusCode()==HttpStatus.CONFLICT) throw new InternalException("Error while trying to retrieve Employee");
        } else if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) throw new NotFoundException("Employee was not found");
            if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) throw new InvalidFieldException("Fields are not valid");
        }
    }
}
