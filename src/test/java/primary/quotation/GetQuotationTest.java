package primary.quotation;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


public class GetQuotationTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetQuotationTest.class);


    public static final String SERVICE_NAME = "getQuotation";

    @Annotation.TestData(attributeName = "quoteAliasId", value = "QUOT25")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description = "Get quotation details for a quote ID")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = GetQuotationTest.SERVICE_NAME)
    public void getQuotationTest(HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.QUOTE, GetQuotationTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Downloaded quotation");
        LOG.info(rest.getResponse().asString());
    }
}
