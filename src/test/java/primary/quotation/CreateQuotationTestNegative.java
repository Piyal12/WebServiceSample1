package primary.quotation;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateQuotationTestNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateQuotationTestNegative.class);
    public static final String SERVICE_NAME = "createQuotation";

   @Annotation.TestData(attributeName = "dealAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Numeric deal ID to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "dealAliasId")
    public void passNumericDealId (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "dealAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass AlphaNumeric deal ID to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "dealAliasId")

    public void passAlphaNumericDealId (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Numeric cust ID to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "dealAliasId")

    public void passNumericCustId (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "customerAliasId",value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass AlphaNumeric cust ID to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "dealAliasId")

    public void passAlphaNumericCustId (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass Null value to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.NULL, dataConstraint = DataConstraint.ONE_BY_ONE)

    public void passNullValues (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "Pass unassgined to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.ONE_BY_ONE)

    public void passUnassignedValues (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = " Pass no attribute to check if quote is created")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTestNegative.SERVICE_NAME, testName="valid_quote_data", testGroup="p0",dataType = DataType.BLANK, dataConstraint = DataConstraint.ONE_BY_ONE)

    public void withoutAttributes (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }

}
