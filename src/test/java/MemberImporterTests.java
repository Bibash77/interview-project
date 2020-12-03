import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.MemberImporter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MemberImporterTests {

    @Autowired
    MemberImporter memberImporter;

    @Autowired
    MemberFileProcessor memberFileProcessor;

    @Value("${config.file-to-load-test}")
    private String filepath;

    @Test
    public void getNonDuplicateMembers() throws Exception {
        List<Member> data = memberImporter.importMembers(new File(filepath));
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
    }

}
