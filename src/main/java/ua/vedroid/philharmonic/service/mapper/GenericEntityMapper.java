package ua.vedroid.philharmonic.service.mapper;

public interface GenericEntityMapper<E, D> {
    E toEntity(D dto);
}
