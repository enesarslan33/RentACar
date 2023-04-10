package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GettAllModelsResponse;
import lombok.AllArgsConstructor;

@RestController // annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsControllers {

	private ModelService modelService;
	
	@GetMapping()
	public List<GettAllModelsResponse> getAll() {
		return modelService.getAll();

	}
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateModelRequest createModelRequest) {
		
		this.modelService.add(createModelRequest);
	}
}
