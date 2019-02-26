package com.packt.webdriver.chapter1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import java.io.* ;

public class tkso {
    public static void main(String[] args) {
        // 0. Open a file to write a log
        try {
            FileWriter file = new FileWriter("log.txt");
            BufferedWriter buffer = new BufferedWriter(file);

            // 1.	Открыть главную страницу tkso.ru
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.tkso.ru");

            List<WebElement> Element = driver.findElements(By.className("entry-title"));
            int Fin = Element.size();
            buffer.write("Number of Elements " + Fin + " " + java.time.LocalDateTime.now());
            buffer.newLine();
            System.out.println("Number of Elements " + Fin + " " + java.time.LocalDateTime.now() + "\n");

            int j = 0;
            String Links;
            String[] Curhref = new String[Fin];
            for (WebElement e : Element) {
                String Curtxt = e.getText();

                WebElement TxtLink2 = driver.findElement(By.linkText(Curtxt));
                Curhref[j] = TxtLink2.getAttribute("href");
                System.out.println(" Curhref[" + j + "]: " + Curhref[j] + " " + java.time.LocalDateTime.now() + "\n");
                j++;
            }
            buffer.write("Start of a page content loop " + java.time.LocalDateTime.now());
            buffer.newLine();
            System.out.println(" начало цикла переходов-возратов " + " " + java.time.LocalDateTime.now() + "\n");
            for (int i = 0; i < Fin; i++) {
                buffer.write(" Call of page # " + i + ": " + Curhref[i] + " " + java.time.LocalDateTime.now());
                buffer.newLine();
                System.out.println(" переход к эл-ту " + i + ": " + Curhref[i] + " " + java.time.LocalDateTime.now() + "\n");
                driver.get(Curhref[i]);
                // TxtLink.click();
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().back();
            }
            // Second page
            WebElement Paginate = driver.findElement(By.linkText("Вперёд"));
            buffer.write(" Next page 2 ");
            buffer.newLine();
            System.out.println("Следующая страница (2) 'Вперёд' " + java.time.LocalDateTime.now());
            Paginate.click();

            List<WebElement> Element2 = driver.findElements(By.className("entry-title"));
            Fin = Element2.size();
            buffer.write("Number of Elements " + Fin + " " + java.time.LocalDateTime.now());
            buffer.newLine();
            System.out.println("Number of Elements " + Fin + " " + java.time.LocalDateTime.now() + "\n");
            j = 0;
            for (WebElement e : Element2) {
                String Curtxt = e.getText();

                WebElement TxtLink2 = driver.findElement(By.linkText(Curtxt));
                Curhref[j] = TxtLink2.getAttribute("href");
                System.out.println(" Curhref[" + j + "]: " + Curhref[j] + " " + java.time.LocalDateTime.now() + "\n");
                j++;
            }
            System.out.println(" начало цикла переходов-возратов " + " " + java.time.LocalDateTime.now() + "\n");
            for (int i = 0; i < Fin; i++) {
                buffer.write(" Call of page # " + i + " : " + Curhref[i] + " " + java.time.LocalDateTime.now());
                buffer.newLine();
                System.out.println(" переход к эл-ту " + i + ": " + Curhref[i] + " " + java.time.LocalDateTime.now() + "\n");
                driver.get(Curhref[i]);
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().back();
            }

            // Third page
            WebElement Paginate3 = driver.findElement(By.linkText("Вперёд"));
            buffer.write(" Next page 3 ");
            buffer.newLine();
            System.out.println("Следующая страница (3) 'Вперёд' " + " " + java.time.LocalDateTime.now());
            Paginate3.click();

            List<WebElement> Element3 = driver.findElements(By.className("entry-title"));
            Fin = Element3.size();
            buffer.write("Number of Elements " + Fin + " " + java.time.LocalDateTime.now());
            buffer.newLine();
            System.out.println("Number of Elements " + Fin + " " + java.time.LocalDateTime.now() + "\n");
            j = 0;
            for (WebElement e : Element3) {
                String Curtxt = e.getText();

                WebElement TxtLink2 = driver.findElement(By.linkText(Curtxt));
                Curhref[j] = TxtLink2.getAttribute("href");
                System.out.println(" Curhref[" + j + "]: " + Curhref[j] + " " + java.time.LocalDateTime.now() + "\n");
                j++;
            }
            System.out.println(" начало цикла переходов-возратов " + "\n");
            for (int i = 0; i < Fin; i++) {
                System.out.println(" переход к эл-ту" + i + ": " + Curhref[i] + " " + java.time.LocalDateTime.now() + "\n");
                buffer.write(" Call of page # " + i + " : " + Curhref[i] + " " + java.time.LocalDateTime.now());
                buffer.newLine();
                driver.get(Curhref[i]);
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().refresh();
                driver.navigate().back();
            }
            buffer.close();
        }
        catch (IOException e) {
            System.out.println("Error opening a log file");
        }
    }
}
