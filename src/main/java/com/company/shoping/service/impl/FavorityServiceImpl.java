package com.company.shoping.service.impl;

import com.company.shoping.dto.AddFavoriteCommand;
import com.company.shoping.dto.AddFavoriteResponse;
import com.company.shoping.mapper.FavoriteMapper;
import com.company.shoping.repository.FavoriteRepository;
import com.company.shoping.repository.ProductRepository;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.FavorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavorityServiceImpl implements FavorityService {
    private final UserRepository userRepository;
    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;


    @Override
    public AddFavoriteResponse addFavoriteProduct(AddFavoriteCommand command) {
        userRepository.findById(command.getUserId()).orElseThrow(() -> new RuntimeException("exception.user.not-found"));
        productRepository.findById(command.getProductId()).orElseThrow(() -> new RuntimeException("exception.product.not-found"));
        var favority = FavoriteMapper.INSTANCE.favoriteCommandToFavorityEntity(command);
        favoriteRepository.save(favority);
        return new AddFavoriteResponse(favority.getId());
    }

    @Override
    public void deleteFavorityProduct(Long id) {
        favoriteRepository.deleteById(id);
    }
}
