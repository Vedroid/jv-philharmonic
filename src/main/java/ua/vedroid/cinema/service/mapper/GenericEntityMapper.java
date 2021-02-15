package ua.vedroid.cinema.service.mapper;

public interface GenericEntityMapper<E, D> {
    E toEntity(D dto);
}
