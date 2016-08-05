/**
 * Created by alexander on 05.08.16.
 */
public interface Terminal {
    int check_balance() throws BadConnectionException;
    int add_money(int a) throws ThisFunctionIsNotAvailableException;
    int take_money(int a) throws InsufficientlyMoneyException;
}
