package ua.vedroid.cinema.service.mapper;

public interface GenericDtoMapper<E, D> {
    D toDto(E entity);
}
