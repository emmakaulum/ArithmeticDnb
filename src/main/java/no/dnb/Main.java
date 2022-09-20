package no.dnb;
import com.amazonaws.services.lambda.runtime.Context;
import no.dnb.dtos.ArithmeticOperation;
import no.dnb.dtos.Response;

public class Main {
    public static void main(String[] args) {
    }
    public static Response handleRequest(ArithmeticOperation arg, Context context) {
        String operation = arg.getOperation();
        double lh = arg.getFirst_number();
        double rh = arg.getSecond_number();
        double result = 0;
        switch (operation) {
            case "ADD":
                result = lh + rh;
                break;
            case "SUBTRACT":
                result = lh - rh;
                break;
            case "MULTIPLY":
                result = lh * rh;
                break;
            case "DIVIDE":
                if (rh == 0) throw new ArithmeticException();
                result = lh / rh;
                break;
        }
        return new Response(result);
    }
}