package com.zj.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

//	public List<User> getUserByPage(Integer index,Integer size) {
//		Page<User> page = new Page<User>(index, size);
//		QueryWrapper<User> qw = new QueryWrapper<User>();
//		Page<User> userPage = userMapper.selectPage(page, qw);
//		List<User> records = userPage.getRecords();
//		return records;
//	}
	
	@Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
//		UserDetails user = userMapper.loadUserByUsername(s);

		IntegrationAuthentication integrationAuthentication = IntegrationAuthenticationContext.get();
		//判断是否是集成登录
		if (integrationAuthentication == null) {
			integrationAuthentication = new IntegrationAuthentication();
		}
		User user = new User();
		user.setUsername(s);
		user.setPassword(passwordEncoder.encode(integrationAuthentication.getAuthParameter("password")));
//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("NO ROLES");
//		grantedAuthorities.add(grantedAuthority);
//		user.getAuthorities()
//            throw new UsernameNotFoundException("该用户不存在！");

//        user.setRoles(userMapper.getUserRolesByUserId(user.getId()));
        return user;
    }
	
}
