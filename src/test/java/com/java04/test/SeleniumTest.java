package com.java04.test;

import com.java04.entity.Users;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.mockito.ArgumentMatchers.*;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownClass() {
        if (driver != null) driver.quit();
    }

    @BeforeMethod
    public void resetBeforeEach() {
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void testRegister_Success() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");

        driver.findElement(By.name("username")).sendKeys("th997");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Test");
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test(priority = 2)
    public void testRegisterEmptyUsername() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Khang");
        driver.findElement(By.name("email")).sendKeys("khang@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập username");
    }

    @Test(priority = 3)
    public void testRegisterEmptyPassword() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("username")).sendKeys("th997");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Khang");
        driver.findElement(By.name("email")).sendKeys("khang@gmail.com");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập password");
    }

    @Test(priority = 4)
    public void testRegisterEmptyFullname() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("username")).sendKeys("th997");
        driver.findElement(By.name("email")).sendKeys("khang@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập fullname");
    }

    @Test(priority = 5)
    public void testRegisterEmptyEmail() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("username")).sendKeys("th997");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Khang");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập email");
    }

    @Test(priority = 6)
    public void testRegisterInvalidEmailFormat() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("username")).sendKeys("th997");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Khang");
        driver.findElement(By.name("email")).sendKeys("khang");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Email sai định dạng");
    }

    @Test(priority = 7)
    public void testRegisterUsernameAlreadyExists() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/register");
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.name("fullname")).sendKeys("Nguyen Khang");
        driver.findElement(By.name("email")).sendKeys("khang@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Username đã tồn tại");
    }

    @Test(priority = 8)
    void testLoginInvalidPassword(){
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.name("password")).sendKeys("11");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Invalid password");
    }

    @Test(priority = 9)
    void testLoginInvalidUsername(){
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("username")).sendKeys("239");
        driver.findElement(By.name("password")).sendKeys("222");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Invalid username");
    }

    @Test(priority = 10)
    void testEmptyPassword(){
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập password");
    }

    @Test(priority = 11)
    void testEmptyUsername(){
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("password")).sendKeys("222");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Vui lòng nhập username");
    }

    // --- Test ĐĂNG NHẬP THÀNH CÔNG ---
    @Test(priority = 12)
    void testLoginSuccess(){
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.name("password")).sendKeys("222");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("/home/admin")
                || webDriver.getCurrentUrl().contains("/home/user"));

        // Assert final URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/home/admin") || currentUrl.contains("/home/user"));
    }

    private void loginAsAdmin() {
        driver.get("http://localhost:8080/08_TC00224_LeKhangThinh_ASM_war/login");
        driver.findElement(By.name("username")).sendKeys("2");
        driver.findElement(By.name("password")).sendKeys("222");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> webDriver.getCurrentUrl().contains("/home/admin"));
    }

    @Test(priority = 13)
    public void testCreateVideo_EmptyId() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("", "Title", "https://youtu.be/abc", "Mô tả", true);
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "ID cannot be empty when creating a new video.");
    }

    @Test(priority = 14)
    public void testCreateVideo_DuplicateId() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("1", "Title", "https://youtu.be/abc", "Mô tả", true);
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "ID already exists.");
    }
//
    @Test(priority = 15)
    public void testCreateVideo_EmptyTitle() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("1", "", "https://youtu.be/abc", "Mô tả", true);
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Title cannot be empty.");
    }
//
    @Test(priority = 16)
    public void testCreateVideo_EmptyLink() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("1", "a", "", "Mô tả", true);
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Link cannot be empty.");
    }
//
    @Test(priority = 17)
    public void testCreateVideo_DuplicateLink() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("vid004", "Video Test", "https://www.youtube.com/embed/F64yFFnZfkI", "Mô tả", true);
        js.executeScript("document.getElementById('posterPreview').style.display='none';");
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        js.executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText().trim(), "Link already exists.");
    }

//
    @Test(priority = 18)
    public void testCreateVideo_IdLength1() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("v", "Café Video", "https://www.youtube.com/embed/KTZ-y85Erus", "Mô tả", true);
        js.executeScript("document.getElementById('posterPreview').style.display='none';");
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        js.executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video created successfully!");
    }
//
    @Test(priority = 19)
    public void testCreateVideo_IdLength10() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();
        fillVideoForm("vvvvvvvvvv", "Café Video", "https://www.youtube.com/embed/t7MBzMP4OzY", "Mô tả", true);
        js.executeScript("document.getElementById('posterPreview').style.display='none';");
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        js.executeScript("arguments[0].click();", createBtn);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video created successfully!");
    }
//
    @Test(priority = 20)
    public void testCreateVideo_IdLength11() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Đi đến trang video management
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();

        // Điền form video
        fillVideoForm("vvvvvvvvvvv", "Café Video", "https://www.youtube.com/embed/KTZ-y85Erus", "Mô tả", true);

        // Ẩn ảnh để không che nút
        js.executeScript("document.getElementById('posterPreview').style.display='none';");

        // Click Create bằng JS
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        js.executeScript("arguments[0].click();", createBtn);

        // Kiểm tra thông báo lỗi
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video created failed!");
    }
