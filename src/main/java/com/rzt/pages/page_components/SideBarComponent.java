package com.rzt.pages.page_components;
import com.rzt.extent_reports.Logger;
import org.openqa.selenium.By;
import static com.rzt.utils.SeleniumUtil.clickOn;


public class SideBarComponent {
    public SideBarComponent clickSideBarMenu(String menuName) {
      By  menu = By.xpath("//p[contains(text(),'"+ menuName+"')]/parent::a[@class='nav-link']");
        clickOn(menu, menuName);
        return this;
     }

     public <T> T clickSubMenu(String subMenuName, Class<T> clazz){
         By  subMenu = By.xpath("//li[@class='nav-item has-treeview menu-is-opening menu-open']//ul[@class='nav nav-treeview']//li[@class='nav-item']//p[contains(text(),'"+subMenuName +"')]/parent::a");
        clickOn(subMenu,subMenuName);
         try {
             return clazz.newInstance();
         } catch (Exception e) {
             Logger.info("exception occured while selecting submenu, wrong menu name or wrong pageclass name");
         }
         return null;
     }

}
