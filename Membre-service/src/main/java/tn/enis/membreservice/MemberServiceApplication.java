package tn.enis.membreservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tn.enis.membreservice.beans.PublicationBean;
import tn.enis.membreservice.dao.MemberRepository;
import tn.enis.membreservice.proxies.PublicationProxyService;
import tn.enis.membreservice.services.IMemberService;


@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class MemberServiceApplication implements CommandLineRunner
{
	PublicationProxyService publicationProxyService;
	IMemberService memberService;
	public static void main(String[] args)  {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PublicationBean pub=publicationProxyService.findPublicationById(2L);
		System.out.println(pub.getTitre()+" "+pub.getLien());
		memberService.affecterauteurTopublication(1L, 1L);
		memberService.affecterauteurTopublication(1L, 2L);
	}
}
