package br.com.johnatan.simulated.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.johnatan.simulated.dtos.outputs.RankOutputDTO;
import br.com.johnatan.simulated.dtos.outputs.SimulatedOutputDTO;
import br.com.johnatan.simulated.services.SimulatedService;

@RestController
@RequestMapping("simulated")
public class SimulatedResource {

	@Autowired
	private SimulatedService simulatedService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllSimulated(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		List<SimulatedOutputDTO> simulated = new ArrayList<>();
	    Pageable paging = PageRequest.of(page, size);
		
		Page<SimulatedOutputDTO> pageSimulated = simulatedService.findAll(paging);
		simulated = pageSimulated.getContent();
		
		Map<String, Object> response = new HashMap<>();
		response.put("simulated", simulated);
		response.put("currentPage", pageSimulated.getNumber());
		response.put("totalItems", pageSimulated.getTotalElements());
		response.put("totalPages", pageSimulated.getTotalPages());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "rank/{id}")
	public ResponseEntity<RankOutputDTO> getRank(@PathVariable("id") Long id) {
		RankOutputDTO rank = simulatedService.getRank(id);
		
		return new ResponseEntity<>(rank, HttpStatus.OK); 
	}

}
