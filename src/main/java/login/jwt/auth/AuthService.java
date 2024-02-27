package login.jwt.auth;

import login.jwt.Repository.UserRepository;
import login.jwt.User.Role;
import login.jwt.User.User;
import login.jwt.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login( LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request){
     User user = User.builder()
             .username(request.getUsername())
             .password(request.getPassword())
             .firstname(request.getFirstname())
             .lastname(request.getLastname())
             .country(request.getCountry())
             .role(Role.USER)
             .build();

     userRepository.save(user);

     return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
