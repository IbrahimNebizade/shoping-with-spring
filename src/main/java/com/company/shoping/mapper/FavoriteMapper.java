package com.company.shoping.mapper;

import com.company.shoping.dto.AddFavoriteCommand;
import com.company.shoping.model.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class FavoriteMapper {
    public static final FavoriteMapper INSTANCE = Mappers.getMapper(FavoriteMapper.class);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "user.id",source = "command.userId")
    @Mapping(target = "product.id",source = "command.productId")
    public abstract Favorite favoriteCommandToFavorityEntity(AddFavoriteCommand command);
}
