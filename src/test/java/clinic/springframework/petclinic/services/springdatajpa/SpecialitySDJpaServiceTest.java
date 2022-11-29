package clinic.springframework.petclinic.services.springdatajpa;

import clinic.springframework.petclinic.model.Speciality;
import clinic.springframework.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpecialitySDJpaServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;

    @InjectMocks
    SpecialitySDJpaService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void delete() {
        service.delete(new Speciality());
    }

    @Test
    void deleteById(){
        service.deleteById(1l);

        verify(specialtyRepository).deleteById(1l); //Por padr?o verifica se ? chamado 1 vez (times(1))
    }

    @Test
    void deleteByIdTimes(){
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository, times(2)).deleteById(1l);
    }

    @Test
    void deleteByIdAtLeastOnce(){ //pelo menos uma vez
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
    }

    @Test
    void deleteByIdAtLeast(){ //pelo menos X vezes
        service.deleteById(1l);
        service.deleteById(1l);
        service.deleteById(1l);
        service.deleteById(1l);

        verify(specialtyRepository, atLeast(3)).deleteById(1l);
    }

    @Test
    void deleteByIdAtMost(){ //no m?ximo X vezes
        service.deleteById(1l);

        verify(specialtyRepository, atMost(1)).deleteById(1l);
    }

    @Test
    void deleteByIdNever(){
        service.deleteById(1l);

        verify(specialtyRepository, never()).deleteById(5l);
    }
}