/**
 * Created by alexander on 05.08.16.
 */
public class IncorrectSumm {
    public void incorrect(int a) {
        if (a % 100 != 0) {
            throw new IncorrectSummException("Некорректная сумма. Класть и снимать деньги можно только, если сумма кратна 100");
        }
    }
}
