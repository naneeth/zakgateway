package com.stackroute;

import com.stackroute.service.NlpServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NlpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NlpServiceApplication.class, args);
		NlpServiceImpl nlpService = new NlpServiceImpl();
		nlpService.setParagraph("We are creating KnowledgeHub Application that makes sense of unstructured data which"+
				" remain scattered in an organisation. Making sense of such scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face.");
		nlpService.showAllResults();
	}
}
///home/user/Pictures/boeing-wave4-knowledgehub-V.1.0.0/nlp-service/src/main/java/com/stackroute/NlpServiceApplication.java