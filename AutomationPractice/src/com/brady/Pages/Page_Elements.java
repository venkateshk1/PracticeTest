package com.brady.Pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

	public class Page_Elements {
		
		@FindBy (how=How.XPATH,using="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
		WebElement Signin;
		@FindBy(how=How.XPATH,using="//*[@id='email']")
		WebElement email;
		@FindBy(how=How.XPATH,using="//*[@id='passwd']")
		WebElement password;
		@FindBy(how=How.XPATH,using="//*[@id='SubmitLogin']")
		WebElement submitbutton;
		@FindBy (how=How.XPATH,using="//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")
		WebElement personalinfo;
		@FindBy (how=How.XPATH,using="//*[@id='firstname']")
		WebElement firstname;
		@FindBy (how=How.XPATH,using="//*[@id='lastname']")
		WebElement surname;
		@FindBy(how=How.XPATH,using="//*[@id='header']/div[3]/div/div/div[3]/div/a")
		WebElement cart;
		@FindBy(how=How.XPATH,using="//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]")
		WebElement carttext;
		@FindBy(how=How.XPATH,using="//*[@id='block_top_menu']/ul/li[1]/a")
		WebElement wmtab;
		@FindBy (how=How.XPATH,using="//*[@id='layered_id_attribute_group_24']")
		WebElement pinkcolour;
		@FindBy(how=How.XPATH,using="//*[@id='center_column']/ul/li/div/div[2]/h5/a")
		WebElement pinkdress;
		@FindBy(how=How.XPATH,using="//*[@id='add_to_cart']/button")
		WebElement addtocartbutton;
		@FindBy(tagName="h2")
		WebElement successtext;
		@FindBy(how=How.XPATH,using=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
		WebElement proceedtocart;
		@FindBy(how=How.XPATH,using=".//*[@id='product_4_16_0_78699']/td[5]/input[2]")
		WebElement pinkdressquantity;
		@FindBy(how=How.XPATH,using="//*[@id='special_block_right']/div/div/a/span")
		WebElement allspecials;
		@FindBy (className="product-count")
		WebElement allspecialscount;
		@FindBy (linkText="Printed Chiffon Dress")
		WebElement allspecials1;
		@FindBy (how=How.XPATH,using="//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
		WebElement continueshopping;
		@FindBy (linkText="Printed Summer Dress")
		WebElement allspecials2;
		@FindBy (how=How.XPATH,using="//*[@id='product_price_7_34_78699']/span[1]")
		WebElement pcddiscprice;
		@FindBy (how=How.XPATH,using="//*[@id='product_price_5_19_78699']/span[1]")
		WebElement psddiscprice;
		@FindBy (linkText="DRESSES")
		WebElement dress;
		@FindBy (how=How.XPATH,using="//*[@id='selectProductSort']")
		WebElement dropdownmenu;
		
		@FindAll(@FindBy(xpath="//span[@class='price product-price']"))
		List <WebElement> price;
		

		  
		 public void login_brady(String uname,String pwd)
		{
		Signin.click();
		email.sendKeys(uname);
		password.sendKeys(pwd);
		submitbutton.click();
		}
		
		public void verifyinfo(String fname,String lname)
		{
			personalinfo.click();
			String f1name=firstname.getAttribute("value");
			String lastname=surname.getAttribute("value");
			Assert.assertEquals(f1name, fname);
			Assert.assertEquals(lastname, lname);
		}
		
		public void verifyCart()
		{
			String txt=carttext.getText();
			Assert.assertEquals(txt, "(empty)");
			
		}
		public void navigatetoWomen_AddPinkdresstoCart()
		
		{
			wmtab.click();
			pinkcolour.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pinkdress.click();
			addtocartbutton.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String text=successtext.getText();
			Assert.assertEquals(text, "Product successfully added to your shopping cart");
			proceedtocart.click();
			Assert.assertEquals(pinkdressquantity.getAttribute("value"),"1");
			
		}
		
		public void navigateToAllspecial()
		{
			wmtab.click();
			allspecials.click();
			String count=allspecialscount.getText();
			System.out.println("All Specials Count"+" "+count);
		}
		
		public void addAllspecials1ToCart()
		{
			allspecials1.click();
			addtocartbutton.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueshopping.click();
					
		}
		
		public void addAllspecials2ToCart()
		{
			allspecials2.click();
			addtocartbutton.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			proceedtocart.click();
		}
		
		public double calculateDiscountPrice(double markedprice,double discount)
		
		{
			double s,afterdiscount,val;
			s=100-discount;
			afterdiscount=(s*markedprice)/100;
		    return afterdiscount;
			
		}
		public void checkdiscountpcd(){
			String d1=pcddiscprice.getText();
			//String d1=Double.parseDouble(text);
			String pricetocomparepcd="$"+String.format("%.2f",calculateDiscountPrice(20.50, 20.00));
			if(pricetocomparepcd.equals(d1))
			{
				System.out.println("Discount applied successfully on pcd");
			}else{
				System.out.println("Discount not applied");
			}
		}
		public void checkdiscountpsd()
		{
			String d2=psddiscprice.getText();
			String pricetocomparepsd="$"+String.format("%.2f",calculateDiscountPrice(30.51, 5.00));
			if(pricetocomparepsd.equals(d2))
			{
				System.out.println("Discount applied successfully on psd");
			}else
			{
				System.out.println("Discount not applied");
			}
			
		}
		public void navigatetoDresses()
		{
			dress.click();
		}
		
			
		public void selectlowsetfirst()
		
		{
			Select menul =new Select(dropdownmenu);
			menul.selectByVisibleText("Price: Lowest first");
			
			
		}
	    public void selecthighestfirst()
		
		{
			Select menuh =new Select(dropdownmenu);
			menuh.selectByVisibleText("Price: Highest first");
			
			
		}
	 
	   
}



