package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerVollMed {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404() {

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException e) {

        var errors = e.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorsValidation::new).toList());
    }

    private record DataErrorsValidation(String field, String message) {

        public DataErrorsValidation(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
