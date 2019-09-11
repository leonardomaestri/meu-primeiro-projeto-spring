package com.unifacef.my_first_project_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.unifacef.entities.Empresa;
import com.unifacef.utils.SenhaUtils;

import com.unifacef.my_first_project_spring.EmpresaRepository;

//
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Kazale IT");
			empresa.setCnpj("74645215000104");
			this.empresaRepository.save(empresa);
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			Empresa empresaDb = empresaRepository.findById(1L).orElse(null);
			System.out.println("Empresa por ID: " + empresaDb);
			empresaDb.setRazaoSocial("Kazale IT Web");
			this.empresaRepository.save(empresaDb);
			Empresa empresaCnpj = empresaRepository.findByCnpj("74645215000104");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			this.empresaRepository.delete(empresaCnpj);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
		};
	}
}

//@SpringBootApplication
//public class DemoApplication {
//	
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded: " + senhaEncoded);
//			senhaEncoded = SenhaUtils.gerarBCrypt("123456");
//			System.out.println("Senha encoded novamente:" + senhaEncoded);
//			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
//		};
//	}
//}
