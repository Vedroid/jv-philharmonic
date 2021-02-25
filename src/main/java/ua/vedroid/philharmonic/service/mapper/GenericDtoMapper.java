package ua.vedroid.philharmonic.service.mapper;

public interface GenericDtoMapper<E, D> {
    D toDto(E entity);
}
