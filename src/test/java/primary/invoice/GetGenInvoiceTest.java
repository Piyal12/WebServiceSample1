package primary.invoice;

import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import primary.dashboard.GetCusDashboardTest;


public class GetGenInvoiceTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetGenInvoiceTest.class);


    public static final String SERVICE_NAME = "getGenInvoice";




    //@Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")

    // @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetGenInvoiceTest.SERVICE_NAME, testName="retailer_valid_data_test", testGroup="p0"
    @Test
    public void getGenInvoiceTest () throws Exception {



    //    Session session = new Session(SessionProperties.newProperties(ServiceGroup.INVOICE).environment(TestBase.ENV).serviceName(GetGenInvoiceTest.SERVICE_NAME).build());

      //  WebService rest = new WebService(session);

        // rest.setTestData();



      //  LOG.info("API Before Parameterize:" + rest.getSession().getAPI());

      //  LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(),rest.getTestData()));



       // rest.get();


        WebService rest = Ws.get(ServiceGroup.INVOICE, GetGenInvoiceTest.SERVICE_NAME, TestBase.ENV);
        LOG.info("Status:" + rest.getStatus());




        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");

        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Invoice Generated");




        LOG.info(rest.getResponse().asString());

    }
}
