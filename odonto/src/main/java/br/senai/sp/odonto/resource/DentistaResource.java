package br.senai.sp.odonto.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.odonto.model.Dentista;
import br.senai.sp.odonto.repository.DentistaRepository;

@RestController
@RequestMapping("/odonto")
public class DentistaResource {
	
	@Autowired
	private DentistaRepository dentistaRepository;
	
//	Pegar todos os dentistas
	@GetMapping("/dentistas")
	public List<Dentista> getDentistas() {
		return dentistaRepository.findAll();
	}
	
//	Criar um novo dentista
	@PostMapping("/dentistas")
	@ResponseStatus(HttpStatus.CREATED)
	public Dentista gravar(@Valid @RequestBody Dentista dentista) {
		Dentista novoDentista = dentistaRepository.save(dentista);
		
		return novoDentista;
	}
	
//	Consultar um dentista pelo código
	@GetMapping("dentistas/{codigo}")
	public ResponseEntity<?> getDentista(@PathVariable Long codigo) {
		Optional dentistaConsultado = dentistaRepository.findById(codigo);
		return dentistaConsultado.isPresent() 
				? ResponseEntity.ok(dentistaConsultado.get())
				: ResponseEntity.notFound().build();
		}
	
//	Deletar um dentista
	@DeleteMapping("/dentistas/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDentista(@PathVariable Long codigo) {
		dentistaRepository.deleteById(codigo);
		
	}
	
//	Editar um dentista
	@PutMapping("/dentistas/{codigo}")
	public ResponseEntity<Dentista> atualiazar(@PathVariable Long codigo, @Valid @RequestBody Dentista dentista) {
		Dentista dentistaAtual = dentistaRepository.findById(codigo).get();
		
		dentistaAtual = dentista;
	}
	
}
