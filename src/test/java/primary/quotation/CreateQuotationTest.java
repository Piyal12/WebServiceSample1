package primary.quotation;

import com.im.service.common.Annotation;
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

public class CreateQuotationTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateQuotationTest.class);
    public static final String SERVICE_NAME = "createQuotation";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description = "Create Quotation for a customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = CreateQuotationTest.SERVICE_NAME, testName="valid_quote_data", testGroup="p0")
    public void createQuotationTest (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.QUOTE, CreateQuotationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation created");
        LOG.info(rest.getResponse().asString());
    }
}
