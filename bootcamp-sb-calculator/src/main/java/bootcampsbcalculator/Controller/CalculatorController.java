package bootcampsbcalculator.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {
    @GetMapping
    public ResponseEntity<Object> calculateUsingQueryParams(
            @RequestParam String x,
            @RequestParam String y,
            @RequestParam String operation) {
        return calculate(x, y, operation);
    }

    @PostMapping
    public ResponseEntity<Object> calculateUsingJsonPayload
    (@RequestBody CalculationRequest request) {
        String x = request.getX();
        String y = request.getY();
        String operation = request.getOperation();

        return calculate(x, y, operation);
    }

    @GetMapping
    public ResponseEntity<Object> calculateUsingPathParams(
            @PathVariable String x,
            @PathVariable String y,
            @PathVariable String operation) {
        return calculate(x, y, operation);
    }

    private ResponseEntity<Object> calculate(String x, String y, String operation) {
        try {
            BigDecimal operandX = new BigDecimal(x);
            BigDecimal operandY = new BigDecimal(y);

            BigDecimal result;
            switch (operation) {
                case "add":
                    result = operandX.add(operandY);
                    break;
                case "sub":
                    result = operandX.subtract(operandY);
                    break;
                case "mul":
                    result = operandX.multiply(operandY);
                    break;
                case "div":
                    result = operandX.divide(operandY, 5, RoundingMode.HALF_UP);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation.");
            }

            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("x", x);
            responseMap.put("y", y);
            responseMap.put("operation", operation);
            responseMap.put("result", result.toString());

            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid input.", HttpStatus.BAD_REQUEST);
        } catch (ArithmeticException e) {
            return new ResponseEntity<>("Cannot divide by zero.", HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid operation.", HttpStatus.BAD_REQUEST);
        }
    }

    public static class CalculationRequest {
        private String x;
        private String y;
        private String operation;
    }
  }