package in.satyamsharma.foodiesapi.service;

import in.satyamsharma.foodiesapi.entity.FoodEntity;
import in.satyamsharma.foodiesapi.io.FoodRequest;
import in.satyamsharma.foodiesapi.io.FoodResponse;
import in.satyamsharma.foodiesapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String uploadFile(MultipartFile file) {

        try {
            // Ensure directory exists
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate unique filename
            String extension = file.getOriginalFilename()
                    .substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID() + extension;

            // Save file
            Path filePath = Paths.get(uploadDir, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // Return public URL
            return "http://localhost:8080/images/" + fileName;

        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "File upload failed",
                    e
            );
        }
    }

    @Override
    public FoodResponse addFood(FoodRequest request, MultipartFile file) {
        FoodEntity entity = convertToEntity(request);
        entity.setImageUrl(uploadFile(file));
        return convertToResponse(foodRepository.save(entity));
    }

    @Override
    public List<FoodResponse> readFoods() {
        return foodRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoodResponse readFood(String id) {
        FoodEntity entity = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found: " + id));
        return convertToResponse(entity);
    }

    @Override
    public void deleteFood(String id) {
        FoodEntity entity = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found: " + id));

        String fileName = entity.getImageUrl()
                .substring(entity.getImageUrl().lastIndexOf("/") + 1);

        deleteFile(fileName);
        foodRepository.deleteById(id);
    }

    public void deleteFile(String fileName) {
        try {
            Path filePath = Paths.get(uploadDir, fileName);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "File deletion failed",
                    e
            );
        }
    }

    private FoodEntity convertToEntity(FoodRequest request) {
        return FoodEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .price(request.getPrice())
                .build();
    }

    private FoodResponse convertToResponse(FoodEntity entity) {
        return FoodResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}