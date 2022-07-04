package org.example.controller;

import org.example.controller.command.*;

public enum CommandType {
    LOGIN_COMMAND(new LoginCommand()),
    REGISTRATION_COMMAND(new RegistrationCommand()),
    REGISTRATION_USER_COMMAND(new RegistrationUserCommand()),
    VIEW_PRODUCTS_COMMAND(new ViewProductsCommand()),
    VIEW_PAGE_BEER(new ViewPageBeer()),
    INSERT_BEER_IN_DB(new InsertBeerInDB()),
    INSERT_PAGE_BEER(new InsertPageBeer()),
    EDIT_BEER(new EditBeer()),
    USER_CATALOG_BEER(new UserCatalogBeer()),
    EDIT_PAGE_BEER(new EditPageBeer()),
    ADD_BEER_TO_BUY_PAGE(new AddBeerToBuyPage()),
    ADD_BEER_TO_BUY(new AddBeerToBuy()),
    BUY_PRODUCT(new BuyProduct()),
    BUY_PRODUCT_CART(new BuyProductCart()),
    USER_MENU_PAGE(new UserMenuPage()),
    CLEAR_CART(new ClearCart()),
    SHOP_HISTORY(new ShopHistory()),
    SHOP_HISTORY_ALL(new ShopHistoryAll()),
    ADMIN_MENU_PAGE(new AdminMenuPage()),
    LOGOUT(new LogoutCommand());

    private final CustomCommand command;

    CommandType(CustomCommand command) {
        this.command = command;
    }

    public CustomCommand getCommand() {
        return command;
    }
}
