package com.rzt.pages.pageComponents;
import org.openqa.selenium.By;
import static com.rzt.utils.SeleniumUtil.clickOn;


public class SideBarComponent {
    /**
     * home page Sidebar components
     */
    public void clickSideBarMenu(String menuName) {
      By  menu = By.xpath("//div[@class='oxd-sidepanel-body']//span[text()='"+menuName+"']/parent::a");
        clickOn(menu,menuName);
        //  String sideBarMenuName = "//div[@class='oxd-sidepanel-body']//span[text()='%s']/parent::a";
        // String menu= String.format(sideBarMenuName, menuName);

     }

}
