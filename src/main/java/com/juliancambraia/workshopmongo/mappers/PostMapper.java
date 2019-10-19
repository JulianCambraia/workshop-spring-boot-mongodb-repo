package com.juliancambraia.workshopmongo.mappers;

import com.juliancambraia.workshopmongo.domain.Post;
import com.juliancambraia.workshopmongo.dto.PostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostDTO dto);

    PostDTO toDto(Post entity);

    List<PostDTO> toDtos(List<Post> posts);
}
