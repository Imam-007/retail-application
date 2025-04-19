package com.retail.app.service.impl;

import com.retail.app.entity.Category;
import com.retail.app.io.CategoryRequest;
import com.retail.app.io.CategoryResponse;
import com.retail.app.repository.CategoryRepository;
import com.retail.app.service.CategoryService;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Builder
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse addCategory(CategoryRequest request) {
        Category newCategory = convertToEntity(request);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    private CategoryResponse convertToResponse(Category newCategory) {
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }

    private Category convertToEntity(CategoryRequest request) {
        return Category.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }
}
