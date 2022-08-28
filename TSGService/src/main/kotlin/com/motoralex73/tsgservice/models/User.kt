package com.motoralex73.tsgservice.models
import sun.jvm.hotspot.debugger.cdbg.EnumType
import java.util.Set

@Entity
@Table(name = "usr")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var username: String = ""
    var password: String = ""
    var active = false

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    lateinit var roles: Set<Role>

    @JvmName("getId1")
    fun getId(): Long {
        return id
    }

    @JvmName("setId1")
    fun setId(id: Long) {
        this.id = id
    }

    @JvmName("getUsername1")
    fun getUsername(): String {
        return username
    }

    @JvmName("setUsername1")
    fun setUsername(username: String) {
        this.username = username;
    }

    @JvmName("getPassword1")
    fun getPassword(): String {
        return password
    }

    @JvmName("setPassword1")
    fun setPassword(password: String) {
        this.password = password;
    }

    fun isActive(): Boolean {
        return active;
    }

    @JvmName("setActive1")
    fun setActive(active: Boolean) {
        this.active = active;
    }

    @JvmName("getRoles1")
    fun getRoles(): Set<Role> {
        return roles;
    }

    @JvmName("setRoles1")
    fun setRoles(roles: Set<Role>) {
        this.roles = roles
    }
}