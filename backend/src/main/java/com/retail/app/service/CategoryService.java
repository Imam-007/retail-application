package com.retail.app.service;

import com.retail.app.io.CategoryRequest;
import com.retail.app.io.CategoryResponse;

public interface CategoryService {
    CategoryResponse addCategory(CategoryRequest request);
}
