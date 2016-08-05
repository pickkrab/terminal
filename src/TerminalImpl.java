/**
 * Created by alexander on 05.08.16.
 */
public class TerminalImpl{
    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();
    private final IncorrectSumm incorrect_ = new IncorrectSumm();
    private boolean locked = false;
    private int count = 0;
    private long curTime = 0;

    public void enter_pin(int pin) throws InterruptedException {
        if (locked == false) {
            try {
                pinValidator.Validator(pin);
            } catch (IncorrectPinException e) {
                count++;
                if (count == 3) {
                    locked = true;
                    curTime = System.currentTimeMillis();
                    Thread.sleep(5000);
                    count = 0;
                    locked = false;
                }
            }

        }
        if (locked == true) {
            try {
                throw new AccountIsLockedException("Ваш счет временно заблокирован. Повторите попытку не раньше " + (curTime + 5000) + "Постарайтесь ввести корректный пин");
            } catch (AccountIsLockedException e) {
                e.getMessage();
            }
        }
    }

    public void show_balance() {
        try {
            int _balance = server.check_balance();
            System.out.println("На вашем счете: " + _balance);
        } catch (BadConnectionException e) {
            e.getMessage();
        }
    }

    public void put_balance(int a) {
        try {
            incorrect_.incorrect(a);
            int _balance = server.add_money(a);
            System.out.println("Ваш новый баланс: " + _balance);
        } catch (IncorrectSummException e) {
            e.getMessage();
        }
        catch (ThisFunctionIsNotAvailableException e) {
            e.getMessage();
        }
    }

    public void get_balance(int a) {
        try {
            if (a % 100 != 0) {
                System.out.println("Некорректная сумма. Класть и снимать деньги можно только, если сумма кратна 100");
            }
            int _balance = server.take_money(a);
            System.out.println("Новый баланс: " + _balance);
        } catch (InsufficientlyMoneyException e) {
            e.getMessage();
        }
    }
}