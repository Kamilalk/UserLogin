package Krukowska.UserLogin.demo.registration;

import Krukowska.UserLogin.demo.appuser.AppUser;
import Krukowska.UserLogin.demo.appuser.AppUserRole;
import Krukowska.UserLogin.demo.appuser.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private AppUserService appUserService;
    private EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator
                .test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

}
