//package musinsa.test.codi.exception;
//
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
//import musinsa.test.codi.admin.response.AdminResponse;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//// 전역 예외 처리
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<AdminResponse> handleDuplicateKeyException(DuplicateKeyException e) {
//        AdminResponse response = new AdminResponse(false, "중복된 값이 존재합니다.", null);
//        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<AdminResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
//        AdminResponse response = new AdminResponse(false, "데이터 오류가 발생했습니다.", null);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public ResponseEntity<AdminResponse> handleSQLException(SQLException e) {
//        AdminResponse response = new AdminResponse(false, "데이터 오류가 발생했습니다.", null);
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<AdminResponse> handleRuntimeException(RuntimeException e) {
//        AdminResponse response = new AdminResponse(false, "알 수 없는 오류가 발생했습니다.", null);
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}