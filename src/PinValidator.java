import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alexander on 05.08.16.
 */
public class PinValidator {
    public void Validator(int pin) {
        if (pin != 1234) {
            throw new IncorrectPinException("Введенный пин-код не верен, попробуйте ещё раз");
        }
    }

}
