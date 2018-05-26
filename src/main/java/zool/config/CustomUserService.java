package zool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import zool.domain.dao.oasqlserver.ManageMapper;
import zool.domain.dto.manage.UserDto;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {

    @Autowired
    ManageMapper manageMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = manageMapper.getUserInfo(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(user.getUsername(),user.getPswd(),authorities);
    }

}
