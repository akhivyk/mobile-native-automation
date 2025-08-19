package com.solvd.carina.demo.common.components;

import com.solvd.carina.demo.common.CartPageBase;
import com.solvd.carina.demo.common.SideBarMenuPageBase;

public interface TopMainMenuBase {

    SideBarMenuPageBase openSideBarMenu();

    CartPageBase clickCartButton();

    String getCountOfItemInCart();
}
