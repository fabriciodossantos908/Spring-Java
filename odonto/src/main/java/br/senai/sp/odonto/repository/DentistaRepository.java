package br.senai.sp.odonto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sp.odonto.model.Dentista;

// usando o JpaRepository, é possível falar que a interface irá manipular essa tabela
public interface DentistaRepository extends JpaRepository<Dentista, Long>{

}
