package primary.supplier;

import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CreateSupplierPickupLocationTest extends TestBase {
        private static final Logger LOG = LoggerFactory.getLogger(CreateSupplierPickupLocationTest.class);
        public static final String SERVICE_NAME = "createPickupLocation";
//        public static final String SERVICE_NAME1 = "createKYCs";
//        String kycID;

//        @Test(dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
//        @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME1, testName = "aut_login", testGroup = "p0")
//        public void createKYCAPI_test(HashMap<String, String> data) throws IOException {
//            WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME1, TestBase.ENV, data);
//            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
//            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
//            Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
//            Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Pickup Location test failed");
//            LOG.info("\n" + rest.getResponse().prettyPeek());
//            kycID = rest.getResponse().body().jsonPath().getString("data[0].kyc_id");
//            updateExcelCell(kycID);
//        }

        @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"regression","sanity","positive"},description = "CreateSupplierPickupLocationTest with all valid params")
        @Annotation.TestRun(serviceGroup = ServiceGroup.SUPPLIER, serviceName = CreateSupplierPickupLocationTest.SERVICE_NAME, testName = "aut_login", testGroup = "p0")
        public void createPickUpLocation_test(HashMap<String, String> data) throws Exception {
            WebService rest = Ws.post(ServiceGroup.SUPPLIER, CreateSupplierPickupLocationTest.SERVICE_NAME, TestBase.ENV, data);
//            MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
            LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
            LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
            Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
            Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Pickup Location test failed");
            LOG.info("\n" + rest.getResponse().prettyPeek());

        }

//        public void updateExcelCell(String val) throws IOException {
//            String createPickupLocation = "./src/test/resources/testdata/supplier/createPickupLocation.xlsx";
//            XSSFWorkbook workbook = new XSSFWorkbook(createPickupLocation);
//            XSSFSheet sheet = workbook.getSheetAt(0);
//            Cell cell = null;
//            XSSFRow sheetrow = sheet.getRow(1);
//            if (sheetrow == null) {
//                sheetrow = sheet.createRow(1);
//            }
//            cell = sheetrow.getCell(6);
//            if (cell == null) {
//                cell = sheetrow.createCell(6);
//            }
//            cell.setCellValue(val);
//            try (FileOutputStream outputStream = new FileOutputStream(createPickupLocation + ".new")) {
//                workbook.write(outputStream);
//            }
//            Files.delete(Paths.get(createPickupLocation));
//            Files.move(Paths.get(createPickupLocation + ".new"), Paths.get(createPickupLocation));
//            System.out.println("done");
//        }
}
