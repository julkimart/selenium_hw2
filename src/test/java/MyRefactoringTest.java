import org.junit.Test;

import pages.InsurancePage;
//import pages.MainPage;
import pages.SendAppPage;
import pages.SendAppPage2;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class MyRefactoringTest extends BaseTest{

    @Test
    public void testInsurance() {
        driver.get(baseUrl);










/*        // cтрахование -> путешествия и покупки (mainPage)
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия и покупки");
        */












        // проверка наличия заголовка Страхование путешественников (insurancePage)
        InsurancePage insurancePage = new InsurancePage(driver);
        assertEquals("Страхование путешественников", insurancePage.title.getText());
        //нажать на оформить-онлайн (insurancePage)
        new InsurancePage(driver).sendAppBtn.click();

        //переход на другое окно
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));



        // (SendAppPage)
        SendAppPage sendAppPage = new SendAppPage(driver);
        //выбрать минимальная
        sendAppPage.minSumma.click();
        //нажать оформить
        sendAppPage.oformitButton.click();





        // заполняем поля (SendAppPage2)
        SendAppPage2 sendAppPage2 = new SendAppPage2(driver);
        //заполняем фамилию и имя и дату рождения
        sendAppPage2.fillField("Фамилия на англ", "Ivanov");
        sendAppPage2.fillField("Имя на англ", "Ivan");
        sendAppPage2.fillField("Дата рождения1", "05.06.1990");
        //заполняем фамилию и имя и отчество и дату рождения
        sendAppPage2.fillField("Фамилия", "Иванов");
        sendAppPage2.fillField("Имя", "Иван");
        sendAppPage2.fillField("Отчество", "Иванович");
        sendAppPage2.fillField("Дата рождения", "05.06.1990");
        //паспорт
        sendAppPage2.fillField("Серия паспорта", "4215");
        sendAppPage2.fillField("Номер паспорта", "569865");
        sendAppPage2.fillField("Дата выдачи", "20.06.2013");
        sendAppPage2.fillField("Место выдачи", "уфмс рф города Казани");
        //проверки
        sendAppPage2.checkField("Фамилия на англ", "Ivanov");
        sendAppPage2.checkField("Имя на англ", "Ivan");
        sendAppPage2.checkField("Дата рождения1", "05.06.1990");
        sendAppPage2.checkField("Фамилия", "Иванов");
        sendAppPage2.checkField("Имя", "Иван");
        sendAppPage2.checkField("Отчество", "Иванович");
        sendAppPage2.checkField("Дата рождения", "05.06.1990");
        sendAppPage2.checkField("Серия паспорта", "4215");
        sendAppPage2.checkField("Номер паспорта", "569865");
        sendAppPage2.checkField("Дата выдачи", "20.06.2013");
        sendAppPage2.checkField("Место выдачи", "уфмс рф города Казани");

        //нажать Продолжить
        sendAppPage2.prodolzhitButton.click();

        //проверка что контактные данные не заполнены
        assertEquals("Номер телефона вводится в 10-ти значном формате", sendAppPage2.phone.getText());
    }
}