package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GettAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GettAllModelsResponse> getAll() {
List<kodlama.io.rentACar.entities.concretes.Model> models = modelRepository.findAll();
		

		List<GettAllModelsResponse> modelsResponse = models.stream().map(model->this.modelMapperService.forResponse()
				.map(model, GettAllModelsResponse.class)).collect(Collectors.toList());
		
	    return modelsResponse;
		
		
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		Model model =this.modelMapperService.forRequest().map(createModelRequest , Model.class);
		
		this.modelRepository.save(model);
		
	}

	
}
