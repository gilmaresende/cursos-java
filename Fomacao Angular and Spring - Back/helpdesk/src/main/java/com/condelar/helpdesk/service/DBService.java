package com.condelar.helpdesk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.condelar.helpdesk.domain.Chamado;
import com.condelar.helpdesk.domain.Cliente;
import com.condelar.helpdesk.domain.Tecnico;
import com.condelar.helpdesk.domain.enuns.Perfil;
import com.condelar.helpdesk.domain.enuns.Prioridade;
import com.condelar.helpdesk.domain.enuns.Status;
import com.condelar.helpdesk.repositorys.ChamadoRepository;
import com.condelar.helpdesk.repositorys.ClienteRepository;
import com.condelar.helpdesk.repositorys.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Gilmar Fabiano", "61324755164", "gfresende@mail.com",
				encoder.encode("1234"));
		t1.addPerfis(Perfil.ADMIN);
		Tecnico t2 = new Tecnico(null, "Geraldo Henrique", "54755733529", "ghmorais@mail.com",
				encoder.encode("df7591"));
		t2.addPerfis(Perfil.ADMIN);
		Tecnico t3 = new Tecnico(null, "Italo Medice", "52189636310", "itmedice.com", encoder.encode("gdfuh47"));
		t3.addPerfis(Perfil.ADMIN);
		Tecnico t4 = new Tecnico(null, "Jadson Moura", "44426880602", "jamoura.com", encoder.encode("fdfg45"));
		t4.addPerfis(Perfil.ADMIN);

		Cliente c1 = new Cliente(null, "Tadeu Borges", "87730613107", "tadeu.borges@mail.com",
				encoder.encode("fds72456"));
		Cliente c2 = new Cliente(null, "Maria Julia", "60122523407", "maria.julia@mail.com",
				encoder.encode("rec1463v"));
		Cliente c3 = new Cliente(null, "Otavio Gabriel", "83877218679", "ogresende@mail.com",
				encoder.encode("fdgf46hf"));

		Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Primeiro Chamado", "Primeira Instacia", t2,
				c2);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		chamadoRepository.saveAll(Arrays.asList(ch1));

	}

}
