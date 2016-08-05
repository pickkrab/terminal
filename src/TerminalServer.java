/**
 * Created by alexander on 05.08.16.
 */
public class TerminalServer implements Terminal {
    int balance = 999999;

    @Override
    public int check_balance() throws BadConnectionException {
        if (Math.random() > 0.8) {
            throw new BadConnectionException("Не удаётся связаться с сервером, повторите операцию позднее");
        }
        else {
            return balance;
        }
    }

    @Override
    public int add_money(int a) throws ThisFunctionIsNotAvailableException {
        if (Math.random() > 0.8) {
            throw new ThisFunctionIsNotAvailableException("К сожалению, на данный момент прием средств недоступен. Попробуйте повторить данную операцию в другом банкомате");
        }
        else {
            return balance = balance + a;
        }
    }

    @Override
    public int take_money(int a) throws InsufficientlyMoneyException {
        if (balance < a) {
            throw new InsufficientlyMoneyException("Не достаточно средств на балансе вашего счета. Введите сумму исходя из баланса вашего лицевого счета");
        }
        else {
            return balance = balance - a;
        }
    }
}

