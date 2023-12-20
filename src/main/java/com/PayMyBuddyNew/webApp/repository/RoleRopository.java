package com.PayMyBuddyNew.webApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.PayMyBuddyNew.webApp.models.Role;

public interface RoleRopository extends CrudRepository<Role,Integer> {

	public Role findByName(String name);
}
