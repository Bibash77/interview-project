import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.MemberImporter;
import bqtest.service.impl.MemberFileProcessorImpl;
import bqtest.web.FileController;
import org.apache.catalina.mapper.Mapper;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
public class MemberImporterTests {


    private FileController fileController;
/*
    private final MemberFileProcessor memberFileProcessor = new MemberFileProcessorImpl();

    @Value("${config.file-to-load}")
    private String filepath;*/

    /*@Test
    public void getNonDuplicateMembers() throws Exception {
        File uploadedFile = new File(filepath);
        Object data = memberFileProcessor.processFile(new File(filepath));
        Member member = new Member();
        member.setId("101396885");
        member.setFirstName("ALVA");
        member.setLastName("CAROLA");
        member.setAddress("4829 JAUREGUI BLVD");
        member.setCity("CORCORAN");
        member.setState("IL");
        member.setZip("55357");
        List<Member> testData = new ArrayList<>();
        testData.add(member);
        assertEquals(testData , data);
    }*/

    @Test
    public void loadDataTest() {
        assertNotEquals(fileController , null);
    }

}
