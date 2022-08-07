package primary.inquiry;

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

public class GetInquiryDetailsNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetInquiryDetailsNegative.class);
    public static final String SERVICE_NAME = "getInquiry";

    //Errors must be 400

    @Annotation.TestData(attributeName = "inquiryId", value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "To check get inquiry by passing random number")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetInquiryDetailsNegative.SERVICE_NAME,dataType = DataType.NUMERIC,dataConstraint = DataConstraint.FOR_SPECIFIED,attributeName = "inquiryId")
    public void getInquiryPassNumber (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.GROUP1, GetInquiryDetailsNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "inquiry details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "inquiryId", value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "To check get inquiry by passing random alpha numeric")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetInquiryDetailsNegative.SERVICE_NAME,dataType = DataType.NUMERIC,dataConstraint = DataConstraint.FOR_SPECIFIED,attributeName = "inquiryId")
    public void getInquiryPassAlphanumeric (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.GROUP1, GetInquiryDetailsNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "inquiry details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "inquiryId", value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "To check get inquiry by passing null value")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetInquiryDetailsNegative.SERVICE_NAME,dataType = DataType.NUMERIC,dataConstraint = DataConstraint.FOR_SPECIFIED,attributeName = "inquiryId")
    public void getInquiryPassNull (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.GROUP1, GetInquiryDetailsNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "inquiry details fetched");
        LOG.info(rest.getResponse().asString());
    }

    @Annotation.TestData(attributeName = "inquiryId", value = "")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "To check get inquiry by passing unassigned values")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetInquiryDetailsNegative.SERVICE_NAME,dataType = DataType.NUMERIC,dataConstraint = DataConstraint.FOR_SPECIFIED,attributeName = "inquiryId")
    public void getInquiryUnassigned (HashMap<String, String> data) throws Exception {

        WebService rest = Ws.get(ServiceGroup.GROUP1, GetInquiryDetailsNegative.SERVICE_NAME, TestBase.ENV , data);
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
        //Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "inquiry details fetched");
        LOG.info(rest.getResponse().asString());
    }

}
