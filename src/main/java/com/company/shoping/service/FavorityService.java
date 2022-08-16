package com.company.shoping.service;

import com.company.shoping.dto.AddFavoriteCommand;
import com.company.shoping.dto.AddFavoriteResponse;

public interface FavorityService {
    AddFavoriteResponse addFavoriteProduct(AddFavoriteCommand command);
    void deleteFavorityProduct(Long id);
}
