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


public class GetQuotationTestNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetQuotationTestNegative.class);
    public static final String SERVICE_NAME = "getQuotation";


    @Annotation.TestData(attributeName = "quoteAliasId", value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass random number as quote ID to get quote details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetQuotationTestNegative.SERVICE_NAME, dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "quoteAliasId")
    public void passAlphaNumeric(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.QUOTE, GetQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+404+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body()("404 page not found"), "Downloaded quotation");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "quoteAliasId", value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass null values to get quote details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetQuotationTestNegative.SERVICE_NAME, dataType = DataType.NULL, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "quoteAliasId")
    public void passNullValue(HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.QUOTE, GetQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);

        LOG.info("Status:" + rest.getStatus());

        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");

        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Failed");


        LOG.info(rest.getResponse().asString());
    }
    @Annotation.TestData(attributeName = "quoteAliasId", value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass blank values to get quote details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetQuotationTestNegative.SERVICE_NAME, dataType = DataType.BLANK, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "quoteAliasId")
    public void passBlankValue(HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.QUOTE, GetQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Failed");
        LOG.info(rest.getResponse().asString());
    }
    @Annotation.TestData(attributeName = "quoteAliasId", value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"negative","regression"},description = "Pass random numeric value to get quote details")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetQuotationTestNegative.SERVICE_NAME, dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "quoteAliasId")
    public void passAlphaNumericValue(HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.QUOTE, GetQuotationTestNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Failed");
        LOG.info(rest.getResponse().asString());
    }
}
