package com.baie.oauth2.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private final static Set<User> users = new HashSet<>();

	static {
		users.add(new User("test-user1","123456", new HashSet<GrantedAuthority>()));
		users.add(new User("test-user2","123451", new HashSet<GrantedAuthority>()));
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		if ("admin".equalsIgnoreCase(name)) {
			User user = mockUser();
			return user;
		} else {
			Optional<User> user = users.stream().filter(i->i.getUsername().equals(name)).findFirst();
			return user.map(i->i).orElse(null);
		}
	}

	private User mockUser() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("admin"));
		User user = new User("admin","123456",authorities);
		return user;
	}
}
