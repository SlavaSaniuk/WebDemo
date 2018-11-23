package by.bsac.aaa.accounting;

import by.bsac.model.Account;

public interface AccountDAO {

    Account findByName();
    Account findByMail();
    void create();
    void delete();
    void update();
}
