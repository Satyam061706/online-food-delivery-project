package in.satyamsharma.foodiesapi.service;

import in.satyamsharma.foodiesapi.io.FoodRequest;
import in.satyamsharma.foodiesapi.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {

    String uploadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request, MultipartFile file);

    List<FoodResponse> readFoods();

    FoodResponse readFood(String id);

    void deleteFile(String filename);

    void deleteFood(String id);
}
