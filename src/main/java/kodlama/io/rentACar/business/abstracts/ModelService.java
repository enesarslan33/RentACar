package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GettAllModelsResponse;

public interface ModelService {

	List<GettAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
