package com.infosupport.jwt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    void setup(){
        userRepository = new UserRepository();
        userRepository.em = mock(EntityManager.class);
    }

    @DisplayName("Should pass the right query to the EntityManager")
    @Test
    void getAll() {
        // Arrange
        var typedQueryMock = mock(TypedQuery.class);
        when(userRepository.em.createQuery(anyString(), any())).thenReturn(typedQueryMock);

        // Act
        userRepository.getAll();

        // Assert
        verify(userRepository.em).createQuery("SELECT u FROM User u", User.class);
    }

    @DisplayName("Should call em.find() with the right parameters")
    @Test
    void get() {
        var uuid = UUID.randomUUID();

        // Arrange
        // Act
        userRepository.get(uuid);

        // Assert
        verify(userRepository.em).find(User.class, uuid);
    }

    @DisplayName("Should call em.persist with a new User instance")
    @Test
    void add() {
        // Arrange
        var username = "joepdekat";
        var password = "iklaathannostruikelen";
        var roles = Set.of("huisdier");

        var user = new User(username, password, roles);

        // Act
        userRepository.add(username, password, roles);

        // Assert
        verify(userRepository.em).persist(user);
    }

    @Test
    void delete() {
        // Arrange
        UUID uuid = UUID.randomUUID();
        var userRepoSpy = Mockito.spy(UserRepository.class);
        userRepoSpy.em = mock(EntityManager.class);

        var user = new User();
        Mockito.when(userRepoSpy.get(uuid)).thenReturn(user);

        // Act
        userRepoSpy.delete(uuid);

        // Assert
        verify(userRepoSpy.em).remove(user);
    }

    @Test
    void findByUsernameAndPassword() {
        // Arrange
        String username = "joep";
        String password = "ikeethannosontbijt";
        String digestedPassword = "uc2Gi5vAWMo/YeyffAxlyy8rGnY+N7CuXp4/Uk8/xNo=";
        Set<String> roles = Set.of("gebruiker");
        UserDto expectedUser = new UserDto(username, digestedPassword, roles);
        User userEntity = new User(username, password, roles);

        var typedQueryMock = mock(TypedQuery.class);
        when(userRepository.em.createQuery(anyString(), any())).thenReturn(typedQueryMock);
        when(typedQueryMock.setParameter(anyString(), anyString())).thenReturn(typedQueryMock);
        when(typedQueryMock.getSingleResult()).thenReturn(userEntity);

        // Act
        UserDto actualUser = userRepository.findByUsernameAndPassword(username, password);

        try (var userDtoStaticMock = mockStatic(UserDto.class);
             var passwordUtilStaticMock = mockStatic(PasswordUtil.class)) {
            userDtoStaticMock.when(() -> UserDto.fromEntity(any())).thenReturn(expectedUser);
            passwordUtilStaticMock.when(() -> PasswordUtil.digest(any())).thenReturn(digestedPassword);

            // Assert
            assertThat(actualUser).isEqualTo(expectedUser);
            verify(userRepository.em).createQuery(
                    """
                    SELECT u
                    FROM User u
                    WHERE u.username = :username AND u.password = :password
                    """, User.class);
            verify(typedQueryMock).setParameter("username", username);
            verify(typedQueryMock).setParameter("password", digestedPassword);
        }
    }

    @AfterEach
    public void verifyNoMoreInteractionsWithEm() {
        verifyNoMoreInteractions(userRepository.em);
    }
}