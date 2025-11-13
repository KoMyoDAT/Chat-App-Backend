/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.chat.app.Enitity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

/**
 * UserEntity Class.
 * <p>
 * </p>
 *
 * @author kyi min khant
 */

@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    private String password;

    private boolean active = true;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    // Relationships
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<MessageEntity> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<MessageEntity> receivedMessages = new ArrayList<>();

    // Friend requests
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<FriendRequestEntity> sentRequests = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<FriendRequestEntity> receivedRequests = new ArrayList<>();

    // Groups user belongs to
    @ManyToMany(mappedBy = "members")
    private Set<GroupChatEntity> groups = new HashSet<>();

    // Getters and Setters
}
