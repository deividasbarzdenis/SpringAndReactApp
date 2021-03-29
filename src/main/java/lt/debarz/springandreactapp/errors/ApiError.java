package lt.debarz.springandreactapp.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
@JsonInclude(value = Include.NON_NULL)
public class ApiError {

    private long timestamp = new Date().getTime();

    private int status;

    private String url;

    private String message;

    private Map<String, String> validationErrors;

    public ApiError(int status, String message, String url) {
        this.status = status;
        this.message = message;
        this.url = url;
    }
}