//
    @Test(priority = 21)
    public void testCreateVideo_ValidFields() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Đi đến trang video management
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();

        // Điền form video
        fillVideoForm("vid005", "Café Video", "https://www.youtube.com/embed/9lVPAWLWtWc", "Mô tả", true);

        // Ẩn ảnh để không che nút
        js.executeScript("document.getElementById('posterPreview').style.display='none';");

        // Click Create bằng JS
        WebElement createBtn = driver.findElement(By.cssSelector("button[name='action'][value='create']"));
        js.executeScript("arguments[0].scrollIntoView(true);", createBtn);
        js.executeScript("arguments[0].click();", createBtn);

        // Kiểm tra thông báo lỗi
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video created successfully!");
    }

    // ============================
    // Helper method để fill form
    // ============================
    private void fillVideoForm(String id, String title, String link, String description, boolean active) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // ID
        WebElement idInput = driver.findElement(By.name("id"));
        idInput.clear();
        idInput.sendKeys(id);

        // Title
        WebElement titleInput = driver.findElement(By.name("title"));
        titleInput.clear();
        titleInput.sendKeys(title);

        // Link (input videoLink sẽ trigger JS update embedLink & poster)
        WebElement linkInput = driver.findElement(By.id("videoLink"));
        linkInput.clear();
        linkInput.sendKeys(link);

        // Description
        WebElement descInput = driver.findElement(By.name("description"));
        descInput.clear();
        descInput.sendKeys(description);

        // Active/Inactive
        js.executeScript("document.getElementById('posterPreview').style.display='none';");

        // Chọn radio Active/Inactive bằng JS click an toàn
        String radioId = active ? "activeCheck" : "inactiveCheck";
        WebElement activeInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(radioId)));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", activeInput);
        js.executeScript("arguments[0].click();", activeInput);
    }

    @Test(priority = 22)
    public void testUpdateVideo_Success_Full() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Điều hướng đến trang quản lý video
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();

        // Chuyển sang tab "VIDEO LIST"
        WebElement listTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("list-tab")));
        listTab.click();

        // Chờ bảng video hiển thị và nhấn "Edit" cho video cụ thể
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tr[td[text()='98']]//a[contains(@class,'btn-primary')]")
        ));
        js.executeScript("arguments[0].click();", editBtn);

        // Chờ form hiện ra
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='id']")));

        // Cập nhật thông tin video
        WebElement titleInput = driver.findElement(By.cssSelector("input[name='title']"));
        titleInput.clear();
        titleInput.sendKeys("Mộng Hóa");

        WebElement descInput = driver.findElement(By.cssSelector("textarea[name='description']"));
        descInput.clear();
        descInput.sendKeys("Đây là mô tả mới sau khi cập nhật.");

        WebElement linkInput = driver.findElement(By.id("videoLink"));
        linkInput.clear();
        linkInput.sendKeys("https://www.youtube.com/embed/ZIRife55zZA");

        // Chuyển trạng thái
        WebElement inactiveRadio = driver.findElement(By.id("inactiveCheck"));
        if (!inactiveRadio.isSelected()) {
            js.executeScript("arguments[0].click();", inactiveRadio);
        }

        // Ẩn hình poster (tránh che nút Update)
        js.executeScript("document.getElementById('posterPreview').style.display='none';");

        // Bấm nút Update
        WebElement updateBtn = driver.findElement(By.cssSelector("button[name='action'][value='update']"));
        js.executeScript("arguments[0].scrollIntoView(true);", updateBtn);
        js.executeScript("arguments[0].click();", updateBtn);

        // Kiểm tra thông báo kết quả
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video updated successfully!");
    }
    @Test(priority = 23)
    public void testDeleteVideo_Success() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Mở trang quản lý video
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();

        // Mở tab danh sách
        WebElement listTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("list-tab")));
        listTab.click();

        // Tìm nút Edit của video cần xóa (ví dụ: vid004)
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tr[td[text()='xx']]//a[contains(@class,'btn-primary')]")
        ));
        js.executeScript("arguments[0].click();", editBtn);

        // Chờ form hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));

        // Ẩn ảnh poster để không che nút Delete
        js.executeScript("document.getElementById('posterPreview').style.display='none';");

        // Click nút Delete
        WebElement deleteBtn = driver.findElement(By.cssSelector("button[name='action'][value='delete']"));
        js.executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
        js.executeScript("arguments[0].click();", deleteBtn);

        // Kiểm tra thông báo hiển thị
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
        Assert.assertEquals(message.getText(), "Video deleted successfully!");

        // Quay lại tab danh sách và kiểm tra video không còn
        WebElement listTabAgain = wait.until(ExpectedConditions.elementToBeClickable(By.id("list-tab")));
        listTabAgain.click();

        // Đợi bảng load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));
    }

    @Test(priority = 24)
    public void testEditVideo_FormHasData() {
        loginAsAdmin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Đi đến trang quản lý video
        WebElement videoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/admin/videoManagement')]")
        ));
        videoLink.click();

        // Chuyển sang tab danh sách
        WebElement listTab = wait.until(ExpectedConditions.elementToBeClickable(By.id("list-tab")));
        listTab.click();

        // Đợi bảng hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));

        // Nhấn nút Edit của video đầu tiên trong danh sách
        WebElement firstEditBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("table tbody tr:first-child a.btn-primary")
        ));
        js.executeScript("arguments[0].click();", firstEditBtn);

        // Đợi form Edition hiện ra
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));

        // Kiểm tra các input có dữ liệu
        WebElement idInput = driver.findElement(By.cssSelector("input[name='id']"));
        WebElement titleInput = driver.findElement(By.cssSelector("input[name='title']"));
        WebElement linkInput = driver.findElement(By.id("videoLink"));

        // Lấy giá trị từ các field
        String idValue = idInput.getAttribute("value");
        String titleValue = titleInput.getAttribute("value");
        String linkValue = linkInput.getAttribute("value");

        // Xác nhận form có dữ liệu
        Assert.assertTrue(!idValue.isEmpty());
        Assert.assertTrue(!titleValue.isEmpty());
        Assert.assertTrue(!linkValue.isEmpty());
    }

}