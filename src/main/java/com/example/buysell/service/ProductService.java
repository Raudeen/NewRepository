package com.example.buysell.service;

import com.example.buysell.model.Image;
import com.example.buysell.model.Product;
import com.example.buysell.model.User;
import com.example.buysell.repository.ProductRepository;
import com.example.buysell.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    public List<Product> list(String title){
       if (title != null) {
           return productRepository.findByTitle(title);
       } else {
           return productRepository.findAll();
       }
    }
    public void saveProduct(Principal principal ,Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        product.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0){
            image1 = toImageIEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);

        }
        if(file2.getSize() != 0){
            image2 = toImageIEntity(file2);
            product.addImageToProduct(image2);

        }
        if(file3.getSize() != 0){
            image3 = toImageIEntity(file3);
            product.addImageToProduct(image3);

        }
        log.info("Saving new. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());
        Product productFromDB = productRepository.save(product);
        productFromDB.setPreviewImageId(productFromDB.getImages().get(0).getId());
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageIEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
