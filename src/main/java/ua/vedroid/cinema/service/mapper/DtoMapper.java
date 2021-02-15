package ua.vedroid.cinema.service.mapper;

public interface DtoMapper<E, Q, P> {
    P toDto(E entity);

    E toEntity(Q dto);
}
