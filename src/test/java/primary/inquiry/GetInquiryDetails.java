package primary.inquiry;

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

public class GetInquiryDetails extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetInquiryDetails.class);
    public static final String SERVICE_NAME = "getInquiry";

    @Annotation.TestData(attributeName = "inquiryId",value = "INQR2317")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"positive","sanity","regression"},description = "Get Inquiry details for a customer")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetInquiryDetails.SERVICE_NAME)
    public void getInquiryDetails (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.GROUP1, GetInquiryDetails.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "inquiry details fetched");
        LOG.info(rest.getResponse().asString());
    }
}
