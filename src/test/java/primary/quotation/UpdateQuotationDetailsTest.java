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

public class UpdateQuotationDetailsTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateQuotationDetailsTest.class);
    public static final String SERVICE_NAME = "updateQuotationDetails";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description = "Update a quotation status")
    @Annotation.TestRun(serviceGroup = ServiceGroup.QUOTE,  serviceName = UpdateQuotationDetailsTest.SERVICE_NAME, testName="valid_quote_data_test", testGroup="p0")
    public void updateQuotationDetailsTest (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.put(ServiceGroup.QUOTE, UpdateQuotationDetailsTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Quotation updated");
        LOG.info(rest.getResponse().asString());
    }
}
