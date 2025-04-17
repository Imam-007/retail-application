package com.retail.app.controller;

import com.retail.app.io.CategoryRequest;
import com.retail.app.io.CategoryResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    public CategoryResponse addCategory(@RequestBody CategoryRequest request){

    }
}
