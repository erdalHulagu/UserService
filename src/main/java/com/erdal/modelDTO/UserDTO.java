package com.erdal.modelDTO;

	import java.time.LocalDateTime;

	public class UserDTO {
		
		
		private String fullName;
		
		private String email;
		
		private String phone;
		
		private String role;
		
		private LocalDateTime creatAt;
		
		private LocalDateTime updateAt;
		
		
		

		public UserDTO(String fullName, String email, String phone, String role, LocalDateTime creatAt,
				LocalDateTime updateAt) {
			this.fullName = fullName;
			this.email = email;
			this.phone = phone;
			this.role = role;
			this.creatAt = creatAt;
			this.updateAt = updateAt;
			
		}

		public UserDTO () {}
		
		
		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		
		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public LocalDateTime getCreatAt() {
			return creatAt;
		}

		public void setCreatAt(LocalDateTime creatAt) {
			this.creatAt = creatAt;
		}

		public LocalDateTime getUpdateAt() {
			return updateAt;
		}

		public void setUpdateAt(LocalDateTime updateAt) {
			this.updateAt = updateAt;
		}
		
	}
	

