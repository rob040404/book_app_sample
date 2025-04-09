package com.bookworld.lists.model;

import com.bookworld.user.model.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_lists")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_list {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user_list;
	
	//Un usuario puede tener muchas listas
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable =false)
	private UserEntity user;
	
	@Column(nullable = false)
	private String list_name;
	
	
}
